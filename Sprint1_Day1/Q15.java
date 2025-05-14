package Sprint1_Day1;

class Student {
    public String college = "XYZ University";
    private int math = 80;
    private int science = 75;
    private int english = 85;

    public void showMarks() {
        System.out.println("Math: " + math);
        System.out.println("Science: " + science);
        System.out.println("English: " + english);
    }
}

public class Q15 {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println("College: " + s.college);
        s.showMarks(); // access private marks through method
    }
}

