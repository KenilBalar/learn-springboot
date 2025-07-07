# 🚀 Spring Boot CRUD API with PostgreSQL & Docker

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.org/projects/jdk/21/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-green.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue.svg)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/Docker-Containerized-blue)](https://www.docker.com/)
[![Build](https://img.shields.io/badge/Build-Gradle-purple.svg)](https://maven.apache.org/)

---

## 📘 Project Overview

This project demonstrates a complete **CRUD REST API** built using **Spring Boot 3.5.3** and **Java 21**, connected to a **PostgreSQL database** running in Docker. Data is persisted using a dedicated Docker **named volume**.

> 💡 Ideal for beginners learning Spring Boot + Docker + PostgreSQL integration.

---

## 🧾 Technologies Used

- Java 21 (OpenJDK)
- Spring Boot 3.5.3
- PostgreSQL
- Docker & Docker Compose
- Gradle

---


## 🐳 Docker Setup (Database + App)


### ✅ 1. `docker-compose.yml`

```yaml
services:
  db:
    container_name: postgres
    image: postgres:latest
    environment:
      POSTGRES_USER: kenil13
      POSTGRES_PASSWORD: qwertz
      PGDATA: /data/postgres
    volumes:
      - db:/data/postgres
    ports:
      - "5332:5432"
    networks:
      - db
    restart: unless-stopped

networks:
  db:
    driver: bridge

volumes:
  db:
```


### ✅ 2. `Dockerfile` (Java 21)

```Dockerfile
FROM eclipse-temurin:21-jdk

WORKDIR /app

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

## ⚙️ How to Run the App

### 🧩 Prerequisites

- Docker & Docker Compose installed
- JDK 21 installed
- Gradle installed

---

### 🔧 Step-by-Step Instructions

#### 1️⃣ Clone the Project

```bash
git clone https://github.com/your-username/learn-springboot.git
cd learn-springboot
```

#### 2️⃣ Start PostgreSQL in Docker

```bash
docker compose up -d
```

#### 3️⃣ Build Spring Boot Project

```bash
./mvnw clean package
```

#### 4️⃣ Build Docker Image for Spring Boot App

```bash
docker build -t learn-springboot-app .
```

#### 5️⃣ Run Spring Boot App Container

```bash
docker run -p 8080:8080 --network=learn-springboot_db learn-springboot-app
```

---

## 🌐 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/v1/software-engineers/getAllSoftwareEngineers` | Fetch all engineers |
| GET    | `/api/v1/software-engineers/getSoftwareEngineer/{id}` | Get by ID |
| POST   | `/api/v1/software-engineers/addSoftwareEngineer` | Add new engineer |
| PUT    | `/api/v1/software-engineers/updateSoftwareEngineer/{id}` | Update engineer |
| DELETE | `/api/v1/software-engineers/deleteSoftwareEngineer/{id}` | Delete engineer |

---

## 🔍 Example Request (cURL)

```bash
curl -X POST http://localhost:8080/api/v1/software-engineers/addSoftwareEngineer   -H "Content-Type: application/json"   -d '{
    "name": "Kenil Balar",
    "designation": "Software Engineer",
    "email": "kenil123@gmail.com",
    "phone": "+49134408425",
    "address": "Berlin, Germany",
    "techStack": ["Java", "Spring Boot", "PostgreSQL", "Docker"]
  }'
```

---

## 🧪 Test with Postman

1. Open Postman
2. Create a new `POST` request to:
   ```
   http://localhost:8080/api/v1/software-engineers/addSoftwareEngineer
   ```
3. Use the sample JSON above in the body

---

## ✅ Future Enhancements

- Add Swagger UI for API docs
- Exception handling with `@ControllerAdvice`
- Authentication with Spring Security
- Unit tests with JUnit & Mockito

---

## 👨‍💻 Author

**Kenil Balar**  
[GitHub](https://github.com/KenilBalar) • [LinkedIn](https://www.linkedin.com/in/kenil-balar-1167b1213/)

---

> 💬 Pull requests, stars ⭐, and forks 🍴 are welcome!
