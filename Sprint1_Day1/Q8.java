package Sprint1_Day1;

class Q8 {
    static {
        System.out.println("Static block is executed first as it is executed only once when the class is loaded in the memory befor any creation of object or method call");
    }

    public static void main(String[] args) {
        System.out.println("Main method is executed");
    }
}

