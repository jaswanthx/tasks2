# Use a minimal JDK 17 image for running the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file into the container
# This copies the JAR from your local 'target' folder, renaming it to app.jar
COPY target/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]