FROM openjdk:8
# EXPOSE 8080
ADD target/spring-web-test.jar spring-web-test.jar
ENTRYPOINT ["java", "-jar", "/spring-web-test.jar"]