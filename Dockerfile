# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim
MAINTAINER Michael Larsen
COPY target/accountsT-0.0.1-SNAPSHOT.jar accountsT-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","accountsT-0.0.1-SNAPSHOT.jar"]