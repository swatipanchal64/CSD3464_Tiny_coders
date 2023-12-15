import java.util.ArrayList;
import java.util.List;

class UserManager {
    private List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.username);
    }

    public void displayUsers() {
        System.out.println("------------Users------------");
        for (User user : users) {
            System.out.println("-------------------------");
            System.out.println(user);
        }
    }

    public void removeUser(String username) {
        users.removeIf(user -> user.username.equals(username));
        System.out.println("User removed: " + username);
    }

    public User findUser(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }
}