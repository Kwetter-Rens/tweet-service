FROM adoptopenjdk/openjdk17:alpine-jre

COPY target/tweet-service.jar app.jar

CMD ["java", "-jar", "app.jar"]
