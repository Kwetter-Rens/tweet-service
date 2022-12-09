FROM openjdk:17-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} tweet-service.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "tweet-service.jar"]