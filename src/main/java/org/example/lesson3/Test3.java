package org.example.lesson3;


import org.example.lesson3.queue.Queue;
import org.example.lesson3.queue.QueueImpl;
import org.example.lesson3.stack.Stack;
import org.example.lesson3.stack.StackImpl;

public class Test3 {

    public static void main(String[] args) {
//        testStack();
        testQueue();
    }

    private static void testStack() {

        Stack<Integer> stack = new StackImpl<>(4);

        System.out.println(stack.push(12));
        System.out.println(stack.push(16));
        System.out.println(stack.push(22));
        System.out.println(stack.push(5));
        System.out.println(stack.push(1));
        System.out.println(stack.push(32));

        stack.display();

        System.out.println("top value: " + stack.pop() );
        System.out.println("top value: " + stack.peek() );
        stack.display();
    }

    private static void testQueue() {

        Queue<Integer> queue = new QueueImpl<>(4);

        System.out.println("add element: " + queue.insert(34));
        System.out.println("add element: " + queue.insert(12));
        System.out.println("add element: " + queue.insert(20));
        System.out.println("add element: " + queue.insert(16));
        System.out.println("add element: " + queue.insert(14));
        System.out.println("add element: " + queue.insert(17));

        queue.display();
        System.out.println("remove: " + queue.remove());
        System.out.println("remove: " + queue.remove());
        queue.display();

        System.out.println("add element: " + queue.insert(50));
        System.out.println("add element: " + queue.insert(56));
        System.out.println("add element: " + queue.insert(66));
        queue.display();
        System.out.println("remove: " + queue.remove());
        queue.display();
        System.out.println("add element: " + queue.insert(66));
        queue.display();
    }

}
