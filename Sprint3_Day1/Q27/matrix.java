package Q27;

public class matrix {
    public static void main(String[] args) throws InterruptedException {
        int[][] A = { {1, 2}, {3, 4} };
        int[][] B = { {5, 6}, {7, 8} };
        int[][] result = new int[2][2];

        Thread t1 = new Thread(() -> {
            result[0][0] = A[0][0]*B[0][0] + A[0][1]*B[1][0];
            result[0][1] = A[0][0]*B[0][1] + A[0][1]*B[1][1];
        });

        Thread t2 = new Thread(() -> {
            result[1][0] = A[1][0]*B[0][0] + A[1][1]*B[1][0];
            result[1][1] = A[1][0]*B[0][1] + A[1][1]*B[1][1];
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        for (int[] row : result) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
}
