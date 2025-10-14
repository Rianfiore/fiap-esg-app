# CompareJa - Cidades ESG Inteligentes

## 📱 Sobre o Projeto

O **CompareJa** é uma aplicação Android desenvolvida em Kotlin com Jetpack Compose que permite aos usuários comparar preços de produtos em diferentes mercados, promovendo o consumo consciente e sustentável.

## 🏗️ Arquitetura

- **Frontend:** Android (Kotlin + Jetpack Compose)
- **Build System:** Gradle
- **Testes:** JUnit + Espresso
- **CI/CD:** GitHub Actions
- **Containerização:** Docker + Docker Compose
- **Deploy:** Firebase App Distribution

## 🚀 Como Executar Localmente com Docker

### Pré-requisitos
- Docker e Docker Compose instalados
- Git

### Passos para Execução

1. **Clone o repositório:**
```bash
git clone <url-do-repositorio>
cd fiap-esg-app
```

2. **Configure as variáveis de ambiente:**
```bash
cp env.example .env
# Edite o arquivo .env com suas configurações
```

3. **Execute com Docker Compose:**
```bash
# Build e execução completa
docker-compose up --build

# Apenas build
docker-compose run android-builder

# Apenas testes
docker-compose run android-tester

# Gerar relatórios
docker-compose run report-generator
```

4. **APKs gerados estarão em:**
- Debug: `app/build/outputs/apk/debug/app-debug.apk`
- Release: `app/build/outputs/apk/release/app-release.apk`

### Execução Manual (sem Docker)

1. **Instale o Android SDK**
2. **Execute os scripts:**
```bash
# Build completo
./scripts/build.sh

# Deploy (após configurar Firebase)
./scripts/deploy.sh staging "Release notes"
```

## 🔄 Pipeline CI/CD

### Ferramentas Utilizadas
- **GitHub Actions** para automação
- **Firebase App Distribution** para deploy
- **JaCoCo** para relatórios de cobertura

### Etapas do Pipeline

1. **Build e Testes** (trigger: push/PR)
   - Setup Java 17
   - Setup Android SDK
   - Cache de dependências
   - Execução de testes unitários
   - Análise de código (lint)
   - Build de APKs (debug e release)
   - Upload de artefatos

2. **Deploy Staging** (trigger: branch develop)
   - Download do APK debug
   - Deploy para Firebase App Distribution
   - Notificação para grupo de testers

3. **Deploy Produção** (trigger: branch main)
   - Download do APK release
   - Deploy para Firebase App Distribution
   - Notificação para grupo de produção

4. **Relatórios** (sempre executado)
   - Geração de relatório de cobertura
   - Upload de relatórios como artefatos

### Configuração Necessária

Configure os seguintes secrets no GitHub:
- `FIREBASE_TOKEN`: Token de autenticação do Firebase
- `FIREBASE_APP_ID_STAGING`: ID do app para staging
- `FIREBASE_APP_ID_PRODUCTION`: ID do app para produção

## 🐳 Containerização

### Dockerfile
```dockerfile
# Ambiente de build Android com:
# - OpenJDK 17
# - Android SDK 34
# - Build Tools 34.0.0
# - Gradle 8.5
```

### Docker Compose
```yaml
services:
  android-builder:    # Build principal
  android-tester:     # Testes instrumentados
  report-generator:   # Relatórios de cobertura
```

### Estratégias Adotadas
- **Multi-stage build** para otimização
- **Cache de dependências** para builds mais rápidos
- **Volumes persistentes** para SDK e Gradle
- **Isolamento de serviços** para diferentes tarefas

## 📊 Evidências de Funcionamento

### Screenshots do Pipeline
![Pipeline CI/CD](docs/images/pipeline-success.png)
*Pipeline executando com sucesso*

### Screenshots dos Ambientes
![Staging Environment](docs/images/staging-deploy.png)
*Deploy para ambiente de staging*

![Production Environment](docs/images/production-deploy.png)
*Deploy para ambiente de produção*

### Relatórios de Cobertura
![Coverage Report](docs/images/coverage-report.png)
*Relatório de cobertura de código*

## 🛠️ Tecnologias Utilizadas

### Desenvolvimento
- **Kotlin** - Linguagem principal
- **Jetpack Compose** - UI moderna
- **Android SDK 34** - Plataforma Android
- **Gradle** - Sistema de build

### DevOps
- **Docker** - Containerização
- **Docker Compose** - Orquestração
- **GitHub Actions** - CI/CD
- **Firebase App Distribution** - Deploy

### Testes
- **JUnit** - Testes unitários
- **Espresso** - Testes de UI
- **JaCoCo** - Cobertura de código

### Ferramentas
- **Android Studio** - IDE
- **Git** - Controle de versão
- **Firebase CLI** - Deploy

## 📁 Estrutura do Projeto

```
fiap-esg-app/
├── app/                          # Módulo principal Android
│   ├── src/main/java/           # Código fonte
│   ├── src/test/                # Testes unitários
│   ├── src/androidTest/         # Testes instrumentados
│   └── build.gradle.kts         # Configuração do módulo
├── .github/workflows/           # GitHub Actions
│   └── ci-cd.yml               # Pipeline principal
├── scripts/                     # Scripts de automação
│   ├── build.sh                # Script de build
│   └── deploy.sh               # Script de deploy
├── Dockerfile                   # Configuração Docker
├── docker-compose.yml          # Orquestração de serviços
├── env.example                 # Variáveis de ambiente
└── README.md                   # Documentação
```

## 🚨 Troubleshooting

### Problemas Comuns

1. **Erro de permissão no gradlew:**
```bash
chmod +x ./gradlew
```

2. **Erro de SDK Android:**
```bash
# Verificar se ANDROID_HOME está configurado
echo $ANDROID_HOME
```

3. **Erro de Firebase:**
```bash
# Fazer login no Firebase
firebase login
```

4. **Erro de Docker:**
```bash
# Verificar se Docker está rodando
docker --version
docker-compose --version
```

## 👥 Equipe

- **Rian Barbosa Fiore da Camara** - Desenvolvimento
- **Tiago Henrique Ramos da Silva** - DevOps
- **Erick Matheus da Silva Calixto** - Testes
- **Bruno Rodrigues Rocha** - Documentação

## 📄 Licença

Este projeto é parte do curso FIAP - Fase 6 DevOps.

---

**Última atualização:** $(date)
