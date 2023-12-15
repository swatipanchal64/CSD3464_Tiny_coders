import java.util.HashMap;

public class BookImplementation extends Book implements BookManagement {
    private Book[] books = new Book[10];
    private int bookCount = 0;

    @Override
    public void addBook(int id, String title, String author, String category, int quantity, HashMap additionalAttributes) {

        Book book;

        if (category.equalsIgnoreCase("General")) {
            book = new GeneralBook((String) additionalAttributes.get("genre"), (String) additionalAttributes.get("language"), Integer.parseInt((String) additionalAttributes.get("year")));

        } else if (category.equalsIgnoreCase("Reference")) {
            book = new ReferenceBook((String) additionalAttributes.get("topic"), Integer.parseInt((String)additionalAttributes.get("edition")), (String) additionalAttributes.get("publisher"));

        } else {
            System.out.println("Invalid book category.");
            return;
        }

        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setCategory(category);
        book.setQuantity(quantity);

        books[bookCount++] = book;
        System.out.println("Book added: " + title);
    }

    @Override
    public void removeBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equals(title)) {
                // Remove the book from the array
                books[i] = books[bookCount - 1];
                bookCount--;
                System.out.println("Book removed: " + title);
                return;
            }
        }
        System.out.println("Book not found: " + title);
    }

    @Override
    public void displayBooks() {
        System.out.println("-----------------Books-----------------");
        for (int i = 0; i < bookCount; i++) {
            System.out.println("*****Book "+(i+1)+"*****");
            System.out.println(books[i]);
        }
    }
}
