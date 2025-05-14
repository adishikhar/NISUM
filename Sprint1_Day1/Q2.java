package Sprint1_Day1;

class Car {
    String name;

    Car(String n) {
        name = n;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Car a1 = new Car("BMW");
        Car a2 = new Car("BMW");
        Car a3 = a1; //giving the reference of a1 to a3

        System.out.println(a1.toString()); //Sprint1_Day2.Car@23a5fd2
        System.out.println(a1.equals(a2)); //False because two different object
        System.out.println(a1.equals(a3)); //True
        System.out.println(a1.getClass()); //class Sprint1_Day2.Car
    }
}

