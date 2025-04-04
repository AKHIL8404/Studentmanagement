# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and the source code to the container
COPY pom.xml /app/
COPY src /app/src

# Build the application (skip tests to speed up the build process)
RUN mvn clean package -DskipTests

# Add a debug step to list the contents of the target directory to check if the JAR file exists
RUN ls -l target/

# Copy the generated JAR file from the target directory
COPY target/StudentManagement1-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the Spring Boot application runs on (default is 8080)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
