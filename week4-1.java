import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int id;

     
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

     
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

     
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

 class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

     
    public void addStudent(String name, int id) {
        Student newStudent = new Student(name, id);
        students.add(newStudent);
        System.out.println("Student added: " + newStudent);
    }

     
    public void removeStudent(int id) {
        boolean found = false;
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Student removed: " + s);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("List of students:");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Student \n2. Remove Student \n3. Display Students \n4. ExitEnter your choice: ");
             choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    sc.nextLine();   
                    String name = sc.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();
                    manager.addStudent(name, id);
                    break;
                case 2:
                    System.out.print("Enter student ID to remove: ");
                    int removeId = sc.nextInt();
                    manager.removeStudent(removeId);
                    break;
                case 3:
                    manager.displayStudents();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 4);

        
    }
}
