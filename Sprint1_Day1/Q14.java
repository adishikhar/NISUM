package Sprint1_Day1;

class Vehicle {
    String fuel = "Diesel";
    int wheels = 4;

    void display() {
        System.out.println("Fuel Type: " + fuel);
        System.out.println("No. of Wheels: " + wheels);
    }
}

class Car extends Vehicle {
    String brand = "Honda";
}

class Bus extends Vehicle {
    int seats = 50;
}

public class Q14 {
    public static void main(String[] args) {
        Car c = new Car();
        System.out.println("Car Info:");
        c.display();
        System.out.println("Brand: " + c.brand);

        System.out.println();

        Bus b = new Bus();
        System.out.println("Bus Info:");
        b.display();
        System.out.println("Seats: " + b.seats);
    }
}

