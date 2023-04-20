FROM openjdk:17-alpine
EXPOSE 8080
ARG JAR_FILE=build/libs/nttdata.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/app.jar"]