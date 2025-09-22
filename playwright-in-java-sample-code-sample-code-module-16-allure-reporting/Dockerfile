FROM maven:3.9.6-eclipse-temurin-17

# Install system dependencies
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# Copy pom.xml first for better caching
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Install Playwright browsers
RUN mvn exec:java -e -Dexec.mainClass="com.microsoft.playwright.CLI" -Dexec.args="install"

# Compile the project
RUN mvn clean compile

# Run tests
CMD ["mvn", "verify", "-f", "pom-ci.xml"]