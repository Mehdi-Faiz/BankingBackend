
# BankingBacked

BankingBacked is a small project done in Java/SpringBoot that attemps to recreate the inner workings of a real world banking... backend.

Although this project is relatively small I touch a lot of the most important aspects of a professional grade backend.

## Architecture & Design
+ Follows MVC (Model–View–Controller) layered structure.

+ Separation of concerns: Controller (API endpoints), Service (business logic), Repository (data access).

+ REST API design (resource-oriented endpoints).

## Data & Persistence

+ Uses Spring Data JPA for database interactions.

+ Entities for core banking concepts (e.g., Customer, Account, Transaction).

+ Relational database integration (PostgreSQL).

## Features & Domain Logic

+ Account creation, balance tracking, transactions (deposits, withdrawals, transfers).

+ Business rules (e.g., preventing overdrafts, transaction validation).

+ Error handling and global exception management.

## API & Communication

+ Exposes REST endpoints (CRUD operations, transaction handling, etc.).

+ Returns JSON responses (consumable by any frontend or mobile app).
