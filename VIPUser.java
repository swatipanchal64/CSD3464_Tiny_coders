class VIPUser extends User {
    public VIPUser(String username, int age) {
        super(username, age, new VIPSubscription());
    }

    @Override
    public void borrowBook(String bookTitle) {
        System.out.println(getSubscriptionType() + " user " + username + " is borrowing book: " + bookTitle);
    }

    @Override
    public void returnBook(String bookTitle) {
        System.out.println(getSubscriptionType() + " user " + username + " is returning book: " + bookTitle);
    }
}
