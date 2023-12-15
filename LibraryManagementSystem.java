import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library myLibrary = new Library("Lambton College, Yorkland Blvd",new ArrayList<>(),new ArrayList<>());
        Librarian headLibrarian = new Librarian("John Doe", "L001", "Librarian");
        displayMainMenu(myLibrary, headLibrarian);
    }

    private static void displayMainMenu(Library library, Librarian librarian) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Display Library Address");
            System.out.println("2. Display Library Staff Information");
            System.out.println("3. Add Category");
            System.out.println("4. Display Users");
            System.out.println("5. Exit");
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
                    addCategory(library, scanner);
                    break;
                case 4:
                    displayUsers(library);
                    break;
                case 5:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void displayLibraryAddress(Library library) {
        System.out.println("Library Address: " + library.getAddress());
    }

    private static void displayLibraryStaffInfo(Librarian librarian) {
        System.out.println("Library Staff Information:");
        System.out.println("Head Librarian: " + librarian.getName() +
                "\nStaff ID: " + librarian.getStaffID() +
                "\nRole: " + librarian.getRole());
    }

    private static void addCategory(Library library, Scanner scanner) {
        System.out.print("Enter the member's name: ");
        String memberName = scanner.next();
        System.out.print("Enter the membership status (Membership/Subscription): ");
        String membershipStatus = scanner.next();

        Member newMember = new Member(memberName, membershipStatus);
        library.addMember(newMember);

        System.out.println("Member added successfully.");
    }

    private static void displayUsers(Library library) {
        System.out.println("\n--- Library Members ---");
        for (Member member : library.getMembers()) {
            System.out.println("Name: " + member.getName() +
                    "\nMembership Status: " + member.getMembershipStatus() +
                    "\n-------------------------");
        }
    }
}