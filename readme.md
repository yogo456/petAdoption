# Pet Adoption System

## Overview

The Pet Adoption System is a Spring Boot application designed to manage pet adoption processes. It includes functionality for managing pets, pet types, user accounts, and saved pets. The application provides RESTful APIs to handle CRUD operations and filtering of pet records.

## Features

- **Pet Management**: Create, read, update, and delete pet records.
- **Pet Type Management**: Retrieve all available pet types.
- **User Management**: Create, update, delete, and retrieve user records. User authentication is supported.
- **Saved Pets**: Save and retrieve pets that users have marked as favorites.

## Technologies Used

- **Spring Boot**: For building the application and RESTful services.
- **JPA (Java Persistence API)**: For database interaction.
- **MySQL**: Relational database for persistent storage.
- **CORS Configuration**: To handle cross-origin requests.

## Setup and Installation

### Prerequisites

- JDK 11 or later
- Maven 3.6 or later
- MySQL database server

### Clone the Repository

```bash
git clone https://github.com/yogo456/petAdoption.git
cd petAdoption
```

### Database Setup

1. **Create the Database:**
   Ensure you have a MySQL database server running. Create a database named `petadoption`.

   ```sql
   CREATE DATABASE petadoption;
   ```

2. **Configure Database:**
   Update the `src/main/resources/application.properties` file with the following database configuration:

   ```properties
   # MySQL Database Configuration
   spring.datasource.url=jdbc:mysql://localhost:3306/petadoption
   spring.datasource.username=root
   spring.datasource.password=*your password here*
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

   # JPA Configuration
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   ```

### Build the Project

Navigate to the project directory and run:

```bash
mvn clean install
```

### Run the Application

To start the application, use:

```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`.

## API Endpoints

### Pets

- **Get All Pets**: `GET /api/pets`
- **Get Pet by ID**: `GET /api/pets/{id}`
- **Create Pet**: `POST /api/pets`
- **Update Pet**: `PUT /api/pets/{id}`
- **Delete Pet**: `DELETE /api/pets/{id}`
- **Filter Pets**: `GET /api/pets/filter`

### Pet Types

- **Get All Pet Types**: `GET /api/pet-types`

### Saved Pets

- **Get All Saved Pets**: `GET /api/savedPets`
- **Get Saved Pets by User ID**: `GET /api/savedPets/user/{userId}`
- **Get Saved Pets by Pet ID**: `GET /api/savedPets/pet/{petId}`
- **Save Pet**: `POST /api/savedPets`
- **Delete Saved Pet**: `DELETE /api/savedPets/user/{userId}/pet/{petId}`

### Users

- **Get All Users**: `GET /api/users`
- **Get User by ID**: `GET /api/users/{id}`
- **User Login**: `GET /api/users/login/{email}?password={password}`
- **Create User**: `POST /api/users`
- **Update User**: `PUT /api/users/{id}`
- **Delete User**: `DELETE /api/users/{id}`

## CORS Configuration

The application is configured to allow CORS requests from `http://localhost:3000`. Modify the `CorsConfig` class if different origins are required.
