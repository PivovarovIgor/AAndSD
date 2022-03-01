package org.example.lesson4.homework;

import org.example.lesson4.deque.Deque;

public class TestMain {
    public static void main(String[] args) {

        Deque<Integer> deque = new DequeImpl<>();

        deque.display();
        System.out.println("remove right: " + deque.removeRight());
        System.out.println("remove left: " + deque.removeLeft());
        System.out.println("remove: " + deque.remove());
        deque.display();
        System.out.println("size = " + deque.size());
        deque.insertRight(1);
        deque.display();
        System.out.println("size = " + deque.size());
        System.out.println("remove right: " + deque.removeRight());
        System.out.println("remove left: " + deque.removeLeft());
        System.out.println("size = " + deque.size());
        deque.insertLeft(1);
        deque.insertRight(2);
        deque.insertRight(3);
        deque.insertLeft(4);
        deque.display();
        System.out.println("size = " + deque.size());
        System.out.println("remove right: " + deque.removeRight());
        deque.display();
        System.out.println("size = " + deque.size());
        System.out.println("remove left: " + deque.removeLeft());
        System.out.println("remove left: " + deque.removeLeft());
        deque.display();
        System.out.println("size = " + deque.size());
        System.out.println("remove right: " + deque.removeRight());
        System.out.println("remove right: " + deque.removeRight());
        System.out.println("size = " + deque.size());
        deque.display();
        System.out.println("size = " + deque.size());
    }
}
