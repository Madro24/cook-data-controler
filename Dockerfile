FROM openjdk:8-jre-alpine
WORKDIR /apps/cook/jar
COPY ./target/cook-data-controller.jar ./
CMD java -jar cook-data-controller.jar
