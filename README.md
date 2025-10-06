# Full-Stack-Employee-Data-Management-Project
A full-stack Employee Management System built with Angular &amp; Spring Boot. Features CRUD operations, pagination, search, bulk CSV upload, and responsive UI. Backend uses REST APIs with validation, while frontend ensures instant updates for a smooth and user-friendly experience.


#Project Description – Employee Management System
1. Introduction

The Employee Management System is a full-stack web application designed to streamline the management of employee records in an organization. It provides an intuitive interface for HR/admin teams to add, edit, search, paginate, and delete employee data, along with support for bulk uploads via CSV.

The project follows a modular and scalable architecture using Angular on the frontend and Spring Boot on the backend, ensuring responsiveness, maintainability, and performance.

2. Features
🔹 Core Functionalities

Employee Management

Add new employees with details such as name, email, and position.

Edit existing employee records.

Delete employee entries with confirmation.

Search & Pagination

Real-time search by name, email, or position.

Pagination with customizable page sizes (10, 20, 50, 100).

Bulk Upload

Upload employee records via CSV for faster onboarding.

Automatic validation and data persistence.

Responsive & User-Friendly UI

Modern interface with action buttons for quick edits/deletes.

Modal-based forms for add/edit operations.

3. Technology Stack
🔹 Frontend (Angular)

Angular 16+ for component-based UI.

HTML5, CSS3 for layout and styling.

Font Awesome icons for better visuals.

Two-way binding & Reactive updates for instant UI changes.

🔹 Backend (Spring Boot)

Spring Boot 3+ for REST API development.

Spring Data JPA for database interaction.

MySQL as the relational database.

Validation & Exception Handling for secure data management.

🔹 Other Tools

HttpClient with Fetch API for API communication.

ChangeDetectorRef in Angular for real-time UI updates.

CSV parsing for bulk upload functionality.

4. Project Flow

Frontend (Angular)

User interacts with UI (CRUD, search, pagination, upload).

Angular communicates with backend APIs via HttpClient.

Backend (Spring Boot)

Handles incoming requests (create, read, update, delete employees).

Validates data before saving to the database.

Responds with updated data.

Database (MySQL)

Stores employee records.

Ensures referential integrity and query performance.

5. Key Highlights

CRUD with instant frontend updates.

Efficient search & pagination for large datasets.

Bulk CSV upload for mass employee onboarding.

Clean UI/UX for better usability.

Built with scalability and maintainability in mind.

6. Future Enhancements

Authentication & Role-based Access Control (Admin, HR, Employee).

Export employees list to CSV/Excel.

Advanced filtering and sorting options.

Integration with cloud databases and deployment.


#How to Setup and run project locally

1. Backend (Spring Boot + MySQL)

Import Backend Project
Open the backend folder employee_management_backend in your IDE (Eclipse/IntelliJ) as an existing Maven project.

Configure MySQL Database
Create a database named employee_db using the following MySQL command:

CREATE DATABASE employee_db;


Alternatively, you can use the provided .sql file inside the backend project folder to import the schema and sample data.

Update application.properties
Inside src/main/resources/application.properties, update the database configuration:

spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


Run the Spring Boot Application

Locate EmployeeManagementApplication.java (main class).

Right-click → Run as Java Application (or use mvn spring-boot:run).

The backend will start on:

http://localhost:8080

2. Frontend (Angular)

Open Frontend Project
Navigate to the employee_management_frontend folder.

Install Dependencies
Run the following command (skip if already installed):

npm install


Start Angular Development Server
Run:

ng serve -o


This will automatically open the app in your browser.

Application runs on:

http://localhost:4200


# How to run test cases

1. Employee CRUD Endpoints
Create Employee (POST /api/employees)

✅ Valid Input → Returns 201 Created with new employee details.

❌ Missing Fields → Returns 400 Bad Request with validation error.

❌ Duplicate Email → Returns 409 Conflict.

Get All Employees (GET /api/employees)

✅ No Employees → Returns empty list [].

✅ With Employees → Returns 200 OK and list of employees.

Get Employee by ID (GET /api/employees/{id})

✅ Valid ID → Returns 200 OK with employee details.

❌ Invalid ID → Returns 404 Not Found.

Update Employee (PUT /api/employees/{id})

✅ Valid Update → Returns 200 OK with updated employee.

❌ Invalid ID → Returns 404 Not Found.

❌ Invalid Data → Returns 400 Bad Request.

Delete Employee (DELETE /api/employees/{id})

✅ Valid ID → Returns 204 No Content.

❌ Invalid ID → Returns 404 Not Found.

2. Bulk Upload (POST /api/employees/bulk)

✅ Valid CSV File → Returns summary with processed, saved, skipped counts.

❌ Invalid File Format → Returns 400 Bad Request.

❌ CSV With Errors → Returns partial save + list of errors.
