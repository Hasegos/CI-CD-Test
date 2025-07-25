
# 빌드 스테이지
FROM maven:3.8.4-openjdk-17 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

# 실행 스테이지 -> 빌드 스테이지를 실행시킨후 실행 스테이지를 실행한다

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

CMD ["java","-jar", "app.jar"]