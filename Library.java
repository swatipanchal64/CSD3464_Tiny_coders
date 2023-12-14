import java.util.HashMap;
import java.util.Scanner;

public class Library extends Branch implements BookManagement {
    private Staff librarian;
    private BookManagement bookManager;
    public Library(String branchName, String address, String phoneNumber) {
        super(branchName, address, phoneNumber);
        this.bookManager = new BookImplementation();
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
//        System.out.println("4. Checkout Book");
//        System.out.println("5. Return Book");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Scanner in = new Scanner(System.in);
                    System.out.println("Enter the book details: ");

                    System.out.print("Title: ");
                    String name = in.next();

                    System.out.print("Author Name: ");
                    String authorName = in.next();

                    System.out.print("Quantity: ");
                    int quantity = in.nextInt();

                    System.out.print("Category (General/Reference): ");
                    String category = in.next();

                    HashMap<String, String> additionalAttributes = new HashMap<String, String>();

                    if(category.equalsIgnoreCase("general")) {
                        System.out.print("Genre: ");
                        additionalAttributes.put("genre", in.next());

                        System.out.print("Language: ");
                        additionalAttributes.put("language", in.next());

                        System.out.print("Publishing Year: ");
                        additionalAttributes.put("year", in.next());
                    }
                    else {
                        System.out.print("Topic: ");
                        additionalAttributes.put("topic", in.next());

                        System.out.print("Edition: ");
                        additionalAttributes.put("edition", in.next());

                        System.out.print("Publisher: ");
                        additionalAttributes.put("publisher", in.next());
                    }

                    addBook(name, authorName, category, quantity, additionalAttributes);
                    break;

                case 2:
                    System.out.print("Enter the title of the book to remove: ");
                    String removeTitle = scanner.next();
                    removeBook(removeTitle);
                    break;
                case 3:
                    displayBooks();
                    break;
                case 6:
                    // Return to main menu
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while(choice != 6);
    }

    @Override
    public void manageUsers() {
        System.out.println("Manage Users");
    }

    @Override
    public void manageStaff() {
        System.out.println("Manage Staff");
    }

    @Override
    public void addBook(String title, String author, String category, int quantity, HashMap additionalAttributes) {
        bookManager.addBook(title, author, category, quantity, additionalAttributes);
    }

    @Override
    public void removeBook(String title) {
        bookManager.removeBook(title);
    }

    @Override
    public void displayBooks() {
        bookManager.displayBooks();
    }
}