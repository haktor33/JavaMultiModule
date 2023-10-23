#Writing the Dockerfile

FROM eclipse-temurin:17-jdk-focal

MAINTAINER haktor.com

ADD target/web-api-0.0.1-SNAPSHOT.jar webapp-0.0.1-SNAPSHOT.jar

EXPOSE 9092

ENTRYPOINT ["java", "-jar", "webapp-0.0.1-SNAPSHOT.jar"]

##build our Docker image:

mvn package
docker image build -t haktor-web-api:latest .

##run our Docker image from the command line:

docker run -p 9092:9092 haktor-web-api:latest