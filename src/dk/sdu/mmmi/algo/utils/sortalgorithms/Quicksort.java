package dk.sdu.mmmi.algo.utils.sortalgorithms;

import java.util.Arrays;

public class Quicksort {

    public static int partition(int[] A, int p, int r) {
        int x = A[r];

        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i = i + 1;

                // Swap (exchange)
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        int temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] A = new int[] {4, 7, 1, 5, 8, 2, 5, 5};

        System.out.println("OBS: REMEMBER TO EXTRACT 1 FROM BOTH INPUT PARAMETERS");
        System.out.println(" E.g. the task says: PARTITION(A, 1, 8)  =>  PARTITION(A, 0, 7)");
        System.out.println("Input array: " + Arrays.toString(A));
        // OBS: REMEMBER TO EXTRACT 1 FROM BOTH INPUT PARAMETERS
        // E.g. the task says: PARTITION(A, 1, 8)  =>  PARTITION(A, 0, 7)
        partition(A, 0, 7);
        System.out.println("After partition: " + Arrays.toString(A));
    }
}
