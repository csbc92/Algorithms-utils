package dk.sdu.mmmi.algo.utils.shitngiggles;

public class exam2016opg10 {
    public static void main(String[] args) {

        int n = 11125; // Max input size is n <= 11125 due to stackoverflow..
        int[] A = new int[n+1];
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.MAX_VALUE;
        }

        int result = K(n, A); // Dynamic programming is Win!!
        //int result = K(n); // Slow ass method...

        //System.out.println(Arrays.toString(A));

        System.out.println("Result:" + result);
    }


    public static int K(int n, int[] A) {
        // Base case
        if (n == 0) {
            A[0] = 0;
            return 0;
        }

        int a = 1; // 1^2
        int min = Integer.MAX_VALUE; // +INFINITY

        if (A[n] != Integer.MAX_VALUE) {
            return A[n];
        }

        while(a <= n) {
            int value = 1 + K(n - a, A);

            if (value < min) {
                min = value;
                A[n] = min;
            }

            a = (int)Math.sqrt(a)+1;
            a *= a;
        }

        return min;
    }

    public static int K(int n) {
        // Base case
        if (n == 0)
            return 0;

        int a = 1; // 1^2
        int min = Integer.MAX_VALUE; // +INFINITY

        while(a <= n) {

            int value = 1 + K(n - a);

            if (value < min) {
                min = value;
            }

            a++;
            a *= a;
        }

        System.out.println(min);
        return min;
    }
}
