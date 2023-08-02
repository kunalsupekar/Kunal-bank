FROM hello-world/java:8
COPY  target/Banking_restapi-0.0.1-SNAPSHOT.jar  Banking_restapi-0.0.1-SNAPSHOT.jar
CMD  java -jar Banking_restapi-0.0.1-SNAPSHOT.jar


FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar Banking_restapi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080