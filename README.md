<p align="center">
  <img width="300" height="300" alt="Blockbuster Banner" 
       src="https://github.com/user-attachments/assets/ad9a33c8-8b6b-4c4c-9cac-cc8268199709" />
</p>


# 🎬 Blockbuster Rental API  

A RESTful API built with **Java 17** and **Spring Boot 3** that recreates the magic of a **Blockbuster-style movie rental system**.  

This project was inspired by **nostalgia**; if I could pick any time to be an adult, it would be the **early 2000s**: dancing all night to pop club hits, renting games from **Blockbuster or Redbox**, and staying up until sunrise playing video games and watching movies. This API is my way of bringing back a piece of that era into code form.  

---

## 🚀 Features  
- 📀 **Movies** – Add, update, delete, and list all movies  
- 👤 **Customers** – Create, update, delete, and list all customers  
- 🎟️ **Rental System** – Track how many copies of each movie are available  
- 🔍 **Search** – Find movies by title  

---

## 🛠️ Tech Stack  
- Java 17  
- Spring Boot 3 (Spring Web, Spring Data JPA)  
- Hibernate / JPA  
- PostgreSQL (with H2 in-memory DB for quick testing)  
- Maven  

---

## 📂 Project Structure  
```bash
blockbuster-api/
│── src/main/java/com/blockbuster
│   ├── controller   # REST endpoints
│   ├── service      # Business logic
│   ├── repository   # Data access layer
│   ├── model        # Entities (Movie, Rentees)
│   ├── dto          # Data Transfer Objects
│── src/main/resources
│   ├── application.properties
│── pom.xml
```

⚡ Getting Started
1️⃣ Clone the repository

git clone https://github.com/YOUR-USERNAME/blockbuster-api.git
```
cd blockbuster-api
```

2️⃣ Configure Database

Update `application.properties` for PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/blockbuster
spring.datasource.username=your_user
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

For quick testing, you can use the H2 dependency.

3️⃣ Run the application
```mvn spring-boot:run ```

📖 API Endpoints
🎥 Movies
```
Method	Endpoint	Description
GET	/health	Health check
POST	/createmovie	Create a new movie
GET	/movies	Get all movies (sorted alphabetically)
GET	/movies/{id}	Get movie by ID
GET	/movies/search?title=...	Search movies by title
PUT	/movies/{id}	Update movie info
DELETE	/movies/{id}	Delete a movie
```

👤 Rentees (Customers)
```
Method	Endpoint	Description
POST	/createrentee	Add a new rentee
GET	/rentees	List all rentees
GET	/rentees/{id}	Get rentee by ID
DELETE	/rentees/{id}	Delete a rentee
```

📝 Example Request
Create a movie:

```
json
{
  "title": "Home Alone",
  "releaseYear": 1990,
  "movieGenre": "COMEDY",
  "movieFormat": "BLURAY",
  "stock": 5,
  "upc": "123456789",
  "dailyPrice": 3.99
}
```

📸 Example Screenshots
Movies in Database
<img width="1060" height="337" alt="Movies Table" src="https://github.com/user-attachments/assets/83023db5-b547-490e-ba64-1901ae053835" />
Rentees in Database
<img width="998" height="140" alt="Rentees Table" src="https://github.com/user-attachments/assets/b334db95-3669-4f73-99c4-a9fe58992757" />

📌 Upcoming Features
- Add movie rental/return system
- Add due dates and late fees
- Movie ratings & customer reviews
- User authentication
- Deployment with Docker
- Front-end with REACT

👤 Author
moraleskjm
