# Quiz-App-Microservices
Quiz-App-Microservices is a microservices based Java Application, developed on springboot, Restful Webservices, Spring cloud eureka server, feign client, hibernate, JPA, maven with thymeleaf as frontend templating engine, can be use for the assessment of student by the lecturer during lecture.

##### How to build the application
The build system is used in these microservices application is Maven, Following are the steps to build these microservices.

- Clone the repository into your IDE, I used IntelliJ IDEA.
- You will see Maven module up right sidebar of IDE.
- If you didn't get maven module, go to View -> Tool Windows -> and select Maven.
- Now in Maven module expand Lifecycle and click on clean for each spring boot microservice applications.
- After Clean click on install for each spring boot microservice applications.
- You will get BUILD SUCCESS message in your terminal window and relevant Jar files will be generated in the target folder of the projects directories.

##### How to deploy the application
-Open project main module  **Quiz-App-Microservices** in explorer and open command prompt or go to your start menu and run cmd as administrator and move on to project directory.

- write command docker-compose build, each microservices start building
- After that write command docker-compose up, each microservices start running
- Make sure ports 8761,8080,8089 and 8088 are free to use as the microservices will deploy on these ports with database 3306,3307,3308
- Make sure all microservices are up and running
- Go to browser and type in url: http://localhost:8080/
- The application will start running

##### Architecture

The architecture of the application is microservices based distributed system architecture in which each microservice is connecting each other through eureka spring cloud server and each microservices is client for eureka server. Microservices exposing and consuming services through feign client, below or above (hierarchical structure) build with the following components:

**Spring Cloud Eureka Server:** This is the eureka spring cloud server for each microservices,  this eureka  server registered each microservice as an instance and it can be access by http://localhost:8761/

**QuizApp-Frontend:** This is the frontend or presentation layer for microservices developed on thymeleaf, this microservice is client for eureka server and it is communicating with other microservices through feign client

**Questions-Microservice and Result-Microservice:** These microservices contains the business logic that drives the application's core functionalities. Like making decisions, calculations, evaluations, and processing the data passing between each other and  responsible for interacting with databases to save and retrieve application data. These microservice are client for eureka server.
