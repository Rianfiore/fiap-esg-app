#!/bin/bash

# Script de Deploy - CompareJa App
# Este script automatiza o deploy para Firebase App Distribution

set -e  # Exit on any error

# Cores para output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Função para log colorido
log_info() {
    echo -e "${GREEN}[INFO]${NC} $1"
}

log_warn() {
    echo -e "${YELLOW}[WARN]${NC} $1"
}

log_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

log_debug() {
    echo -e "${BLUE}[DEBUG]${NC} $1"
}

# Verificar parâmetros
if [ $# -eq 0 ]; then
    log_error "Uso: $0 <staging|production> [release-notes]"
    log_info "Exemplo: $0 staging 'Nova funcionalidade de busca'"
    exit 1
fi

ENVIRONMENT=$1
RELEASE_NOTES=${2:-"Deploy automático - $(date)"}

# Verificar se Firebase CLI está instalado
if ! command -v firebase &> /dev/null; then
    log_error "Firebase CLI não encontrado. Instalando..."
    npm install -g firebase-tools
fi

# Verificar se estamos no diretório correto
if [ ! -f "gradlew" ]; then
    log_error "gradlew não encontrado. Execute este script no diretório raiz do projeto."
    exit 1
fi

# Tornar gradlew executável
chmod +x ./gradlew

log_info "🚀 Iniciando deploy para ambiente: $ENVIRONMENT"

# Build da aplicação
log_info "Construindo aplicação..."
./gradlew clean assembleDebug

# Verificar se o APK foi gerado
APK_PATH="app/build/outputs/apk/debug/app-debug.apk"
if [ ! -f "$APK_PATH" ]; then
    log_error "APK não encontrado em $APK_PATH"
    exit 1
fi

log_info "✅ APK gerado com sucesso!"

# Configurar variáveis de ambiente baseadas no ambiente
case $ENVIRONMENT in
    "staging")
        FIREBASE_APP_ID=${FIREBASE_APP_ID_STAGING:-"1:123456789:android:staging123"}
        TESTER_GROUP="testers"
        log_info "📱 Deploy para STAGING"
        ;;
    "production")
        FIREBASE_APP_ID=${FIREBASE_APP_ID_PRODUCTION:-"1:123456789:android:production123"}
        TESTER_GROUP="production-testers"
        log_info "📱 Deploy para PRODUÇÃO"
        ;;
    *)
        log_error "Ambiente inválido: $ENVIRONMENT"
        log_info "Ambientes válidos: staging, production"
        exit 1
        ;;
esac

# Verificar se o token do Firebase está configurado
if [ -z "$FIREBASE_TOKEN" ]; then
    log_error "FIREBASE_TOKEN não configurado!"
    log_info "Configure o token com: export FIREBASE_TOKEN=seu_token_aqui"
    log_info "Ou adicione ao arquivo .env"
    exit 1
fi

# Fazer login no Firebase (se necessário)
log_info "Verificando autenticação Firebase..."
firebase projects:list > /dev/null 2>&1 || {
    log_info "Fazendo login no Firebase..."
    firebase login --token $FIREBASE_TOKEN
}

# Deploy para Firebase App Distribution
log_info "📤 Enviando APK para Firebase App Distribution..."
log_debug "App ID: $FIREBASE_APP_ID"
log_debug "Grupo: $TESTER_GROUP"
log_debug "Release Notes: $RELEASE_NOTES"

firebase appdistribution:distribute "$APK_PATH" \
    --app "$FIREBASE_APP_ID" \
    --groups "$TESTER_GROUP" \
    --release-notes "$RELEASE_NOTES"

if [ $? -eq 0 ]; then
    log_info "✅ Deploy realizado com sucesso!"
    log_info "📱 Aplicação disponível para o grupo: $TESTER_GROUP"
    log_info "📝 Release Notes: $RELEASE_NOTES"
else
    log_error "❌ Falha no deploy!"
    exit 1
fi

log_info "🎉 Deploy concluído com sucesso!"
