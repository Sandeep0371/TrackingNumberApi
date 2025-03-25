# Use an official Maven image as the base image
FROM maven:3.8.4-openjdk-17.0.1-slim AS build
# Set the working directory in the container
WORKDIR C:\Users\sandy\Downloads\tracking-number-api
# Copy the pom.xml and the project files to the container
COPY pom.xml .
COPY src \tracking-number-api/src
# Build the application using Maven
RUN mvn clean package -DskipTests
# Use an official OpenJDK image as the base image
FROM openjdk:17-oracle
# Set the working directory in the container
COPY target/tracking-number-api-0.0.1-SNAPSHOT.jar tracking-number-api.jar
ENTRYPOINT ["java","-jar","/tracking-number-api.jar"]
# Copy the built JAR file from the previous stage to the container
#COPY - from=build \target/tracking-number-api-0.0.1-SNAPSHOT.jar .
# Set the command to run the application
CMD ["java", "-jar", "tracking-number-api.jar"]
