import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        boolean isLoggedIn = false;

        System.out.println(" Welcome to the Library System");

        while (true) {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            if (choice == 1) {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                System.out.print("Choose a User ID (number): ");
                int userId = scanner.nextInt();
                scanner.nextLine();
                User user = new User(name, userId);
                library.registerUser(user);

            } else if (choice == 2) {
                System.out.print("Enter your User ID to login: ");
                int loginId = scanner.nextInt();
                scanner.nextLine();
                isLoggedIn = library.loginUser(loginId);

                if (isLoggedIn) {
                    // Logged-in Menu
                    int userChoice;
                    do {
                        System.out.println("\n LIBRARY MENU:");
                        System.out.println("1. Add Book");
                        System.out.println("2. Issue Book");
                        System.out.println("3. Return Book");
                        System.out.println("4. Show Books");
                        System.out.println("5. Logout");
                        System.out.print("Enter your choice: ");
                        userChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (userChoice) {
                            case 1:
                                System.out.print("Enter book title: ");
                                String title = scanner.nextLine();
                                System.out.print("Enter author name: ");
                                String author = scanner.nextLine();
                                Book b = new Book(title, author);
                                library.addBook(b);
                                break;
                            case 2:
                                System.out.print("Enter title to issue: ");
                                String issueTitle = scanner.nextLine();
                                library.issueBook(issueTitle);
                                break;
                            case 3:
                                System.out.print("Enter title to return: ");
                                String returnTitle = scanner.nextLine();
                                library.returnBook(returnTitle);
                                break;
                            case 4:
                                library.showBooks();
                                break;
                            case 5:
                                System.out.println("Logged out.");
                                isLoggedIn = false;
                                break;
                            default:
                                System.out.println("Invalid option.");
                        }
                    } while (isLoggedIn);
                }

            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
