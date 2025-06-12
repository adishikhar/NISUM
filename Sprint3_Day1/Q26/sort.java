

import java.util.Arrays;

public class sort {
    static int[] arr = {5, 2, 9, 1, 6, 3, 7, 4, 8, 0, 10};

    public static void main(String[] args) throws InterruptedException {
        int mid = arr.length / 2;

        Thread t1 = new Thread(() -> Arrays.sort(arr, 0, mid));
        Thread t2 = new Thread(() -> Arrays.sort(arr, mid, arr.length));

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Arrays.sort(arr); 
        System.out.println(Arrays.toString(arr));
    }
}

