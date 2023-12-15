class VIPUser extends User {
    public VIPUser(int id, String username, int age) {
        super(id, username, age, new VIPSubscription());
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
