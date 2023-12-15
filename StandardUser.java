class StandardUser extends User {
    public StandardUser(String username, int age) {
        super(username, age, new BasicSubscription());
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