public class Book {
    private int bookId;
    private String title;
    private String author;
    private int quantity;

    public Book(int bookId, String title, String author, int quantity) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public void decrementQuantity() {
        if (quantity > 0) quantity--;
    }

    public void incrementQuantity() {
        quantity++;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Title: %s | Author: %s | Qty: %d",
                bookId, title, author, quantity);
    }
}