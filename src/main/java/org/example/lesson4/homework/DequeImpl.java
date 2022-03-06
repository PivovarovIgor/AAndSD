package org.example.lesson4.homework;

import org.example.lesson4.deque.Deque;
/*
1. Реализовать Deque (с возможностью обратного прохода)
 */
public class DequeImpl<E> implements Deque<E> {

    private int size;
    private Node<E> left;
    private Node<E> right;

    public DequeImpl() {
        size = 0;
    }

    @Override
    public boolean insert(E value) {
        return insertLeft(value);
    }

    @Override
    public E remove() {
        return removeRight();
    }

    @Override
    public E peekFront() {
        if (isEmpty()) {
            return null;
        }
        return right.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public boolean insertLeft(E value) {
        left = new Node<>(value, left, null);
        if (left.next != null) {
            left.next.previous = left;
        }
        if (right == null) {
            right = left;
        }
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        right = new Node<>(value, null, right);
        if (right.previous != null) {
            right.previous.next = right;
        }
        if (left == null) {
            left = right;
        }
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = left;
        if (removedNode.next == null) {
            left = null;
            right = null;
        } else {
            left = removedNode.next;
            left.previous = null;
            removedNode.next = null;
        }
        size--;
        return removedNode.item;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = right;
        if (removedNode.previous == null) {
            left = null;
            right = null;
        } else {
            right = removedNode.previous;
            right.next = null;
            removedNode.previous = null;
        }
        size--;
        return removedNode.item;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        Node<E> current = left;
        while (current != null) {
            sb.append("[")
            .append(current.item)
            .append("]");
            current = current.next;
            if (current != null) {
                sb.append("<->");
            }
        }
        return sb.toString();
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> previous;
        Node(E item, Node<E> next, Node<E> previous) {
            if (item == null) {
                throw new IllegalArgumentException("Item must be not null.");
            }
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }
}
