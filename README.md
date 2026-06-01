# Inventory Management System

A backend inventory management application built with Java and Spring Boot for managing products, categories, suppliers, employees, and inventory transactions. The project follows a layered architecture and showcases key backend development concepts such as RESTful API design, JPA/Hibernate entity mapping, DTO-based data transfer, request validation, exception handling, and database integration.

## Features

* Product, Category, Supplier, and Employee management
* Inventory stock-in and stock-out operations
* Automatic inventory quantity updates
* Inventory transaction history tracking
* DTO-based request and response models
* Request validation using Jakarta Validation API
* Centralized exception handling with custom exceptions
* MySQL integration using Spring Data JPA and Hibernate
* RESTful APIs tested using Postman

## Tech Stack

* Java 17
* Spring Boot 3
* Spring Data JPA
* Hibernate
* MySQL
* Lombok
* Jakarta Validation API
* Maven

## Architecture

The application follows a layered architecture to maintain separation of concerns and improve maintainability.

```text
Controller → Service → Repository → Database
```

### Layer Responsibilities

| Layer      | Responsibility                                     |
| ---------- | -------------------------------------------------- |
| Controller | Handles HTTP requests and returns API responses    |
| Service    | Implements business logic and application rules    |
| Repository | Performs database operations using Spring Data JPA |
| Entity     | Represents database tables and relationships       |
| DTO        | Defines API request and response models            |

## Domain Model

### Core Entities

* Product
* Category
* Supplier
* Employee
* StockTransaction

### Entity Relationships

* Product → Category (Many-to-One)
* Product → Supplier (Many-to-One)
* StockTransaction → Product (Many-to-One)
* StockTransaction → Employee (Many-to-One)

## API Endpoints

### Categories

| Method | Endpoint               |
| ------ | ---------------------- |
| POST   | `/api/categories`      |
| GET    | `/api/categories`      |
| GET    | `/api/categories/{id}` |
| PUT    | `/api/categories/{id}` |
| DELETE | `/api/categories/{id}` |

### Products

| Method | Endpoint             |
| ------ | -------------------- |
| POST   | `/api/products`      |
| GET    | `/api/products`      |
| GET    | `/api/products/{id}` |
| PUT    | `/api/products/{id}` |
| DELETE | `/api/products/{id}` |

### Suppliers

| Method | Endpoint              |
| ------ | --------------------- |
| POST   | `/api/suppliers`      |
| GET    | `/api/suppliers`      |
| GET    | `/api/suppliers/{id}` |
| PUT    | `/api/suppliers/{id}` |
| DELETE | `/api/suppliers/{id}` |

### Employees

| Method | Endpoint              |
| ------ | --------------------- |
| POST   | `/api/employees`      |
| GET    | `/api/employees`      |
| GET    | `/api/employees/{id}` |
| PUT    | `/api/employees/{id}` |
| DELETE | `/api/employees/{id}` |

### Inventory Transactions

| Method | Endpoint                      |
| ------ | ----------------------------- |
| POST   | `/api/transactions/stock-in`  |
| POST   | `/api/transactions/stock-out` |
| GET    | `/api/transactions`           |

## Getting Started

### Prerequisites

Ensure the following are installed on your system:

* Java 17 or later
* Maven
* MySQL Server

### Database Setup

Create a MySQL database:

```sql
CREATE DATABASE inventory_db;
```

Configure your database connection in:

```properties
src/main/resources/application.properties
```

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Running the Application

### Clone the Repository

```bash
git clone <repository-url>
```

### Navigate to the Project Directory

```bash
cd inventory-management-system
```

### Start the Application

```bash
mvn spring-boot:run
```

The application will be available at:

```text
http://localhost:8080
```

## Validation and Exception Handling

The application validates incoming requests using Jakarta Validation API to ensure data integrity before processing.

### Validation Examples

* Product name cannot be empty
* Invalid email formats are rejected
* Negative inventory quantities are not allowed
* Required fields must be provided

### Exception Handling

Global exception handling is implemented using `@RestControllerAdvice` to provide consistent API responses.

Custom exceptions include:

* `ResourceNotFoundException`
* `InsufficientStockException`

This approach ensures meaningful error messages and improves API usability.

## Testing

All APIs have been tested using Postman to verify CRUD operations, inventory workflows, validation rules, and exception handling scenarios.

## Future Enhancements

* Inventory analytics and reporting
* Low-stock monitoring and alerts
* Supplier performance analysis
* Swagger/OpenAPI documentation
* JWT-based authentication and authorization
* Docker containerization
* Role-based access control (RBAC)

## Learning Outcomes

This project helped strengthen understanding of:

* REST API development with Spring Boot
* Layered application architecture
* JPA/Hibernate entity relationships
* DTO pattern implementation
* Request validation and error handling
* Database integration with MySQL

## Author

## SHUBHAM KUMAR

Feel free to explore the project, raise issues, or suggest improvements. Contributions and feedback are always welcome.
* Inventory management business workflows
* Clean and maintainable backend design principles
