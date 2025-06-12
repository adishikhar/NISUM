package Q22;

// Without synchronization
public class Counter {
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            public void run(){
for (int i = 0; i < 1000; i++) {
                count++;
            }
            }
            
        };

        Thread t2 = new Thread() {
            public void run(){
for (int i = 0; i < 1000; i++) {
                count++;
            }
            }
            
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter without sync: " + count);
    }
}

