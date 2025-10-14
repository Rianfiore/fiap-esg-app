#!/bin/bash

# Script de Build - CompareJa App
# Este script automatiza o processo de build da aplicação

set -e  # Exit on any error

echo "🚀 Iniciando build da aplicação CompareJa..."

# Cores para output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
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

# Verificar se estamos no diretório correto
if [ ! -f "gradlew" ]; then
    log_error "gradlew não encontrado. Execute este script no diretório raiz do projeto."
    exit 1
fi

# Tornar gradlew executável
chmod +x ./gradlew

# Limpar builds anteriores
log_info "Limpando builds anteriores..."
./gradlew clean

# Executar testes unitários
log_info "Executando testes unitários..."
./gradlew testDebugUnitTest

# Verificar se os testes passaram
if [ $? -eq 0 ]; then
    log_info "✅ Testes unitários passaram com sucesso!"
else
    log_error "❌ Testes unitários falharam!"
    exit 1
fi

# Executar lint
log_info "Executando análise de código (lint)..."
./gradlew lintDebug

# Build debug
log_info "Construindo APK debug..."
./gradlew assembleDebug

# Build release
log_info "Construindo APK release..."
./gradlew assembleRelease

# Gerar relatório de cobertura
log_info "Gerando relatório de cobertura de código..."
./gradlew jacocoTestReport

# Verificar se os APKs foram gerados
if [ -f "app/build/outputs/apk/debug/app-debug.apk" ]; then
    log_info "✅ APK debug gerado com sucesso!"
    ls -la app/build/outputs/apk/debug/
else
    log_error "❌ Falha ao gerar APK debug!"
    exit 1
fi

if [ -f "app/build/outputs/apk/release/app-release.apk" ]; then
    log_info "✅ APK release gerado com sucesso!"
    ls -la app/build/outputs/apk/release/
else
    log_error "❌ Falha ao gerar APK release!"
    exit 1
fi

# Verificar relatório de cobertura
if [ -d "app/build/reports/jacoco" ]; then
    log_info "✅ Relatório de cobertura gerado!"
    log_info "📊 Relatório disponível em: app/build/reports/jacoco/jacocoTestReport/html/index.html"
else
    log_warn "⚠️ Relatório de cobertura não foi gerado"
fi

log_info "🎉 Build concluído com sucesso!"
log_info "📱 APKs disponíveis em:"
log_info "   - Debug: app/build/outputs/apk/debug/app-debug.apk"
log_info "   - Release: app/build/outputs/apk/release/app-release.apk"
