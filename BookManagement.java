import java.util.HashMap;

interface BookManagement {
    void addBook(String title, String author, String category, int quantity, HashMap additionalAttributes);
    void removeBook(String title);
    void displayBooks();
}
