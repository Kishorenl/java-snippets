package com.kishorenl.collections.stacknqueues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class StackTestsing {
    void test() {
        final Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.pop();
        stack.peek();
        stack.size();

        Queue<String> q = new LinkedList<>();
        q.add("test");

        final Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addLast(10);

        deque.getFirst();
        deque.getLast();

        deque.peekFirst();
        deque.peekLast();

        deque.size();
    }

    public static void main(final String args[]) {
        final StackTestsing stTest = new StackTestsing();
        stTest.test();
    }
}
