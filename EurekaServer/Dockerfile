FROM openjdk:8
ARG JAR_FILE=target/*.jar
RUN mkdir /opt/eureka-server
COPY ${JAR_FILE} /opt/eureka-server/EurekaServer.jar
ENTRYPOINT ["java", "-jar","/opt/eureka-server/EurekaServer.jar"]


