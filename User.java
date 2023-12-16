abstract class User implements UserPermission, Subscription {

    protected int id;
    protected String username;
    protected int age;

    private int borrowedBooksCount = 0;

    protected Subscription subscription;

    public User(int id, String username, int age, Subscription subscription) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.subscription = subscription;
    }

    @Override
    public String getSubscriptionType() {
        return subscription.getSubscriptionType();
    }

    @Override
    public void displaySubscriptionDetails() {
        subscription.displaySubscriptionDetails();
    }

    @Override
    public String toString() {
        return "UserId:" + id + "\n\t" +
               "Username:" + username + "\n\t" +
               "Age:" + age + "\n" +
                subscription;
    }

    @Override
    public void borrowBook(int bookId,  BookManagement bookManager) {
        if (borrowedBooksCount < getMaxBorrowLimit()) {
            Book borrowedBook = bookManager.findBook(bookId);
            if (borrowedBook != null && borrowedBook.getQuantity() > 0) {
                System.out.println(getSubscriptionType() + " user " + username + " is borrowing book: " + borrowedBook.getTitle());
                borrowedBooksCount++;
                borrowedBook.setQuantity(borrowedBook.getQuantity() - 1);
                System.out.println("Remaining copies of " + borrowedBook.getTitle() + ": " + borrowedBook.getQuantity());
            } else {
                System.out.println("Book not available or maximum borrow limit reached.");
            }
        } else {
            System.out.println("Cannot borrow more books. Maximum borrow limit reached.");
        }
    }

    @Override
    public void returnBook(int bookId,  BookManagement bookManager) {
        Book returnedBook = bookManager.findBook(bookId);
        if (returnedBook != null) {
            System.out.println(getSubscriptionType() + " user " + username + " is returning book: " + returnedBook.getTitle());
            borrowedBooksCount--;
            returnedBook.setQuantity(returnedBook.getQuantity() + 1);
            System.out.println("Remaining copies of " + returnedBook.getTitle() + ": " + returnedBook.getQuantity());
        } else {
            System.out.println("Book not found. Unable to return.");
        }
    }

    public abstract int getMaxBorrowLimit();
}