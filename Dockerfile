FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /app

COPY src /app/src
COPY pom.xml /app

RUN mvn clean package

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

COPY --from=builder /app/target/be-lab1-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
