FROM java:8-jdk-alpine
COPY ./target/demo-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 9094

RUN addgroup -S cassandra && adduser -S cassandra -G cassandra && \
    chown -R cassandra:cassandra /usr/app

USER cassandra

ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]