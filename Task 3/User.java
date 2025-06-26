public class User {
    public String name;
    public int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User: " + name + " | ID: " + userId;
    }
}
