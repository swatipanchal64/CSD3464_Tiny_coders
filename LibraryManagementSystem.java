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
            System.out.println("3. Exit");
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
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 3);

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
}