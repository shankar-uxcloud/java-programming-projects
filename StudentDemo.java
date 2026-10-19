
class Student {

    private String name;
    private int age;
    private String course;

    // Constructor
    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Method
    public void displayDetails() {
        System.out.println("Student Details");
        System.out.println("--------------------");
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Course : " + course);
    }

    // Method
    public void checkAge() {
        if (age >= 18) {
            System.out.println("Status : Adult student");
        } else {
            System.out.println("Status : Young student");
        }
    }
}

public class StudentDemo {

    public static void main(String[] args) {

        Student s1 = new Student("Rahul", 20, "Java");
        Student s2 = new Student("Priya", 17, "Computer Science");

        s1.displayDetails();
        s1.checkAge();

        System.out.println();

        s2.displayDetails();
        s2.checkAge();
    }
}
