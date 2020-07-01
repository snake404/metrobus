#FROM adoptopenjdk:8-jdk-openj9-bionic AS build
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
EXPOSE 6969
ENTRYPOINT ["java","-jar","/home/app/target/metrobus.jar"]