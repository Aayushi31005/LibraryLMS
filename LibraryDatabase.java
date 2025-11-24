import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LibraryDatabase {
    private Map<Integer, Book> books;
    private Map<String, Student> students;

    public LibraryDatabase() {
        books = new HashMap<>();
        students = new HashMap<>();
    }

    // Book operations
    public boolean addBook(Book book) {
        if (books.containsKey(book.getBookId())) return false; // duplicate id
        books.put(book.getBookId(), book);
        return true;
    }

    public Book getBook(int bookId) {
        return books.get(bookId);
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }

    // Student operations
    public boolean addStudent(Student student) {
        if (students.containsKey(student.getStudentId())) return false;
        students.put(student.getStudentId(), student);
        return true;
    }

    public Student getStudent(String studentId) {
        return students.get(studentId);
    }

    public Collection<Student> getAllStudents() {
        return students.values();
    }

    // Issue book
    public String issueBook(String studentId, int bookId) {
        Student s = getStudent(studentId);
        if (s == null) return "Student not registered.";
        Book b = getBook(bookId);
        if (b == null) return "Book not found.";
        if (!b.isAvailable()) return "Book is currently out of stock.";
        if (s.hasIssued(bookId)) return "Student has already issued this book.";
        b.decrementQuantity();
        s.issueBook(bookId);
        return "Book issued successfully.";
    }

    // Return book
    public String returnBook(String studentId, int bookId) {
        Student s = getStudent(studentId);
        if (s == null) return "Student not registered.";
        Book b = getBook(bookId);
        if (b == null) return "Book not found in database.";
        if (!s.hasIssued(bookId)) return "This book was not issued to the student.";
        s.returnBook(bookId);
        b.incrementQuantity();
        return "Book returned successfully.";
    }
}