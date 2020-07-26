package com.kishorenl.collections.arrays.code;

/**
 * Given three sorted arrays A[], B[] and C[], find 3 elements i, j and k from
 * A, B and C respectively such that max(abs(A[i] – B[j]), abs(B[j] – C[k]),
 * abs(C[k] – A[i])) is minimized. Here abs() indicates absolute value.
 */

// o(p+q+r) - great solution -- just because the arrays are sorted
public class ClosestIn3Arrays {
    static void findClosest(int A[], int B[], int C[], int p, int q, int r) {
        int diff = Integer.MAX_VALUE; // Initialize min diff

        // Initialize result
        int res_i = 0, res_j = 0, res_k = 0;

        // Traverse arrays
        int i = 0, j = 0, k = 0;
        while (i < p && j < q && k < r) {
            // Find minimum and maximum of current three elements
            int minimum = Math.min(A[i], Math.min(B[j], C[k]));
            int maximum = Math.max(A[i], Math.max(B[j], C[k]));

            // Update result if current diff is
            // less than the min diff so far
            if (maximum - minimum < diff) {
                res_i = i;
                res_j = j;
                res_k = k;
                diff = maximum - minimum;
            }

            // We can't get less than 0
            // as values are absolute
            if (diff == 0)
                break;

            // Increment index of array
            // with smallest value
            if (A[i] == minimum)
                i++;
            else if (B[j] == minimum)
                j++;
            else
                k++;
        }

        // Print result
        System.out.println(A[res_i] + " " + B[res_j] + " " + C[res_k]);
    }
}