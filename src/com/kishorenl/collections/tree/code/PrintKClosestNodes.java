package com.kishorenl.collections.tree.code;

import java.util.LinkedList;
import java.util.Stack;

public class PrintKClosestNodes {
    // o(n) soltuion..

    /**
     * @return <code>true</code> if result is already found.
     */
    private boolean closestKValuesHelper(LinkedList<Integer> list, Node root, double target, int k) {
        if (root == null) {
            return false;
        }

        if (closestKValuesHelper(list, root.left, target, k)) {
            return true;
        }

        if (list.size() == k) {
            if (Math.abs(list.getFirst() - target) < Math.abs(root.data - target)) {
                return true;
            } else {
                list.removeFirst();
            }
        }

        list.addLast(root.data);
        return closestKValuesHelper(list, root.right, target, k);
    }

    // o(log N ) solution

    public List<Integer> closestKValues(Node root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<Integer> precedessor = new Stack<>();
        Stack<Integer> successor = new Stack<>();

        getPredecessor(root, target, precedessor);
        getSuccessor(root, target, successor);

        for (int i = 0; i < k; i++) {
            if (precedessor.isEmpty()) {
                result.add(successor.pop());
            } else if (successor.isEmpty()) {
                result.add(precedessor.pop());
            } else if (Math.abs((double) precedessor.peek() - target) < Math.abs((double) successor.peek() - target)) {
                result.add(precedessor.pop());
            } else {
                result.add(successor.pop());
            }
        }

        return result;
    }

    private void getPredecessor(Node root, double target, Stack<Integer> precedessor) {
        if (root == null) {
            return;
        }

        getPredecessor(root.left, target, precedessor);

        if (root.data > target) {
            return;
        }

        precedessor.push(root.data);

        getPredecessor(root.right, target, precedessor);
    }

    private void getSuccessor(Node root, double target, Stack<Integer> successor) {
        if (root == null) {
            return;
        }

        getSuccessor(root.right, target, successor);

        if (root.data <= target) {
            return;
        }

        successor.push(root.data);

        getSuccessor(root.left, target, successor);
    }
}