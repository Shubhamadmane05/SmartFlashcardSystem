 # Smart Flashcard System

A simple Spring Boot + MySQL backend where students can add flashcards (just questions and answers),
and the system automatically detects the subject like Physics, Biology, Math, etc.

---

##  Tech Stack
- Java 17 + Spring Boot  
- MySQL + Spring Data JPA  
- Maven

##  How to Run

1. **Clone this repo**
2. **Set up MySQL**  
   - Create a database: `smart_flashcard_system`  
   - Or use: `?createDatabaseIfNotExist=true` in the JDBC URL
3. **Update `application.properties`**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/smart_flashcard_system?createDatabaseIfNotExist=true
   spring.datasource.username=****
   spring.datasource.password=****
   spring.jpa.hibernate.ddl-auto=update

 ## API Endpoints
1. Add Flashcard
 - URL: http://localhost:8080/flashcard/add
- Method: POST
- Body (JSON):
  ```json
    {
      "studentId": "stu001",
      "question": "What is Newton's Second Law?",
      "answer": "Force equals mass times acceleration"
    }
    
    - Response:
    {
      "message": "Flashcard added successfully",
      "subject": "Physics"
    }

2. Get Flashcards by Subject (Shuffled)
- URL: http://localhost:8080/flashcard/get-subject?studentId=stu001&limit=2
- Method: GET
- Response:
  ```json
      {
        "id": 2,
        "studentId": "stu001",
        "question": "What is Newton's Second Law?",
        "answer": "Force equals mass times acceleration",
        "subject": "Physics"
    },
    {
        "id": 3,
        "studentId": "stu001",
        "question": "What is photosynthesis?",
        "answer": "Process by which plants convert light energy into chemical energy",
        "subject": "Biology"
    }


