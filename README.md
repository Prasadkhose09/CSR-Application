# 🏛 CivicScore – Civic Responsibility Tracking Platform

CivicScore is a backend-driven platform designed to **measure and track civic responsibility of citizens** through a rule-based scoring system.

The system records civic violations, calculates a **dynamic civic score**, and maintains a **complete audit history** of citizen behavior.

This project was developed as part of the **Developed India 2047 initiative**, aiming to encourage responsible civic behavior through data-driven evaluation.

---

# 🚀 Project Overview

CivicScore provides a structured system to track and evaluate citizen activities that impact society.

The platform:

* Records civic violations
* Applies rule-based score deductions
* Maintains score history
* Enables monitoring of citizen civic behavior over time

The system demonstrates backend concepts such as:

* REST API development
* Rule-based logic implementation
* Database relationship design
* Clean layered architecture
* Backend–frontend integration

---

# ✨ Key Features

* Citizen profile management
* Civic violation tracking
* Automated civic score calculation
* Rule-based penalty system
* Civic score history tracking
* RESTful API architecture
* Backend integration with React frontend

---

# 🏗 System Architecture

The platform follows **layered backend architecture**.

Client (React Frontend)
↓
REST Controller
↓
Service Layer (Business Logic)
↓
Repository Layer (Database Access)
↓
MySQL Database

---

# ⚙️ Core Concept: Civic Score Engine

Each citizen starts with a **base civic score**.

Whenever a violation occurs, the system:

1. Records the violation
2. Applies rule-based score deduction
3. Updates the citizen’s civic score
4. Stores the score history for auditing

Example:

| Violation         | Penalty |
| ----------------- | ------- |
| Traffic Violation | -10     |
| Public Littering  | -5      |
| Noise Pollution   | -8      |

This allows authorities to **monitor civic responsibility over time**.

---

# 🛠 Tech Stack

### Backend

* Java
* Spring Boot
* Spring Data JPA
* Hibernate

### Frontend

* React.js

### Database

* MySQL

### Tools

* Git
* GitHub
* Postman
* IntelliJ IDEA

---

# 📂 Project Structure

src/main/java/com/civicscore

controller
service
repository
model
dto
exception

resources
application.properties

docs
api-documentation.md

---

# 🔗 API Endpoints

## Create Citizen

POST /citizens

Request

{
"name": "Rahul Sharma",
"city": "Pune",
"baseScore": 100
}

---

## Get Citizen Details

GET /citizens/{id}

Example

GET /citizens/1

---

## Record Civic Violation

POST /violations

Request

{
"citizenId": 1,
"violationType": "Traffic Violation"
}

---

## Get Civic Score

GET /citizens/{id}/score

Response

{
"citizenId": 1,
"currentScore": 85
}

---

## Get Civic Score History

GET /citizens/{id}/history

Returns full score audit history for the citizen.

---

# 🗄 Database Design

The system uses relational database design with entity relationships.

Main tables:

Citizen
Violation
ScoreHistory

Relationships:

Citizen → One-to-Many → Violations
Citizen → One-to-Many → ScoreHistory

This structure enables **complete audit tracking of civic score changes**.

---

# 🧪 API Testing

APIs can be tested using:

* Postman
* REST Client
* Swagger (if enabled)

Example Request:

POST http://localhost:8080/violations

---

# 📈 Future Improvements

* AI-based civic behavior analysis
* Real-time violation detection
* Integration with city surveillance systems
* Mobile application for citizens
* Leaderboard for civic responsibility
* Government dashboard for monitoring civic trends

---

# 🌍 Impact

CivicScore encourages responsible citizenship by providing a **transparent and data-driven evaluation system**.

Such systems could help governments:

* Track civic behavior trends
* Identify frequent violations
* Promote responsible urban living

---

# 👨‍💻 Author

Prasad Khose

Java Backend Developer
Final Year IT Engineering Student

🌐 Portfolio
https://prasad-khose-portfolio.vercel.app/

💻 GitHub
https://github.com/Prasadkhose09

🔗 LinkedIn
https://www.linkedin.com/in/prasad-khose-686b81258

📧 Email
[prasadkhose512@gmail.com](mailto:prasadkhose512@gmail.com)

---

# ⭐ Support

If you found this project useful, consider giving the repository a ⭐.
