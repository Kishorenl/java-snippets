package com.kishorenl.collections.arrays.code;

import java.util.Arrays;

/**
 * Given an array of distinct elements. The task is to find triplets in the
 * array whose sum is zero.
 */
public class TripletSum {
    // o(n^3) easy
    // o(n2) + space o(n) - Hash map with sum - doable.

    // o(n^2) - with o(1) space solution.
    static void findTriplets(int arr[], int n) {
        boolean found = false;

        // sort array elements
        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            // initialize left and right
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r) {
                if (x + arr[l] + arr[r] == 0) {
                    // print elements if it's sum is zero
                    System.out.print(x + " ");
                    System.out.print(arr[l] + " ");
                    System.out.println(arr[r] + " ");

                    l++;
                    r--;
                    found = true;
                }

                // If sum of three elements is less
                // than zero then increment in left
                else if (x + arr[l] + arr[r] < 0)
                    l++;

                // if sum is greater than zero than
                // decrement in right side
                else
                    r--;
            }
        }

        if (found == false)
            System.out.println(" No Triplet Found");
    }

}