FROM alpine

RUN apk add --no-cache openjdk8-jre-base

COPY target/demo-0.0.1-SNAPSHOT.jar demo.jar

EXPOSE 8083

CMD ["java", "-jar", "demo.jar"]