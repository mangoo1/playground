# Build: docker build -t timg .
# Run: docker run -p 80:8080 timg

FROM openjdk:17-alpine
EXPOSE 8080
ARG JAR_FILE=build/libs/springboot3-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} my-app.jar
ENTRYPOINT ["java","-jar","/my-app.jar"]