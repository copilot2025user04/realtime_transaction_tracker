# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY realtime_transaction_tracker-0.0.1-SNAPSHOT.jar realtime-transaction-tracker-0.0.1-SNAPSHOT.jar

# Expose the port your application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "realtime-transaction-tracker-0.0.1-SNAPSHOT.jar"]
