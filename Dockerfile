FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-Xmx512m", "-Dserver.port=${PORT}", "-jar","/app.jar"]

EXPOSE 8080