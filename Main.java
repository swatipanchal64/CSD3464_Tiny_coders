import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a library object
        Library library = new Library("Main Branch", "Toronto Downtown", "+1 847 555 3214");

        int choice;
        do {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Display Branch Details");
            System.out.println("2. Manage Librarians");
            System.out.println("3. Manage Books");
            System.out.println("4. Manage Users");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayBranchDetails();
                    break;
                case 2:
                    library.manageStaff();
                    break;
                case 3:
                    library.manageBooks();
                    break;
                case 4:
                    library.manageUsers();
                    break;
                case 5:
                    library.borrowBook();
                    break;
                case 6:
                    library.returnBook();
                    break;
                case 7:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
