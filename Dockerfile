# Use a base image with Java 17 (adjust if needed)
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the jar file into the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose port (adjust if needed)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]