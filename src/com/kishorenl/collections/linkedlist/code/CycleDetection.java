package com.kishorenl.collections.linkedlist.code;

public class CycleDetection {

    // Better compared to Floyd's
    // Brent's cycle detection
    // 24 to 36 % faster than the Floyd's cycle algorithm. O(n) time complexity,
    // O(1) space complexity.
    public static boolean hasLoop(Node root) {
        if (root == null)
            return false;

        Node slow = root, fast = root;
        int taken = 0, limit = 2;

        while (fast.next != null) {
            fast = fast.next;
            taken++;
            if (slow == fast)
                return true;

            if (taken == limit) {
                taken = 0;
                limit <<= 1; // equivalent to limit *= 2;
                slow = fast; // teleporting the turtle (to the hare's position)
            }
        }
        return false;
    }

    // Floyd's
    boolean hasLoopFloyd(Node first) {
        Node slow = first;
        Node fast = first;

        while (fast != null && fast.next != null) {
            slow = slow.next; // 1 hop
            fast = fast.next.next; // 2 hops

            if (slow == fast) // fast caught up to slow, so there is a loop
                return true;
        }
        return false; // fast reached null, so the list terminates
    }

}