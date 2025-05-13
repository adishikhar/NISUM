package Sprint1_Day2;

class Animal {
    void speak() {
        System.out.println("Animal is speaking");
    }
}

class Dog extends Animal {
    void speak() {
        System.out.println("Dog is barking");
    }
}

public class Q20
{
    public static void main(String[] args) {
        Animal a = new Dog(); // parent ref, child object
        a.speak(); // Dog's speak() is called
    }
}
