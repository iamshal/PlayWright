FROM maven:3.9.6-openjdk-17-slim

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean compile

CMD ["mvn", "verify"]
