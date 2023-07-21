FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package

FROM openjdk:17-alpine3.14
EXPOSE 8080
COPY --from=build  /app/target/data-dictionary-generator.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

