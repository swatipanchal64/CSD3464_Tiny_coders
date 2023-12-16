import java.util.HashMap;

interface BookManagement {
    void addBook(int id, String title, String author, String category, int quantity, HashMap additionalAttributes);
    void removeBook(String title);
    void displayBooks();

    Book findBook(int id);
}
