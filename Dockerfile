FROM maven:3.9-amazoncorretto-17 as build
LABEL authors="fabiokaz@gmail.com"

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# final image
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build ./app/target/*.jar ./registration-data-brazilian-company.jar
ENTRYPOINT ["java", "-jar", "registration-data-brazilian-company.jar"]