import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    // Book Management
    public void addBook(Book b) {
        books.add(b);
        System.out.println("Added: " + b.title);
    }

    public void issueBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (!b.isIssued) {
                    b.issue();
                    System.out.println("Book issued: " + title);
                    return;
                } else {
                    System.out.println("Book already issued.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (b.isIssued) {
                    b.returnBook();
                    System.out.println("Book returned: " + title);
                    return;
                } else {
                    System.out.println("Book was not issued.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    public void showBooks() {
        System.out.println("\nBooks in Library:");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    // User Registration and Login
    public void registerUser(User u) {
        for (User user : users) {
            if (user.userId == u.userId) {
                System.out.println("User ID already registered.");
                return;
            }
        }
        users.add(u);
        System.out.println("User registered: " + u.name);
    }

    public boolean loginUser(int userId) {
        for (User user : users) {
            if (user.userId == userId) {
                System.out.println("Login successful. Welcome, " + user.name + "!");
                return true;
            }
        }
        System.out.println("User ID not found. Please register first.");
        return false;
    }
}
