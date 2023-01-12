FROM openjdk:8
ARG JAR_FILE=target/*.jar
RUN mkdir /opt/quizapp-frontent
COPY ${JAR_FILE} /opt/quizapp-frontent/QuizAppFrontEnd.jar
ENTRYPOINT ["java", "-jar","/opt/quizapp-frontent/QuizAppFrontEnd.jar"]


