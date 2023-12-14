// Abstract class for Book
public abstract class Book {
    private String title;
    private String author;
    private String category;
    private int quantity;

    // Constructor, getters, and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String displayBookDetails() {
        return "\tTitle: " + getTitle() + "\n\t" +
                "Author: " + getAuthor() + "\n\t" +
                "Category: " + getCategory() + "\n\t" +
                "Quantity: " + getQuantity();
    }
}