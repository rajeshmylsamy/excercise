FROM openjdk:8-jdk-alpine
LABEL maintainer="rajesh.mylsamy@gmail.com"
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/FootballLeague-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} football-league.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/football-league.jar"]



