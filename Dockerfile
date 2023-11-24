#FROM ubuntu:latest
#
#LABEL authors="ARJUN"
#
#ENTRYPOINT ["top", "-b"]
#
# FROM openjdk:19
# WORKDIR /app
# COPY  pom.xml .

# RUN mvn clean install

# # ARG JAR_FILE=G:/HRMS/backend/target/*.jar
# #COPY ${JAR_FILE} donation-mgmt-0.0.1-SNAPSHOT.jar
# COPY ./target/employee-0.0.1-SNAPSHOT.jar employee-0.0.1-SNAPSHOT.jar
# EXPOSE 8081
# ENTRYPOINT ["java","-jar","employee-0.0.1-SNAPSHOT.jar"]

# COPY . /home/api/emp

# WORKDIR /home/api/emp

# Use an official OpenJDK runtime as a parent image
# FROM openjdk:19

# # Install Maven
# RUN apt-get update && \
#     apt-get install -y maven && \
#     rm -rf /var/lib/apt/lists/*

# # Set the working directory in the container
# WORKDIR /app

# # Copy the application files into the container
# COPY pom.xml .
# COPY src src

# # Build the application
# RUN mvn clean install

# COPY ./target/employee-0.0.1-SNAPSHOT.jar employee-0.0.1-SNAPSHOT.jar

# # Specify the default command to run on startup
# CMD ["java", "-jar", "target/employee-0.0.1-SNAPSHOT.jar"]

# Use an official OpenJDK image with JDK (includes tools like apt-get)
FROM openjdk:11-jdk

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory in the container
WORKDIR /app

# Copy the application files into the container
COPY pom.xml .
COPY src src

ARG SKIP_TESTS=false

# Build the application
RUN mvn clean install -Dmaven.compiler.source=11 -Dmaven.compiler.target=11 ${SKIP_TESTS:+-DskipTests}


# Copy the application JAR file into the container
COPY ./target/employee-0.0.1-SNAPSHOT.jar employee-0.0.1-SNAPSHOT.jar

EXPOSE 8081

# Specify the default command to run on startup
CMD ["java", "-jar", "employee-0.0.1-SNAPSHOT.jar"]
#"--spring.profiles.active=prod", "--java.version=11"]



