FROM maven:3.8.5-openjdk-17

WORKDIR /app

COPY pom.xml .

RUN mvn -B dependency:resolve

COPY src/ ./src/

RUN mvn -B package

CMD ["java", "-jar", "target/data-dictionary-generator.jar"]