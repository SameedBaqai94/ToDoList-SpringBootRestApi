FROM openjdk:17
LABEL authors="chaotic"

VOLUME /tmp
EXPOSE 8080
COPY target/ToDoList-0.0.1-SNAPSHOT.jar todolist.jar

ENTRYPOINT ["java", "-jar","/todolist.jar"]