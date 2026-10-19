
import java.util.ArrayList;
import java.util.Scanner;

class StudentRecord {
    private int id;
    private String name;
    private int age;
    private String course;

    public StudentRecord(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void display() {
        System.out.printf("%-8d %-20s %-8d %-20s%n",
                id, name, age, course);
    }
}

public class StudentManagementSystem {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<StudentRecord> students =
            new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
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
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);

        sc.close();
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = readInt();

        if (findStudent(id) != null) {
            System.out.println("A student with this ID already exists.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter age: ");
        int age = readInt();

        System.out.print("Enter course: ");
        String course = sc.nextLine().trim();

        if (name.isEmpty() || course.isEmpty() || age <= 0) {
            System.out.println("Invalid details. Student not added.");
            return;
        }

        students.add(new StudentRecord(id, name, age, course));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n--- Student Records ---");
        System.out.printf("%-8s %-20s %-8s %-20s%n",
                "ID", "Name", "Age", "Course");
        System.out.println("----------------------------------------------------------");

        for (StudentRecord student : students) {
            student.display();
        }
    }

    private static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        int id = readInt();

        StudentRecord student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("\nStudent found:");
            System.out.printf("%-8s %-20s %-8s %-20s%n",
                    "ID", "Name", "Age", "Course");
            student.display();
        }
    }

    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = readInt();

        StudentRecord student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter new age: ");
        int age = readInt();

        System.out.print("Enter new course: ");
        String course = sc.nextLine().trim();

        if (name.isEmpty() || course.isEmpty() || age <= 0) {
            System.out.println("Invalid details. Update cancelled.");
            return;
        }

        student.setName(name);
        student.setAge(age);
        student.setCourse(course);

        System.out.println("Student updated successfully!");
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = readInt();

        StudentRecord student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(student);
        System.out.println("Student deleted successfully!");
    }

    private static StudentRecord findStudent(int id) {
        for (StudentRecord student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    private static int readInt() {
        while (true) {
            String input = sc.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid whole number: ");
            }
        }
    }
}
