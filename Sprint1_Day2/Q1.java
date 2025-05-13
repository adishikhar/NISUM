package Sprint1_Day2;

public class Q1 {
    public static void main(String[] args) {
        String str = "Aditya";

        Class<?> cls = str.getClass();

        System.out.println("Full Class Name: " + cls.getName());
        System.out.println("Simple Name: " + cls.getSimpleName());
        System.out.println("Is it Interface? " + cls.isInterface());
        System.out.println("Package: " + cls.getPackageName());

        }
    }
