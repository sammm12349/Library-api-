# Library Management API

A RESTful API for managing a library's book inventory, built with Spring Boot and MySQL.

## Features

- ✅ Complete CRUD operations for books
- ✅ Advanced search and filtering (by author, title, ISBN, page count)
- ✅ Input validation with detailed error messages
- ✅ Global exception handling
- ✅ DTO pattern for clean API responses
- ✅ Comprehensive automated testing (32 test cases)

## Tech Stack

- **Backend:** Java 17, Spring Boot 3.x
- **Database:** MySQL 8.0
- **ORM:** Spring Data JPA / Hibernate
- **Testing:** Postman (automated test collection included)
- **Build Tool:** Maven

## API Endpoints

### CRUD Operations
- `GET /books/all` - Get all books
- `GET /books/find/{id}` - Get book by ID
- `POST /books/add` - Add new book
- `PUT /books/update` - Update existing book
- `DELETE /books/delete/{id}` - Delete book

### Search & Filter
- `GET /books/author?author={name}` - Search by author
- `GET /books/title?title={title}` - Search by title
- `GET /books/find/isbn/{isbn}` - Get by ISBN
- `GET /books/short?maxPages={num}` - Books under certain page count
- `GET /books/long?minPages={num}` - Books over certain page count
- `GET /books/pages?min={min}&max={max}` - Books in page range

## Setup & Installation

### Prerequisites
- Java 17 or higher
- MySQL 8.0 or higher
- Maven 3.6+

### Database Setup
```sql
CREATE DATABASE librarydb;
```

### Configuration
Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/librarydb
spring.datasource.username=your_username
spring.datasource.password=your_password
server.port=3030
```

### Run Application
```bash
mvn spring-boot:run
```

Application will start at `http://localhost:3030`

## Testing

The API includes 32 automated test cases covering:
- CRUD operations
- Search and filtering functionality
- Error handling (404, 400, 500)
- Data validation
- Response format verification

### Run Tests in Postman
1. Import `postman/Library-API-Tests.postman_collection.json`
2. Start the application
3. Run the collection

All tests should pass ✅

## Example Request

### Add a Book
```bash
POST http://localhost:3030/books/add
Content-Type: application/json

{
  "title": "The Hobbit",
  "author": "J.R.R. Tolkien",
  "isbn": "978-0547928227",
  "publisher": "Houghton Mifflin",
  "pages": 310
}
```

### Response
```json
{
  "id": 1,
  "title": "The Hobbit",
  "author": "J.R.R. Tolkien",
  "pages": 310,
  "isbn": "978-0547928227",
  "publisher": "Houghton Mifflin"
}
```

## Error Handling

The API returns consistent error responses:

### 404 Not Found
```json
{
  "timestamp": "2026-02-27T03:45:00",
  "status": 404,
  "error": "Not Found",
  "message": "Book not found with id: 999",
  "path": "/books/find/999"
}
```

### 400 Validation Error
```json
{
  "timestamp": "2026-02-27T03:45:00",
  "status": 400,
  "error": "Validation Failed",
  "validationErrors": {
    "title": "Title cannot be blank",
    "pages": "Pages must be at least 1"
  },
  "path": "/books/add"
}
```

## Project Structure
```
src/main/java/com/example/librarydb/
├── Controller/
│   └── BookController.java
├── Service/
│   └── BookService.java
├── Repo/
│   └── BookRepo.java
├── Domain/
│   └── Books.java
├── Dto/
│   ├── BookDTO.java
│   └── BookDTOMapper.java
└── Exception/
    ├── BookNotFoundException.java
    └── GlobalExceptionHandler.java
```

## Future Enhancements

- [ ] User authentication (Spring Security)
- [ ] Book borrowing/return functionality
- [ ] Pagination for large datasets
- [ ] Advanced filtering (multiple criteria)
- [ ] Book categories/genres

## Author

**Your Name**
- GitHub: [sammm12349](https://github.com/sammm12349)
- LinkedIn: [Samuel Spear](https://www.linkedin.com/in/samuel-spear-094606246/)

## License

This project is open source and available under the MIT License.
