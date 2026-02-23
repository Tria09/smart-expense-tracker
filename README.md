# Smart Expense Tracker (Backend Modular Application)

## Project Overview

Smart Expense Tracker is a backend-focused application designed to demonstrate how real-world systems are built using a modular and scalable architecture.

The system is responsible for:

* User Authentication
* Expense Tracking
* Financial Reporting

This project is intentionally developed incrementally, mirroring professional software development practices where features are delivered in phases rather than implemented all at once.

---

## Architecture Approach

The application is divided into independent backend services, each with a single responsibility:

**User Authentication Service**
Handles user registration, login, and validation.
Status: Completed

**Expense Management Service**
Manages income and expense records with CRUD operations.
Status: In Development

**Expense Report Service**
Generates financial summaries and analytical insights.
Status: Planned

This modular design enables:

* Easier maintenance
* Independent testing of each service
* Future scalability
* Clear separation of concerns

---

## Tech Stack

Backend Framework: Spring Boot
ORM: Spring Data JPA (Hibernate)
Database: MySQL
Build Tool: Maven
API Style: REST APIs
Containerization: Docker (used for Authentication Service)

---

## Current Implementation Status

Authentication Service — Completed
Handles user registration, login, and validation.

Expense Service — In Development
Implementing CRUD operations for managing expenses.

Expense Report Service — Planned
Will generate financial summaries and analytical reports.

---

## Project Structure

```
smart-expense-tracker/
└── backend/
    ├── et-user-auth-service        # Completed & dockerized
    ├── et-expense-service          # Under development
    └── et-expense-report-service   # Planned module
```

---

## How to Run the Authentication Service

### 1. Navigate to the Service Folder

```
cd backend/et-user-auth-service
```

### 2. Create the Database

Ensure MySQL is running, then create the database:

```
CREATE DATABASE expense_tracker;
```

Update `application.properties` with your local database username and password.

### 3. Run the Application

```
mvn spring-boot:run
```

The service will start at:

```
http://localhost:8080
```

---

## What This Project Demonstrates

This project focuses on applying core backend development concepts:

* Building RESTful APIs using Spring Boot
* Designing a clean layered architecture
* Integrating databases using JPA/Hibernate
* Structuring applications into independent services
* Running services in containers using Docker
* Developing software incrementally, feature by feature

---

## Upcoming Enhancements

* Complete Expense CRUD Operations
* Implement Financial Reporting Module
* Enable Service-to-Service Communication (REST)
* Improve Configuration & Deployment Setup
* Full Multi-Service Dockerization

---

## Note

This project is intentionally being built in stages to reflect how real backend systems evolve.
Each module is designed, implemented, and validated before moving to the next phase to ensure clean architecture and maintainability.

---

## Learning Objective

This repository is created as a hands-on learning project to strengthen backend development skills and understand how production-grade applications are structured.
