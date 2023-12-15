abstract class User implements UserPermission, Subscription {

    protected int id;
    protected String username;
    protected int age;

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
}