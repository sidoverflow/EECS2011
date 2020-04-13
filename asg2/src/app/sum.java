package app;
/***********************************
* CSE2011 - Assignment 2
* File name: kthsmallest.java
* Author: Sudarsan, Sidharth
* Email: lensman@my.yorku.ca
* CSE number: 216697120
************************************/
import java.util.Arrays;

public class sum {

   /*
    * EXHAUSTIVE ALGORITHM Returns true if array A contains two elements whose sum
    * is k. Returns false otherwise. n is the number of elements A contains.
    *
    * The running time of your algorithm is O(n^2). 
    */

   //sum_exh
   public static boolean sum_exh(int[] A, int n, int k) {
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            if (A[i] + A[j] == k && A[i] != A[j]) {
               return true;
            }
         }
      }
      return false;

   } // end sum_exh

   /*
    * RECURSIVE ALGORITHM Returns true if array A contains two elements whose sum
    * is k. Returns false otherwise. n is the number of elements A contains.
    *
    * The running time of your algorithm is O(n).
    */

   //sum_rec
   public static boolean sum_rec(int[] A, int n, int k) {
      if (A.length == 1) {
         return false;
      }
      if (A[0] + A[n - 1] == k) {
         return true;
      } else {
         if (A[0] + A[n - 1] > k) {
            int[] B = Arrays.copyOfRange(A, 0, n - 1);
            return sum_rec(B, n - 1, k);
         } else if (A[0] + A[n - 1] < k) {
            int[] B = Arrays.copyOfRange(A, 1, n);
            return sum_rec(B, n - 1, k);
         }
      }
      return false;

   } // end sum_rec

} // end class
