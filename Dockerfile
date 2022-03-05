#FROM openjdk:17-oracle
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:17-oracle
ADD target/shopping.jar shopping.jar
ENTRYPOINT ["java","-jar","shopping.jar"]
EXPOSE 8080
