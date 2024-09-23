FROM ubuntu:latest
LABEL authors="fabiokaz@gmail.com"

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

WORKDIR /app
COPY --from=build ./app/target/*.jar ./registration-data-brazilian-company-0.0.1.jar
ENTRYPOINT ["java", "-jar", "registration-data-brazilian-company-0.0.1.jar"]