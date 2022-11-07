FROM openjdk:17-alpine

EXPOSE 8081

ADD target/tweet-service.jar tweet-service.jar

ENTRYPOINT ["java", "-jar", "tweet-service.jar"]