abstract class User implements UserPermission, Subscription {
    protected String username;
    protected int age;

    protected Subscription subscription;

    public User(String username, int age, Subscription subscription) {
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
        return "Username=" + username + "\n\t" +
                "age=" + age + "\n" +
                subscription;
    }
}