class StandardUser extends User {
    public StandardUser(int id, String username, int age) {
        super(id, username, age, new BasicSubscription());
    }

    @Override
    public int getMaxBorrowLimit() {
        return ((BasicSubscription) subscription).getMaxBorrowLimit();
    }
}