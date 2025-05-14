import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    String grade;

    Student(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}

public class Q2 {
    ArrayList<Student> students = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Grade: ");
        String grade = sc.nextLine();

        students.add(new Student(id, name, grade));
        System.out.println("Student added successfully.\n");
    }

    void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        int id = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == id) {
                students.remove(i);
                System.out.println("Student removed \n");
                return;
            }
        }
        System.out.println("Student not found.\n");
    }

    void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == id) {
                System.out.println("Student Found: " + students.get(i).name + " - Grade: " + students.get(i).grade + "\n");
                return;
            }
        }
        System.out.println("Student not found.\n");
    }

    void displayAll() {
        if (students.isEmpty()) {
            System.out.println("List is Empty.\n");
            return;
        }

        System.out.println("All Students:");
         for (int i = 0; i < students.size(); i++) {
            System.out.println("ID: " + students.get(i).id );
            System.out.println("Name: " + students.get(i).name);
            System.out.println("Grade: " + students.get(i).grade);
        }
        System.out.println();
    }

    void runApp() {
        int choice;

        do {
            System.out.println("=== Student Management Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: removeStudent(); break;
                case 3: searchStudent(); break;
                case 4: displayAll(); break;
                case 5: System.out.println("Exit"); break;
                default: System.out.println("Invalid choice.\n");
            }

        } while (choice != 5);

    }

    public static void main(String[] args) {
        Q2 obj = new Q2();  // create object
        obj.runApp();       // call non-static methods through object
    }
}
