FROM openjdk:17-jdk-alpine

WORKDIR /app

#COPY . /app
COPY build.gradle settings.gradle gradlew /app/
COPY gradle /app/gradle
COPY src /app/src

RUN chmod +x ./gradlew
RUN ./gradlew build

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/build/libs/paidclinic-0.0.1-SNAPSHOT.jar"]
