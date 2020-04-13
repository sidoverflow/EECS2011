package app;
/***********************************
* CSE2011 - Assignment 2
* File name: kthsmallest.java
* Author: Sudarsan, Sidharth
* Email: lensman@my.yorku.ca
* CSE number: 216697120
************************************/

public class match {

   /*
    * EXHAUSTIVE ALGORITHM Returns index i if array A contains an element A[i] such
    * that A[i] = i. If there exist many of such elements, return the index of any
    * one of them. Returns -1 if there exists no element A[i] such that A[i] == i.
    * n is the number of elements A contains.
    *
    * The running time of your algorithm is O(n)
    */

   public static int match_exh(int[] A, int n) {
      for (int i = 0; i < A.length; i++) {
         if (A[i] == i) {
            return i;
         }
      }
      return -1;
   } // end match_exh

   /*
    * DIVIDE-AND-CONQUER ALGORITHM Returns index i if array A contains an element
    * A[i] such that A[i] = i. If there exist many of such elements, return the
    * index of any one of them. Returns -1 if there exists no element A[i] such
    * that A[i] == i. n is the number of elements A contains.
    *
    * The running time of your algorithm is O(log n). 
    */

   public static int match_dac(int[] A, int n) {
      return match_dac_helper(A, n, 0, n - 1);

   } // end match_dac

   public static int match_dac_helper(int[] A, int n, int beg, int last) {
      int mid = (beg + last) / 2;

      if (A[mid] == mid) {
         return mid;
      } else {
         if (A[mid] > mid && beg <= mid - 1) {
            return match_dac_helper(A, n, beg, mid - 1);
         } else if (A[mid] < mid && mid + 1 <= last) {
            return match_dac_helper(A, n, mid + 1, last);
         } else {
            return -1;
         }
      }

   } // end match_dac_helper

} // end class
