package com.kishorenl.collections.recursion;

public class josephus {
    static int josephusIndex(int n, int k) {
        if (n == 1)
            return 1;
        else
            /*
             * The position returned by josephus(n - 1, k) is adjusted because the recursive
             * call josephus(n - 1, k) considers the original position k%n + 1 as position 1
             */
            return (josephusIndex(n - 1, k) + k - 1) % n + 1;
    }
}