 Library Management System (Java + Web Version)

A comprehensive, console-based and web-based Library Management System implemented in Java using Object-Oriented Programming (OOP) principles, and enhanced with a simple HTML/CSS/JavaScript web interface.
This system automates core library functions such as managing books, registering students, issuing/returning books, validating records, and performing searches.


---

🔹 Features

🔸 Book Management

Add new books with ID, title, author, quantity

View all available books

Automatic quantity update on issue/return

Availability checks

🔸 Student Management

Register students

View student records

Track books issued to each student

🔸 Transaction Handling

Issue books with validations

Return books with consistency checks

Prevent duplicate issue

Prevent returning unissued books

🔸 Search Functionality

Search by title, author, or book ID

🔸 Web Interface (Frontend Simulation)

A simple UI built using HTML, CSS, and JavaScript allowing:

Add/Issue/Return books

Register students

View records in real time


---

Project Structure

LibraryLMS/
│
├── Book.java                  # Book entity class
├── Student.java               # Student entity class
├── LibraryDatabase.java       # Core logic: add, issue, return, search
├── LibrarySystem.java         # Console-based UI (Main file)
│
├── LMS-Web/                   # Web version of the LMS
│     ├── index.html
│     ├── style.css
│     └── script.js
│
├── Screenshots/               # Optional screenshots
│
├── Project_Report.pdf         # Detailed project documentation
└── README.md                  # Technical documentation (this file)


---

Technologies Used

Backend (Console-Based Version)

Java

OOP Concepts

Java Collections (HashMap, HashSet)

Exception Handling

Modular Design

Frontend (Web Version)

HTML

CSS

JavaScript


---

System Architecture

The LMS follows a three-tier modular architecture, ensuring clarity and scalability.

+--------------------------+
|   LibrarySystem.java     |
|   (Console UI Layer)     |
+------------+-------------+
|
v
+--------------------------+
|   LibraryDatabase.java   |
|  (Business Logic Layer)  |
+------------+-------------+
|
+------------+-------------+
|                          |
v                          v
+-------------------+       +--------------------+
|     Book.java     |       |   Student.java     |
|   (Data Model)    |       |    (Data Model)    |
+-------------------+       +--------------------+

Web Architecture

HTML Form Inputs  --->  JavaScript Logic  --->  Updated Records (JSON)
|                          |
+--------------------------+
Rendered on Webpage


---

Implementation Overview

Book.java

Stores book details

Handles availability

Updates quantity

Student.java

Stores student details

Tracks issued books

Prevents duplicates

LibraryDatabase.java

Adds / retrieves books & students

Issues / returns books

Maintains data integrity

Implements search feature

LibrarySystem.java

Displays menu

Handles input

Connects UI → Logic Layer

Web Version (LMS-Web/)

Uses in-browser JavaScript objects to simulate book & student storage

Provides visual, interactive interface

Supports add/issue/return actions


---

How to Run (Java Version)

1. Open terminal inside the project folder


2. Compile all Java files:



javac *.java

3. Run the main program:



java LibrarySystem


---

How to Run the Web Version

1. Open the folder:



LMS-Web/

2. Double-click:



index.html

3. The UI will open in your browser — no server required.




---

Sample Operations (Console Version)

Add Book → Enter ID, Title, Author, Qty

Register Student → Enter ID, Name

Issue Book → Enter Student ID & Book ID

View Records → Displays all stored data


---

Approach & Design Decisions

Clean OOP modeling of real-world entities

Java Collections for fast lookups

Separation of UI, logic, and data

Input validation for safe operations

Extendable architecture (supports GUI or DB in the future)

Additional web version for demonstration


---

Testing Summary

Unit tests for Book/Student/Database operations

Integration tests for issue/return flows

Edge case testing:

Duplicate entries

Unavailable books

Invalid IDs

Returning unissued books


---

Future Enhancements

Database integration (MySQL/SQLite)

GUI (JavaFX or Swing)

Notifications / Fine calculation

Multi-user roles (Student, Admin, Librarian)

Analytics dashboard

Cloud or online access


---

Author

Aayushi Narang (24BSA10240)
VIT Bhopal University
School of Computing Science & Engineering
