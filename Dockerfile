FROM openjdk:21-jdk-alpine

WORKDIR /app

COPY . /app

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/build/libs/paidclinic-0.0.1-SNAPSHOT.jar"]