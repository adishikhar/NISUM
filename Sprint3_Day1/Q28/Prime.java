package Q28;

import java.util.Scanner;

public class Prime {
    static class SumThread extends Thread {
        int start, end;
        int sum = 0;

        SumThread(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean isPrime(int n) {
            if (n < 2) return false;
            for (int i = 2; i <= n / 2; i++)
                if (n % i == 0) return false;
            return true;
        }

        public void run() {
            for (int i = start; i <= end; i++) {
                if (isPrime(i)) sum += i;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter limit: ");
        int limit = sc.nextInt();

        int mid = limit / 2;
        SumThread t1 = new SumThread(2, mid);
        SumThread t2 = new SumThread(mid + 1, limit);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        int totalSum = t1.sum + t2.sum;
        System.out.println("Sum of primes up to " + limit + " = " + totalSum);
    }
}

