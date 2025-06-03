# Student-Course-Management-System

## *This project is from my Data Structure (DS) course at Sharif University of Technology.*


## Project Overview
This project manages three types of educational data:

1. **Students**:
   - Student code: Unique 8-digit number
   - Name: Max 30 characters (letters only)

2. **Courses**:
   - Course code: 5-digit number
   - Name: Max 10 characters (uppercase letters only)

3. **Grades**:
   - Semester: 5-digit number (4 digits year + 1 digit semester 1-3)
   - Grade: 0-20 with max 1 decimal digit

## Phase 1: Basic Operations
Implement CRUD operations using lists:

### Commands:
- `ADDS [student_code] [name]`: Add student
- `ADDC [course_code] [name]`: Add course
- `ADDG [student_code] [course_code] [semester] [grade]`: Add grade
- `EDITS/EDITC/EDITG`: Edit student/course/grade
- `DELETES/DELETEC/DELETEG`: Delete student/course/grade
- `NUMBERC [student_code]`: Count courses taken by student
- `NUMBERS [course_code]`: Count students who took course

## Phase 2: Search Operations
Implement search functionality using:

- **Binary Search Trees** for name-based searches
- **Hash Tables** for code-based searches (using universal hashing family)

### Commands:
- `SEARCHSN [student_name]`: Search student by name
- `SEARCHCN [course_name]`: Search course by name
- `SEARCHSC [student_code]`: Search student by code
- `SEARCHCC [course_code]`: Search course by code

## Phase 3: Advanced Features

### Course Relationships
- Courses are related if they share >50% of students
- Commands:
  - `ISRELATIVE [code1] [code2]`: Check if courses are related
  - `ALLRELATIVE [code]`: List all related courses

### Course Risk Assessment
- `MINRISK [student_code]`: Optimize course sequence based on average grades

### Student Ranking
- `COMPARE [code1] [code2]`: Compare students based on grades in shared courses

**Time Complexity Summary:**  

- **Insert (ADDS, ADDC, ADDG):** `O(1)`  
- **Edit (EDITS, EDITC, EDITG):** `O(n)`  
- **Delete (DELETES, DELETEC, DELETEG):** `O(n)`  
- **Count (NUMBERC, NUMBERS):** `O(n)`  

### **Overall:**  
- **Best case (all inserts):** `O(T)`  
- **Worst case (many edits/deletes):** `O(T * n)`  
- **Space:** `O(S + C + G)`  

*(T = commands, n = list size, S/C/G = students/courses/grades)*


