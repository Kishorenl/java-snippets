
import java.util.Stack;
import java.util.Dequeue;
import java.util.LinkedList;

class StackTestsing{
    void test()
    {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.poll();
        stack.peek();
        stack.size();



        Dequeue<Integer> dequeue  = new LinkedList<>();
        dequeue.pushFirst(1);
        dequeue.pushLast(10);

        dequeue.pullFirst();
        dequeue.pullLast();

        dequeue.peekFirst();
        dequeue.peekLast();

        dequeue.size();
    }

    public static void main(String args[]){
        StackTestsing stTest = new StackTestsing();
        stTest.test();
    }
}


