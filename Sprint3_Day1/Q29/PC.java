package Q29;

class Shared {
    int value;
    boolean available = false;

    synchronized void produce(int val) throws InterruptedException {
        while (available) wait();
        value = val;
        System.out.println("Produced: " + val);
        available = true;
        notify();
    }

    synchronized void consume() throws InterruptedException {
        while (!available) wait();
        System.out.println("Consumed: " + value);
        available = false;
        notify();
    }
}

public class PC {
    public static void main(String[] args) {
        Shared s = new Shared();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 4; i++) {
                    s.produce(i);
                }
            } catch (Exception e) {}
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 4; i++) {
                    s.consume();
                }
            } catch (Exception e) {}
        });

        producer.start();
        consumer.start();
    }
}

