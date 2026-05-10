# Smart Inventory Management System

A Command Line Interface (CLI) application built to strengthen Core Java fundamentals and apply real-world software design principles including **SOLID**, **DRY**, **KISS**, and **YAGNI**. No GUI — just strong architecture, clean code, and purposeful design.

---

## Tech Stack

- **Language:** Java
- **Database:** PostgreSQL
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA

---

## Core Java Concepts Applied

- Java syntax — data types, variables, I/O
- Static methods, constructors
- Method overloading & overriding
- OOP principles — Encapsulation, Inheritance, Polymorphism, Abstraction
- Interfaces & Collections Framework
- Exception handling
- Multithreading — used for report generation
- Stream API & Lambda expressions

---

## Features

### Product Management
- Add, update, and delete products
- View full product list
- Search products by name or ID
- Monitor low-stock items

### Customer Management
- Register new customers
- Update customer information
- Search customers

### Billing & Sales
- Generate itemized bills
- Apply discounts and tax
- Automatically update stock after a sale
- Save billing reports

### Role-Based Access Control

| Feature | Admin | Customer |
|---|---|---|
| Add / Update / Delete products | ✅ | ❌ |
| View all products | ✅ | ✅ |
| Search products | ✅ | ✅ |
| Add to cart | ❌ | ✅ |
| View cart | ❌ | ✅ |
| Generate bill | ❌ | ✅ |
| View reports | ✅ | ❌ |

---

## Getting Started

### Prerequisites

- Java 8 or higher
- PostgreSQL installed and running
- Maven installed

### Setup

1. Clone the repository
   ```bash
   git clone https://github.com/your-username/SmartInventorySystem.git
   cd SmartInventorySystem
   ```

2. Create a PostgreSQL database
   ```sql
   CREATE DATABASE inventory_db;
   ```

3. Update database credentials in the config/connection file
   ```java
   String url = "jdbc:postgresql://localhost:5432/inventory_db";
   String user = "your_username";
   String password = "your_password";
   ```

4. Build the project using Maven
   ```bash
   mvn clean install
   ```

5. Run the application
   ```bash
   mvn exec:java -Dexec.mainClass="com.inventory.Main"
   ```

---

## Project Structure

```
src/main/java/com/inventory/
├── Main.java
├── model/
│   ├── Product.java
│   ├── Customer.java
│   └── Bill.java
├── service/
│   ├── ProductService.java
│   ├── CustomerService.java
│   └── BillingService.java
├── repository/
│   ├── ProductRepository.java
│   └── CustomerRepository.java
├── role/
│   ├── Admin.java
│   └── Customer.java
└── util/
    └── DBConnection.java
```

---

## Design Principles

| Principle | Application |
|---|---|
| **Single Responsibility** | Each class handles one concern — service, model, repository are separate |
| **Open/Closed** | New roles or features can be added without modifying existing logic |
| **DRY** | Shared logic is centralized in service and utility classes |
| **KISS** | CLI kept simple and straightforward — no unnecessary abstraction |
| **YAGNI** | Only features that are actually needed are implemented |

---

## Future Scope

- GUI using Java Swing or JavaFX
- REST API backend using Spring Boot
- Web frontend using React
- Role management dashboard
- PDF report export

---

