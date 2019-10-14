# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="sumeet.it007@gmail.com"

# The application's jar file
ARG JAR_FILE=target/employee-api-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} employee-api.jar

# Run the jar file 
ENTRYPOINT ["java", "-jar", "employee-api.jar"]