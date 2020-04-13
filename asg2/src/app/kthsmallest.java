package app;
/***********************************
* CSE2011 - Assignment 2
* File name: kthsmallest.java
* Author: Sudarsan, Sidharth
* Email: lensman@my.yorku.ca
* CSE number: 216697120
************************************/

import java.util.Arrays;

public class kthsmallest {

    public static final int MaxSize = 500;

    /*
     * Return the value of the kth smallest element of array A. n is the number of
     * elements A contains, and k <= n. The running time of your algorithm must be
     * O(n).
     *
     */

    // kth_smallest
    public static int find_kth_smallest(int[] A, int n, int k) {

        int i = -1;
        int pivot = A[n - 1];

        for (int j = 0; j < n; j++) {
            if (A[j] < pivot) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, n - 1, ++i);

        // compare value of k with the current position of pivot
        if (k < (getIndex(A, pivot, n) + 1)) {
            int[] B = Arrays.copyOfRange(A, 0, getIndex(A, pivot, n));
            return find_kth_smallest(B, B.length, k);
        } else if (k > (getIndex(A, pivot, n) + 1)) {
            int[] B = Arrays.copyOfRange(A, getIndex(A, pivot, n) + 1, n);
            return find_kth_smallest(B, B.length, k - (getIndex(A, pivot, n) + 1));
        } else {
            return A[getIndex(A, pivot, n)]; // base case
        }

    } // end kth_smallest

    // swap A[a] and A[b] in A
    public static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    // get index of pivot in an array A of distinct integers
    public static int getIndex(int[] A, int pivot, int n) {
        for (int i = 0; i < n; i++) {
            if (A[i] == pivot)
                return i;
        }
        return -1;
    }

} // end class