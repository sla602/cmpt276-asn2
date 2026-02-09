## Testing Strategy

This project uses a combination of Web MVC slice tests and JPA persistence tests.

- @WebMvcTest is used to test controller behavior, request/response flow,
  validation, and redirects without starting the full application context.
- @DataJpaTest is used to verify persistence behavior with the database.

This approach keeps tests fast and focused while still covering all required features.

## How to Run Tests

```bash
./mvnw test

## Covered Test Cases

### Validation
- Rejects invalid email format
- Rejects scores outside the range [1,10]
- Rejects missing required name

### Controller / Web Tests
- GET / returns 200 and contains ratings
- POST /ratings success redirects to index
- POST /ratings failure redisplays form with errors

### Persistence
- Saving a StaffRating persists correctly
- Deleting a StaffRating removes it from the database

