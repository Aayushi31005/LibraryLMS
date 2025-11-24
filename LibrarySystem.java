import java.util.InputMismatchException;
import java.util.Scanner;

public class LibrarySystem {
    private static LibraryDatabase db = new LibraryDatabase();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> addBookFlow();
                case 2 -> registerStudentFlow();
                case 3 -> issueBookFlow();
                case 4 -> returnBookFlow();
                case 5 -> viewBooksFlow();
                case 6 -> viewStudentsFlow();
                case 7 -> {
                    System.out.println("Exiting. Goodbye.");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("===== Library Management System =====");
        System.out.println("1. Add Book");
        System.out.println("2. Register Student");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println("5. View Books");
        System.out.println("6. View Students");
        System.out.println("7. Exit");
    }

    private static void addBookFlow() {
        System.out.println("--- Add Book ---");
        int id = readInt("Enter Book ID (integer): ");
        scanner.nextLine();
        String title = readNonEmptyString("Enter Title: ");
        String author = readNonEmptyString("Enter Author: ");
        int qty = readInt("Enter Quantity (>=0): ");
        if (qty < 0) {
            System.out.println("Quantity cannot be negative.");
            return;
        }
        Book book = new Book(id, title, author, qty);
        boolean ok = db.addBook(book);
        System.out.println(ok ? "Book added successfully." : "Book ID already exists.");
    }

    private static void registerStudentFlow() {
        System.out.println("--- Register Student ---");
        scanner.nextLine();
        String sid = readNonEmptyString("Enter Student ID: ");
        String name = readNonEmptyString("Enter Name: ");
        Student s = new Student(sid, name);
        boolean ok = db.addStudent(s);
        System.out.println(ok ? "Student registered successfully." : "Student ID already exists.");
    }

    private static void issueBookFlow() {
        System.out.println("--- Issue Book ---");
        scanner.nextLine();
        String sid = readNonEmptyString("Enter Student ID: ");
        int bid = readInt("Enter Book ID (integer): ");
        String res = db.issueBook(sid, bid);
        System.out.println(res);
    }

    private static void returnBookFlow() {
        System.out.println("--- Return Book ---");
        scanner.nextLine();
        String sid = readNonEmptyString("Enter Student ID: ");
        int bid = readInt("Enter Book ID (integer): ");
        String res = db.returnBook(sid, bid);
        System.out.println(res);
    }

    private static void viewBooksFlow() {
        System.out.println("--- Books List ---");
        db.getAllBooks().forEach(b -> System.out.println(b));
    }

    private static void viewStudentsFlow() {
        System.out.println("--- Students List ---");
        db.getAllStudents().forEach(s -> {
            System.out.println(s);
            if (!s.getIssuedBooks().isEmpty()) {
                System.out.println(" Issued Book IDs: " + s.getIssuedBooks());
            }
        });
    }

    // Helper input methods
    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int val = scanner.nextInt();
                return val;
            } catch (InputMismatchException e) {
                System.out.println("Invalid integer. Try again.");
                scanner.nextLine(); // clear
            }
        }
    }

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Input cannot be empty.");
        }
    }
}