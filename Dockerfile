# Start with a base image containing Java runtime
FROM openjdk:17-jdk-alpine

# Add a label to your image
LABEL maintainer="shivaprasad.andy@gmail.com"

# Create a directory for the application
WORKDIR /app

# Copy the WAR file into the container (adjust the filename to match your WAR file)
COPY target/craftline.jar /app/app.jar

# Expose the port on which the Spring Boot app runs
EXPOSE 8080

RUN ls -al /app
# Run the Spring Boot application using the WAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
