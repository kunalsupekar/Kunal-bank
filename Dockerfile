


FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY  target/Banking_restapi-0.0.1-SNAPSHOT.jar  Banking_restapi-0.0.1-SNAPSHOT.jar
CMD  java -jar Banking_restapi-0.0.1-SNAPSHOT.jar
EXPOSE 8080