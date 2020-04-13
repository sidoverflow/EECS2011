package app;
/***********************************
* CSE2011 - Assignment 2
* File name: kthsmallest.java
* Author: Sudarsan, Sidharth
* Email: lensman@my.yorku.ca
* CSE number: 216697120
************************************/

import java.util.Arrays;

public class symm {

    /*
     * Returns true if array A is symmetric. Returns false otherwise. n is the
     * number of elements A contains.
     *
     * The running time of your algorithm is O(n).
     */
    //symmetric
    public static boolean symmetric(int[] A, int n) {

        int i = 0;
        int j = n - 1;

        if (n == 1) {
            return true;
        } else if (n == 2) {
            if (A[0] == A[1]) {
                return true;
            } else {
                return false;
            }

        }

        else {
            if (A[i] == A[j]) {
                A = Arrays.copyOfRange(A, 1, n - 1);
                return symmetric(A, A.length);
            } else {
                return false;
            }

        }

    }

    // end symmetric

} // end class
