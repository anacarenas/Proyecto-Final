FROM openjdk:8-jdk-alpine
ADD target/*.jar /usr/share/Config-Server.jar
EXPOSE 9010
ENTRYPOINT ["java", "-jar", "/usr/share/Config-Server.jar"]