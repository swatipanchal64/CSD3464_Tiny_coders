public class Book {
    private int id;
    private String name;
    private int publishYear;
    private String authorName;

    private int quantity;
    private String category;

    public Book(int id, String name, int publishYear, String authorName, int quantity, String category) {
        this.id = id;
        setBook(name, publishYear, authorName, quantity, category);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setBook(String name, int publishYear, String authorName, int quantity, String category){
        this.name = name;
        this.publishYear = publishYear;
        this.authorName = authorName;
        this.quantity = quantity;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishYear=" + publishYear +
                ", authorName='" + authorName + '\'' +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                '}';
    }
}
