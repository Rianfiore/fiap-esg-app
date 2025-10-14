# Dockerfile para ambiente de build Android - CompareJa App
FROM openjdk:17-jdk-slim

# Instalar dependências do sistema
RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    git \
    curl \
    && rm -rf /var/lib/apt/lists/*

# Configurar variáveis de ambiente
ENV ANDROID_HOME=/opt/android-sdk
ENV ANDROID_SDK_ROOT=/opt/android-sdk
ENV PATH=$PATH:$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/platform-tools

# Criar diretório do Android SDK
RUN mkdir -p $ANDROID_HOME

# Baixar e instalar Android Command Line Tools
RUN wget -q https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip \
    && unzip commandlinetools-linux-11076708_latest.zip -d $ANDROID_HOME/ \
    && rm commandlinetools-linux-11076708_latest.zip

# Criar diretório cmdline-tools/latest
RUN mkdir -p $ANDROID_HOME/cmdline-tools/latest \
    && mv $ANDROID_HOME/cmdline-tools/* $ANDROID_HOME/cmdline-tools/latest/ 2>/dev/null || true

# Aceitar licenças e instalar componentes do Android SDK
RUN yes | sdkmanager --licenses
RUN sdkmanager --update
RUN sdkmanager "platform-tools" "platforms;android-34" "build-tools;34.0.0" "cmdline-tools;latest"

# Instalar Gradle
RUN wget -q https://services.gradle.org/distributions/gradle-8.5-bin.zip \
    && unzip gradle-8.5-bin.zip -d /opt/ \
    && rm gradle-8.5-bin.zip
ENV PATH=$PATH:/opt/gradle-8.5/bin

# Configurar diretório de trabalho
WORKDIR /app

# Copiar arquivos do projeto
COPY . .

# Dar permissões de execução para gradlew
RUN chmod +x ./gradlew

# Comando padrão para build
CMD ["./gradlew", "assembleDebug"]
