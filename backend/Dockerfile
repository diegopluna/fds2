FROM maven:3.9.9-amazoncorretto-23 AS build

WORKDIR /app

COPY . .
RUN mvn dependency:go-offline -B

RUN mvn clean install

ENTRYPOINT ["mvn", "-pl","docker", "spring-boot:run"]