FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dpayvision.username=code-challenge", "-Dpayvision.password=payvisioner", "-jar","/app.jar"]
