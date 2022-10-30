FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} olympic-acc.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","olympic-acc.jar"]