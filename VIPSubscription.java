class VIPSubscription implements Subscription {
    private String subscriptionType;
    private int maxBorrowLimit;
    private boolean accessToEBooks;

    public VIPSubscription() {
        this.subscriptionType = "VIP";
        this.maxBorrowLimit = 5;
        this.accessToEBooks = true;
    }

    @Override
    public String getSubscriptionType() {
        return subscriptionType;
    }

    @Override
    public void displaySubscriptionDetails() {
        System.out.println("VIP Subscription Details:");
        System.out.println("Maximum Borrow Limit: " + maxBorrowLimit);
        System.out.println("Access to E-Books: " + (accessToEBooks ? "Yes" : "No"));
    }

    @Override
    public String toString() {
        return "VIP Subscription Details:\n\t" +
                "subscriptionType='" + subscriptionType + "\n\t" +
                "Maximum Borrow Limit: " + maxBorrowLimit + "\n\t"+
                "Access to E-Books: " + (accessToEBooks ? "Yes" : "No");
    }
}
