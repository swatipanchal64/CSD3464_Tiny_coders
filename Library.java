import java.util.ArrayList;
import java.util.List;
public class Library {
    private String address;
    private List<Librarian> staff;
    private List<Book> books;

    // Constructor
    public Library(String address, List<Librarian> staff) {
        this.address = address;
        this.staff = staff;
        this.books = new ArrayList<Book>();
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    public void addBook(int id, String name, int publishYear, String authorName, int quantity, String category) {
        Book newBook = new Book(id, name, publishYear, authorName, quantity, category);
        books.add(newBook);
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        System.out.println("\nList of Available Books:");
        for (Book book : books) {
            System.out.println("---------");
            System.out.println(book);
        }
    }

    public void updateBook(int id, String name, int publishYear, String authorName, int quantity, String category) {

        for (Book book : books) {
            if (book.getId() == id) {
                book.setBook(name, publishYear, authorName, quantity, category);
                System.out.println("Book updated successfully!");
                break;
            }
        }

        System.out.println("Book not found in system!");
    }

    public void removeBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                System.out.println("Book removed successfully!");
                return;
            }
        }

        System.out.println("Book not found!");
    }

    public void searchBook(String search) {

        int counter = 0;

        for (Book book : books) {
            if (book.getName().contains(search) ||
                    book.getAuthorName().contains(search) ||
                    book.getPublishYear() == Integer.parseInt(search) ||
                    book.getQuantity() == Integer.parseInt(search) ||
                    book.getCategory().contains(search)
            ) {
                System.out.println("---------");
                System.out.println(book);
                counter++;
            }
        }

        if (counter == 0) {
            System.out.println("Book not found!");
        }
    }

    @Override
    public String toString() {
        return "Library{" +
                "address='" + address + '\'' +
                ", staff=" + staff +
                ", books=" + books +
                '}';
    }
}