FROM openjdk:21-jdk-slim
ARG JAR_FILE=build/libs/market-1.0.0.jar
COPY ${JAR_FILE} app.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=pdn", "app.jar"]