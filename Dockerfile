
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar /app.jar
# The target/*.jar path was correct, but the destination in the container was wrong (/app.jar instead of /).
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8090
# The syntax of the Dockerfile is correct, no need to change anything here.
