package com.kishorenl.collections.arrays.code;

/**
 * Given n non-negative integers a_1, a_2, ..., a_n where each represents a
 * point at coordinate (i, a_i) . ‘ n ‘ vertical lines are drawn such that the
 * two endpoints of line i is at (i, a_i) and (i, 0). Find two lines, which
 * together with x-axis forms a container, such that the container contains the
 * most water.
 * 
 * https://www.geeksforgeeks.org/container-with-most-water/
 * 
 */

public class ContainerWithMostWater {

    // o(n^2) is easy
    // o(n)
    public static int maxArea(int A[], int len) {
        int l = 0;
        int r = len - 1;
        int area = 0;

        while (l < r) {
            // Calculating the max area
            area = Math.max(area, Math.min(A[l], A[r]) * (r - l));

            if (A[l] < A[r])
                l += 1;

            else
                r -= 1;
        }
        return area;
    }
}