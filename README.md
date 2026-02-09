## Staff Rating Application

### Features
- Create staff ratings
- View staff rating details
- Edit and delete ratings

### Tech Stack
- Spring Boot
- Thymeleaf
- JPA / PostgreSQL
- Maven
- Docker

### How to Run
./mvnw spring-boot:run

Email uniqueness is enforced at the controller level using a repository check.
User-friendly validation messages are shown instead of database exceptions.
