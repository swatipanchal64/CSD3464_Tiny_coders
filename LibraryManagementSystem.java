import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library myLibrary = new Library("Lambton College, Yorkland Blvd", new ArrayList<>());

        // Create a Librarian object
//        Librarian headLibrarian = new Librarian("John Doe", "L001", "Librarian");
        List<Librarian> librarians = new ArrayList<>();
        Librarian librarian=new Librarian("Jayti","l100","IT");
        // Display the main menu
        displayMainMenu(myLibrary, librarians);
    }

    // Function to display the main menu
    private static void displayMainMenu(Library library, List<Librarian> librarian) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Display Library Address");
            System.out.println("2. Add Library Staff Info");
            System.out.println("3. Display Library Staff Information");
            System.out.println("4. Update Librarian Information");
            System.out.println("5. Delete Librarian");
            System.out.println("6. Add Book");
            System.out.println("7. Display Books");
            System.out.println("8. Remove Book");
            System.out.println("9. Search Book");
            System.out.println("10. Checkout Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayLibraryAddress(library);
                    break;
                case 2:
                    addLibrarian(librarian, scanner);
                    break;
                case 3:
                    displayLibraryStaffInfo(Librarian);
                    break;
                case 4:
                    updateLibrarian(librarian, scanner);
                    break;
                case 5:
                    deleteLibrarian(librarian, scanner);
                    break;
                case 6:
                    AddBook(library);
                    break;
                case 7:
                    DisplayBooks(library);
                    break;
                case 8:
                    DeleteBook(library);
                    break;
                case 9:
                    SearchBook(library);
                    break;
                case 10:
                    CheckoutBook();
                    break;
                case 0:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);

        scanner.close();
    }


    // Function to display the library address
    private static void displayLibraryAddress(Library library) {
        System.out.println("Library Address: " + library.getAddress());
    }

    // Function to add Librarian
    private static void addLibrarian(List<Librarian> librarians, Scanner scanner) {
        System.out.print("Enter Librarian Name: ");
        String librarianName = scanner.next();

        System.out.print("Enter Librarian ID: ");
        String librarianID = scanner.next();

        System.out.print("Enter Librarian Username: ");
        String librarianUsername = scanner.next();

        Librarian newLibrarian = new Librarian(librarianName, librarianID, librarianUsername);
        librarians.add(newLibrarian);

        System.out.println("Librarian information added successfully!");
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

    private static Librarian findLibrarianByStaffID(List<Librarian> librarians, String staffID) {
        for (Librarian librarian : librarians) {
            if (librarian.getStaffID().equals(staffID)) {
                return librarian;
            }
        }
        return null;
    }
    private static void updateLibrarian(List<Librarian> librarians, Scanner scanner) {
        System.out.print("Enter Librarian Staff ID to update: ");
        String staffIDToUpdate = scanner.next();

        // Find the librarian with the given staff ID
        Librarian librarianToUpdate = findLibrarianByStaffID(librarians, staffIDToUpdate);

        if (librarianToUpdate != null) {
            System.out.print("Enter new Librarian Name: ");
            String updatedLibrarianName = scanner.next();
            librarianToUpdate.setName(updatedLibrarianName);
            System.out.println("Librarian information updated successfully!");
        } else {
            System.out.println("Librarian with the given Staff ID not found.");
        }
    }

    //Function to delete Librarian
    private static void deleteLibrarian(List<Librarian> librarians, Scanner scanner) {
        System.out.print("Enter Librarian Staff ID to delete: ");
        String staffIDToDelete = scanner.next();

        // Find the librarian with the given staff ID
        Librarian librarianToDelete = findLibrarianByStaffID(librarians, staffIDToDelete);

        if (librarianToDelete != null) {
            librarians.remove(librarianToDelete);
            System.out.println("Librarian deleted successfully!");
        } else {
            System.out.println("Librarian with the given Staff ID not found.");
        }
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