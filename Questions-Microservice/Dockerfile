FROM openjdk:8
ARG JAR_FILE=target/*.jar
RUN mkdir /opt/questions-microservice
COPY ${JAR_FILE} /opt/questions-microservice/Questions_Microservice.jar
ENTRYPOINT ["java", "-jar","/opt/questions-microservice/Questions_Microservice.jar"]


