package dk.sdu.mmmi.algo.utils.sortalgorithms;

import java.util.Arrays;

public class CountingSort {

    private int[] A;
    private int[] B;
    private int k;
    private boolean isSorted;

    public CountingSort(int[] A, int[] B, int k) {
        this.A = A;
        this.B = B;
        this.k = k;
    }

    private void sort() {
        int[] C = new int[k+1];

        // Count the how many times each number appear in array A
        for (int j = 0; j < A.length; j++) {
            C[A[j]] += 1;
        }

        for (int i = 1; i <= k; i++) {
            C[i] = C[i] + C[i-1];
        }

        for (int j = A.length-1; j >= 0; j--) {
            B[C[A[j]]-1] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }

        System.out.println("A-array (input): " + Arrays.toString(A));
        System.out.println("C-array (counting array): " + Arrays.toString(C));
        System.out.println("B-array (output): " + Arrays.toString(B));
        this.isSorted = true;
    }

    public int[] getSortedArray() {
        if (!this.isSorted) {
            this.sort();
        }

        return B;
    }

    public static void main(String[] args) {
        int[] A = new int[] {3, 0, 3, 3, 4, 0, 3, 1};
        int[] B = new int[A.length];
        int k = 6;

        CountingSort countingSort = new CountingSort(A, B, k);
        int[] sortedArray = countingSort.getSortedArray();

        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }
}
