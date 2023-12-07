import java.util.ArrayList;
import java.util.Scanner;
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library myLibrary = new Library("Lambton College, Yorkland Blvd", new ArrayList<>());

        // Create a Librarian object
        Librarian headLibrarian = new Librarian("John Doe", "L001", "Librarian");

        // Display the main menu
        displayMainMenu(myLibrary, headLibrarian);
    }

    // Function to display the main menu
    private static void displayMainMenu(Library library, Librarian librarian) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Display Library Address");
            System.out.println("2. Display Library Staff Information");
            System.out.println("3. Add Book");
            System.out.println("4. Display Books");
            System.out.println("5. Remove Book");
            System.out.println("6. Search Book");
            System.out.println("7. Checkout Book");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayLibraryAddress(library);
                    break;
                case 2:
                    displayLibraryStaffInfo(librarian);
                    break;
                case 3:
                    AddBook(library);
                    break;
                case 4:
                    DisplayBooks(library);
                    break;
                case 5:
                    DeleteBook(library);
                    break;
                case 6:
                    SearchBook(library);
                    break;
                case 7:
                    CheckoutBook();
                    break;
                case 8:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 8);

        scanner.close();
    }

    // Function to display the library address
    private static void displayLibraryAddress(Library library) {
        System.out.println("Library Address: " + library.getAddress());
    }

    // Function to display library staff information
    private static void displayLibraryStaffInfo(Librarian librarian) {
        System.out.println("Library Staff Information:");
        System.out.println("Head Librarian: " + librarian.getName() +
                "\nStaff ID: " + librarian.getStaffID() +
                "\nRole: " + librarian.getRole());
    }

    private static void AddBook(Library library) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the book details: ");

        System.out.print("Id: ");
        int id = in.nextInt();

        System.out.print("Name: ");
        String name = in.next();

        System.out.print("Publish Year: ");
        int publishYear = in.nextInt();

        System.out.print("Author Name: ");
        String authorName = in.next();

        System.out.print("Quantity: ");
        int quantity = in.nextInt();

        System.out.print("Category: ");
        String category = in.next();

        library.addBook(id, name, publishYear, authorName, quantity, category);

    }

    private static void DisplayBooks(Library library) {
        library.displayBooks();
    }

    private static void DeleteBook(Library library) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the book id to be removed: ");
        int id = in.nextInt();

        library.removeBook(id);

    }

    private static void SearchBook(Library library) {

        Scanner in = new Scanner(System.in);

        System.out.println("Search by Id, Name, Publish Year, Author name, Quantity or Category : ");
        String search = in.nextLine();

        library.searchBook(search);

    }

    private static void CheckoutBook() {
        System.out.println("Checking out book");
    }

}