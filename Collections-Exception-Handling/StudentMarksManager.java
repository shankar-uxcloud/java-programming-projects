
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public double getMarks() {
        return marks;
    }

    public void display() {
        System.out.printf("%-10d %-20s %-10.2f%n",
                id, name, marks);
    }
}

public class StudentMarksManager {

    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println("      STUDENT MARKS MANAGER");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    calculateAverage();
                    break;
                case 5:
                    System.out.println("Thank you for using the application!");
                    break;
                default:
                    System.out.println("Invalid choice. Select 1 to 5.");
            }

        } while (choice != 5);

        sc.close();
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = readInt();

        if (findStudent(id) != null) {
            System.out.println("Error: Student ID already exists.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
            return;
        }

        System.out.print("Enter marks (0-100): ");
        double marks = readDouble();

        if (marks < 0 || marks > 100) {
            System.out.println("Error: Marks must be between 0 and 100.");
            return;
        }

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n--- Student Records ---");
        System.out.printf("%-10s %-20s %-10s%n",
                "ID", "Name", "Marks");
        System.out.println("------------------------------------------");

        for (Student student : students) {
            student.display();
        }
    }

    private static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        int id = readInt();

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Error: Student not found.");
        } else {
            System.out.println("\nStudent found:");
            System.out.printf("%-10s %-20s %-10s%n",
                    "ID", "Name", "Marks");
            student.display();
        }
    }

    private static void calculateAverage() {
        if (students.isEmpty()) {
            System.out.println("Cannot calculate average: No records available.");
            return;
        }

        double total = 0;

        for (Student student : students) {
            total += student.getMarks();
        }

        double average = total / students.size();

        System.out.printf("Average marks: %.2f%n", average);
    }

    private static Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a whole number: ");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a valid number: ");
            }
        }
    }
}
