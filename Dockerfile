
# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-jdk-alpine AS builder


# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml to the container
COPY pom.xml ./

# Download the project dependencies, but do not build the application yet
RUN mvn dependency:go-offline

# Copy the rest of the source code to the container
COPY src ./src

# Build the Spring Boot application
RUN mvn package

# Multi-stage build to reduce image size
FROM adoptopenjdk:17-jre-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the builder stage to the final image
COPY --from=builder /app/target/*.jar app.jar

# Expose the port that your Spring Boot application listens on (if necessary)
EXPOSE 8080

# Define the command to run your Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
