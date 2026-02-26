Spring Boot REST API
A Spring Boot RESTful API developed as a personal project. This application began with a foundational course and was extended with custom functionality, infrastructure, and containerization.

Features
RESTful CRUD Operations: Management of user resources.

Geolocation & Timezone Integration: Captures user IP address to determine the local timezone and time during POST requests.

Infrastructure:

PostgreSQL: Primary relational database.

Redis: Caching layer for data retrieval.

Dockerized Environment: The application, database, and cache are orchestrated using Docker Compose.

Technical Stack
Java 17 & Spring Boot 3.x

Spring Data JPA (PostgreSQL)

Spring Data Redis (Caching)

Docker & Docker Compose

Gradle

Usage

Clone the repository:

Bash
git clone https://github.com/AnriWulaia/spring-boot-rest-api.git
Build the JAR:

Bash
./gradlew clean bootJar
Run the stack:

Bash
docker-compose -f docker/docker-compose.yml up --build
The API is accessible at http://localhost:8080.

Credits
This project was initially based on the (https://www.udemy.com/course/the-spring-boot-crash-course/) course.