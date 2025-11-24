import java.util.HashSet;
import java.util.Set;

public class Student {
    private String studentId;
    private String name;
    private Set<Integer> issuedBooks; // store book IDs

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.issuedBooks = new HashSet<>();
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public Set<Integer> getIssuedBooks() { return issuedBooks; }

    public boolean hasIssued(int bookId) {
        return issuedBooks.contains(bookId);
    }

    public void issueBook(int bookId) {
        issuedBooks.add(bookId);
    }

    public void returnBook(int bookId) {
        issuedBooks.remove(bookId);
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Issued: %d",
                studentId, name, issuedBooks.size());
    }
}