# Demo Project

This is a Spring Boot demo project that includes user registration, authentication, and basic CRUD operations for users and students.

## Project Structure

- `src/main/java/com/example/demo`
  - `config` – Security configuration (`Securityconfig.java`)
  - `controller` – Controllers for handling HTTP requests (`UserController.java`, `StudentController.java`, `Hero.java`)
  - `dto` – Data Transfer Objects (`userdto.java`)
  - `model` – JPA entity models (`User.java`, `UserDetails_model.java`, `Student.java`)
  - `repository` – Spring Data JPA repositories (`Userrepository.java`, `Studentrepository.java`)
  - `service` – Service layer for business logic (`UserService.java`, `UserDetailservice_imp.java`, `StudentService.java`)
  - `DemoApplication.java` – Main Spring Boot application

- `src/main/resources`
  - `application.properties` – Application configuration

- `src/test/java/com/example/demo`
  - `DemoApplicationTests.java` – Test class

## Features

- User registration and login with Spring Security
- Custom `AuthenticationProvider` using `DaoAuthenticationProvider`
- Password encryption using `BCryptPasswordEncoder`
- CRUD operations for Students
- REST API endpoints for testing with Postman or frontend

## Requirements

- Java 17+
- Spring Boot 3.x
- Maven or Gradle
- MySQL (or any other database configured in `application.properties`)
## Reference 
![chart](Screenshot-2025-09-21-224214.png)

## Running the Application

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd demo
