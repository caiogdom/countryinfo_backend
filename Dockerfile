FROM openjdk:8-jdk-alpine
WORKDIR /opt/app
ARG JAR_FILE=target/countryinfo.jar
COPY ${JAR_FILE} countryinfo.jar
ENTRYPOINT ["java","-jar","countryinfo.jar"]