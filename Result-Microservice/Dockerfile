FROM openjdk:8
ARG JAR_FILE=target/*.jar
RUN mkdir /opt/result-microservice
COPY ${JAR_FILE} /opt/result-microservice/Result_Microservice.jar
ENTRYPOINT ["java", "-jar","/opt/result-microservice/Result_Microservice.jar"]


