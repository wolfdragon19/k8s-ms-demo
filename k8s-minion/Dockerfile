FROM openjdk:8-jdk-alpine
ENV PORT 9080
EXPOSE 9080
COPY target/*.jar /opt/app.jar
WORKDIR /opt
CMD ["java", "-jar", "app.jar"]
