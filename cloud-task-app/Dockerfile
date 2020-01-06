#Start From Base Docker Image
FROM openjdk:8-jdk-alpine
VOLUME /tmp
#Add application jar to the container
COPY target/cloud-task-app.jar cloud-task-app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","cloud-task-app.jar"]