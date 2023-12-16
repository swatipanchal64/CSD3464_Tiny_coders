import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Library extends Branch implements BookManagement {
    private List<Librarian> staff;
    private BookManagement bookManager;
    private UserManager userManager;

    public Library(String branchName, String address, String phoneNumber) {
        super(branchName, address, phoneNumber);
        this.bookManager = new BookImplementation();
        this.staff = new ArrayList<>();
        this.userManager = new UserManager();
    }

    // Additional method for displaying branch details
    public void displayBranchDetails() {
        System.out.println("Branch Details " +
                                "\n\t Name: " + getBranchName() +
                                "\n\t Address: " + getAddress() +
                                "\n\t Phone Number: "+ getPhoneNumber() );
    }

    @Override
    public void manageBooks() {

        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n\nBook Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Scanner in = new Scanner(System.in);
                    System.out.println("Enter the book details: ");

                    System.out.print("Id: ");
                    int id = in.nextInt();

                    in.nextLine();

                    System.out.print("Title: ");
                    String name = in.nextLine();

                    System.out.print("Author Name: ");
                    String authorName = in.nextLine();

                    System.out.print("Quantity: ");
                    int quantity = in.nextInt();

                    in.nextLine();

                    System.out.print("Category (General/Reference): ");
                    String category = in.nextLine();

                    HashMap<String, String> additionalAttributes = new HashMap<String, String>();

                    if(category.equalsIgnoreCase("general")) {
                        System.out.print("Genre: ");
                        additionalAttributes.put("genre", in.nextLine());

                        System.out.print("Language: ");
                        additionalAttributes.put("language", in.nextLine());

                        System.out.print("Publishing Year: ");
                        additionalAttributes.put("year", in.nextLine());
                    }
                    else {
                        System.out.print("Topic: ");
                        additionalAttributes.put("topic", in.nextLine());

                        System.out.print("Edition: ");
                        additionalAttributes.put("edition", in.nextLine());

                        System.out.print("Publisher: ");
                        additionalAttributes.put("publisher", in.nextLine());
                    }

                    addBook(id, name, authorName, category, quantity, additionalAttributes);
                    break;

                case 2:
                    System.out.print("Enter the title of the book to remove: ");
                    String removeTitle = scanner.nextLine();
                    removeBook(removeTitle);
                    break;
                case 3:
                    displayBooks();
                    break;
                case 4:
                    // Return to main menu
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while(choice != 4);
    }

    @Override
    public void addBook(int id, String title, String author, String category, int quantity, HashMap additionalAttributes) {
        bookManager.addBook(id, title, author, category, quantity, additionalAttributes);
    }

    @Override
    public void removeBook(String title) {
        bookManager.removeBook(title);
    }

    @Override
    public void displayBooks() {
        bookManager.displayBooks();
    }

    @Override
    public Book findBook(int id) {
        return bookManager.findBook(id);
    }

    @Override
    public void manageStaff() {
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n\nStaff Management:");
            System.out.println("1. Add Library Staff Info");
            System.out.println("2. Display Library Staff Information");
            System.out.println("3. Update Librarian Information");
            System.out.println("4. Delete Librarian");
            System.out.println("5. Return to main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addLibrarian();
                    break;
                case 2:
                    displayLibraryStaffInfo();
                    break;
                case 3:
                    updateLibrarian();
                    break;
                case 4:
                    deleteLibrarian();
                    break;
                case 5:
                    // Return to main menu
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while(choice != 5);
    }

    public void addLibrarian() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Librarian Name: ");
        String librarianName = scanner.nextLine();

        System.out.print("Enter Librarian ID: ");
        String librarianID = scanner.nextLine();

        System.out.print("Enter Librarian Username: ");
        String librarianUsername = scanner.nextLine();

        Librarian newLibrarian = new Librarian(librarianName, librarianID, librarianUsername);
        this.staff.add(newLibrarian);

        System.out.println("Librarian information added successfully!");
    }

    public void displayLibraryStaffInfo() {

        System.out.println("-------------Library Staff Information-------------");

        for (Librarian librarian : this.staff) {
            System.out.println("_______________________");
            System.out.println("Librarian Name: " + librarian.getName() +
                    "\nStaff ID: " + librarian.getStaffID() +
                    "\nRole: " + librarian.getRole());
        }

    }

    public Librarian findLibrarianByStaffID(String staffID) {
        for (Librarian librarian : this.staff) {
            if (librarian.getStaffID().equals(staffID)) {
                return librarian;
            }
        }
        return null;
    }

    public void updateLibrarian() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Librarian Staff ID to update: ");
        String staffIDToUpdate = scanner.nextLine();

        // Find the librarian with the given staff ID
        Librarian librarianToUpdate = findLibrarianByStaffID(staffIDToUpdate);

        if (librarianToUpdate != null) {
            System.out.print("Enter new Librarian Name: ");
            String updatedLibrarianName = scanner.nextLine();
            librarianToUpdate.setName(updatedLibrarianName);
            System.out.println("Librarian information updated successfully!");
        } else {
            System.out.println("Librarian with the given Staff ID not found.");
        }
    }

    //Function to delete Librarian
    public void deleteLibrarian() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Librarian Staff ID to delete: ");
        String staffIDToDelete = scanner.nextLine();

        // Find the librarian with the given staff ID
        Librarian librarianToDelete = findLibrarianByStaffID(staffIDToDelete);

        if (librarianToDelete != null) {
            this.staff.remove(librarianToDelete);
            System.out.println("Librarian deleted successfully!");
        } else {
            System.out.println("Librarian with the given Staff ID not found.");
        }
    }

    @Override
    public void manageUsers() {

        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("\n------------User Management-------------");
            System.out.println("1. Add User");
            System.out.println("2. Display Users");
            System.out.println("3. Remove User");
            System.out.println("4. Return to main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter id: ");
                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();

                    System.out.print("Enter subscription type (Basic/VIP): ");
                    String subscriptionType = scanner.nextLine();

                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();

                    User user;
                    if (subscriptionType.equalsIgnoreCase("Basic")) {
                        user = new StandardUser(id, username, age);
                    } else if (subscriptionType.equalsIgnoreCase("VIP")) {
                        user = new VIPUser(id, username, age);
                    } else {
                        System.out.println("Invalid subscription type.");
                        continue;
                    }

                    userManager.addUser(user);
                    break;
                case 2:
                    userManager.displayUsers();
                    break;
                case 3:
                    System.out.print("Enter username to remove: ");
                    String usernameToRemove = scanner.nextLine();
                    userManager.removeUser(usernameToRemove);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4) ;
    }

    public void borrowBook(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the user id: ");
        int userId = scanner.nextInt();

        System.out.print("Enter the book id: ");
        int bookId = scanner.nextInt();

        User userCheckout = userManager.findUser(userId);

        if (userCheckout != null) {
            userCheckout.borrowBook(bookId, bookManager);
        } else {
            System.out.println("User not found: " + bookId);
        }
    }

    public void returnBook(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the user id: ");
        int userId = scanner.nextInt();

        System.out.print("Enter the book id: ");
        int bookId = scanner.nextInt();

        User userReturn = userManager.findUser(userId);
        if (userReturn != null) {
            userReturn.returnBook(bookId, bookManager);
        } else {
            System.out.println("User not found: " + bookId);
        }

    }

}