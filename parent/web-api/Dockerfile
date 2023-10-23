FROM eclipse-temurin:17-jdk-focal

MAINTAINER haktor.com

ADD target/web-api-0.0.1-SNAPSHOT.jar webapp-0.0.1-SNAPSHOT.jar

EXPOSE 9092

ENTRYPOINT ["java", "-jar", "webapp-0.0.1-SNAPSHOT.jar"]