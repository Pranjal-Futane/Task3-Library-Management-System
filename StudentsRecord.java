import java.util.ArrayList;
import java.util.Scanner;

public class StudentsRecord {
    
    static class Student {
        public int id;
        public String name;
        public double marks;

        public Student(int id, String name, double marks) {
            this.id = id;
            this.name = name;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return "Student ID: " + id + ", Name: " + name + ", Marks: " + marks;
        }
    }


    static ArrayList<Student> stud = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        System.out.println("\n--- Student Record Management ---");
        do {
            
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        stud.add(new Student(id, name, marks));
        System.out.println(" Student added.");
    }

    public static void viewStudents() {
        if (stud.isEmpty()) {
            System.out.println("No records found.");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student s : stud) {
                System.out.println(s);
            }
        }
    }

    public static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : stud) {
            if (s.id == id) {
                System.out.print("Enter new Name: ");
                s.name = sc.nextLine();
                System.out.print("Enter new Marks: ");
                s.marks = sc.nextDouble();
                System.out.println("✅ Student updated.");
                return;
            }
        }
        System.out.println(" Student not found.");
    }

    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (Student s : stud) {
            if (s.id == id) {
                stud.remove(s);
                System.out.println("✅ Student deleted.");
                return;
            }
        }
        System.out.println(" Student not found.");
    }
}
