<<<<<<< HEAD
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package

FROM openjdk:17-alpine3.14
EXPOSE 8080
COPY --from=build /app/target/dataDictionary-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

=======
FROM maven:3.8.5-openjdk-17

WORKDIR /app

COPY pom.xml .

RUN mvn -B dependency:resolve

COPY src/ ./src/

RUN mvn -B package

CMD ["java", "-jar", "target/data-dictionary-generator.jar"]
>>>>>>> 3ce1c82e11b4617413a437c0703d4e7a7992180e
