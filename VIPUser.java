class VIPUser extends User {

    public VIPUser(int id, String username, int age) {
        super(id, username, age, new VIPSubscription());
    }

    @Override
    public int getMaxBorrowLimit() {
        return ((VIPSubscription) subscription).getMaxBorrowLimit();
    }

}
