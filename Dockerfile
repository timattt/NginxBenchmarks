FROM maven:3.8.4-openjdk-17 AS builder
COPY ./ ./
RUN mvn clean package
FROM eclipse-temurin:17-jre-alpine
COPY --from=builder /target/NginxBenchmarks-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]