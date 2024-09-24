# Registration of Brazilian Companies

## About the Project

This is a Spring Boot project developed to create and query registration
data of Brazilian companies. It offers a REST API to manage company
information using the CNPJ as the main identifier.

## Technologies Used

-   Java 17
-   Spring Boot 3.3.4
-   Spring Data JPA
-   Spring Cloud OpenFeign
-   H2 Database (for development environment)
-   Springdoc OpenAPI (Swagger UI)
-   SLF4J and Logback for logging

## Features

-   Query a company by CNPJ
-   List all registered companies
-   Create a new company by providing only the CNPJ
-   Delete a company by CNPJ

## Getting Started

### Prerequisites

-   JDK 17
-   Maven

### Cloning the Repository

git clone https://github.com/fabiokaz/registration-data-brazilian-company.git

cd registration-data-brazilian-company

### Building and Running

mvn clean install
java -jar target/registration-data-brazilian-company-0.0.1.jar

### Alternatively, you can run using Maven:

mvn spring-boot:run

### API Documentation

The API documentation is available via Swagger UI. After starting the application, access:
http://localhost:8080/swagger-ui/index.html

### Endpoints
-   GET /v1/company/{cnpj}: Retrieves a company by CNPJ
-   GET /v1/company: Lists all companies
-   POST /v1/company: Creates a new company
-   DELETE /v1/company/{cnpj}: Deletes a company by CNPJ

### Configuration
The project uses H2 Database for the development environment. Configurations can be adjusted in the application.properties file.

### Logs
The project uses SLF4J with Logback for logging. Log configurations can be adjusted in the logback.xml file.

### Testing
To run the tests:
mvn test

### Contributing
Contributions are welcome!

### License
This project is licensed under the MIT License. See the LICENSE file for details.

### Developed by [fabiokaz@gmail.com]