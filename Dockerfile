# Start with a base image containing Java runtime
FROM openjdk:17-jdk-alpine

# Add a label to your image
LABEL maintainer="shivaprasad.andy@gmail.com"

# Create a directory for the application
WORKDIR /app

# Copy the WAR file into the container (adjust the filename to match your WAR file)
COPY target/craft-line-0.0.1-SNAPSHOT.war /app/app.war

# Expose the port on which the Spring Boot app runs
EXPOSE 8080

# Run the Spring Boot application using the WAR file
ENTRYPOINT ["java", "-jar", "/app/app.war"]
