FROM maven:3.8.1-openjdk-17 as builder

COPY . /src
RUN cd /src && \
  mvn clean && \
  mvn package

FROM openjdk:17-jdk-alpine3.13

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=builder /src/target/*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
