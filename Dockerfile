FROM amazoncorretto:8

WORKDIR /app
COPY target/oms-foundation-0.0.1-SNAPSHOT.jar oms-foundation.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","oms-foundation.jar"]