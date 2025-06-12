package Q21;

public class TwoThread {
    public static void main(String[] args) {
        Thread evenThread = new Thread() {
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    if (i % 2 == 0)
                        System.out.println("Even: " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        Thread oddThread = new Thread() {
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    if (i % 2 != 0)
                        System.out.println("Odd: " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        evenThread.start();
        oddThread.start();
    }
}
