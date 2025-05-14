package Sprint1_Day1;

class Student {
    String name;
    String address;
    String section;
    static String college = "ABC College";
    static int rollNo = 1001;

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Section: " + section);
        System.out.println("College: " + college);
        System.out.println("Roll No: " + rollNo);
    }
}

public class Q9{
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Aditya";
        s.address = "Ranchi";
        s.section = "B13";
        s.display();
    }
}

