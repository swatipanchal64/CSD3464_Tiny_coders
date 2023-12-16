class BasicSubscription implements Subscription {
    private String subscriptionType;
    private int maxBorrowLimit;

    public BasicSubscription() {
        this.subscriptionType = "Basic";
        this.maxBorrowLimit = 1;
    }

    public int getMaxBorrowLimit() {
        return maxBorrowLimit;
    }

    @Override
    public String getSubscriptionType() {
        return subscriptionType;
    }

    @Override
    public void displaySubscriptionDetails() {
        System.out.println("Basic Subscription Details:");
        System.out.println("Maximum Borrow Limit: " + maxBorrowLimit);
    }


    @Override
    public String toString() {
        return "\tBasicSubscription\n\t" +
                "Maximum Borrow Limit: " + maxBorrowLimit;
    }
}
