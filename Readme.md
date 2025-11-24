#	 Library Management System (Java)



A simple, console-based Library Management System implemented in Java.  

This project demonstrates object-oriented programming concepts, modular design,  

and the use of Java Collections for in-memory data management.
##  Features

- Add new books to the library

- Register students

- Issue books (with validations)

- Return books

- View all books

- View all registered students

- Input validation and meaningful error messages



##	 Project Structure

LibraryLMS/ 
├── Book.java                # Book entity class
├── Student.java             # Student entity class 
├── LibraryDatabase.java     # Core logic: add/issue/return/get records 
├── LibrarySystem.java       # Menu-based CLI (main file) 
└── README.md

## 🛠 Requirements

- Java 8 or later

- Command line / terminal



## How to Compile and Run



1. Open terminal inside the LibraryLMS/ folder  

2. Compile all Java files:



javac *.java



3. Run the program:



java LibrarySystem



##	How It Works

The application runs in a loop using a menu-driven interface:



1. Add Book  

2. Register Student  

3. Issue Book  

4. Return Book  

5. View Books  

6. View Students  

7. Exit  



All data is stored in memory during runtime using:

- HashMap<Integer, Book> for books  

- HashMap<String, Student> for students  

- HashSet<Integer> inside each student for issued book IDs  



## Concepts Used

- Object-Oriented Programming (OOP)

- Encapsulation

- Modular design

- Java Collections Framework

- Input validation



##	 Project Report

The full project report (converted to Java-based implementation) is included  

as Project_Report.pdf in this repository.



##	Author

Aayushi Narang (24BSA10240)

VIT Bhopal University  

Academic Submission – 2025