package com.kishorenl.collections.stack;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class StackTestsing {
    void test() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.pop();
        stack.peek();
        stack.size();

        Deque<Integer> dequeue = new LinkedList<>();
        dequeue.addFirst(1);
        dequeue.addLast(10);

        dequeue.getFirst();
        dequeue.getLast();

        dequeue.peekFirst();
        dequeue.peekLast();

        dequeue.size();
    }

    public static void main(String args[]) {
        StackTestsing stTest = new StackTestsing();
        stTest.test();
    }
}
