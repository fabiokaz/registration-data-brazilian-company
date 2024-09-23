FROM ubuntu:latest as build
LABEL authors="fabiokaz@gmail.com"

WORKDIR /app
COPY . .
RUN mvn clean package

FROM ubuntu:latest
WORKDIR /app
COPY --from=build ./app/target/*.jar ./registration-data-brazilian-company.jar
ENTRYPOINT ["java", "-jar", "registration-data-brazilian-company.jar"]