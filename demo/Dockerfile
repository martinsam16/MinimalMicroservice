#FROM openjdk:8u262-jre-slim
FROM alpine

RUN apk add --no-cache ca-certificates openjdk8-jre-base bash

COPY target/demo-0.0.1-SNAPSHOT.jar demo.jar

EXPOSE 8083

CMD ["java", "-jar", "demo.jar"]