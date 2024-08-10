# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src /app/src

# Package the application into a WAR file
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM openjdk:17-jdk-slim

# Install Tomcat using the valid URL
RUN apt-get update && \
    apt-get install -y wget && \
    wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.93/bin/apache-tomcat-9.0.93.tar.gz && \
    tar xzf apache-tomcat-9.0.93.tar.gz -C /opt/ && \
    ln -s /opt/apache-tomcat-9.0.93 /opt/tomcat && \
    rm apache-tomcat-9.0.93.tar.gz

# Set the working directory
WORKDIR /opt/tomcat/webapps

# Copy the WAR file from the build stage and rename it to ROOT.war
COPY --from=build /app/target/web2_be-0.0.1-SNAPSHOT.war /opt/tomcat/webapps/ROOT.war

# Expose the port Tomcat runs on
EXPOSE 8080

# Start Tomcat
CMD ["/opt/tomcat/bin/catalina.sh", "run"]