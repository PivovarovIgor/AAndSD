package org.example.lesson3.queue;

/*
(дополнительно). 2. Закольцевать очередь, чтобы после извлечения элементов пустые ячейки переиспользовались
*/

public class QueueImpl<E> implements Queue<E> {

    protected final int DEFAULT_TAIL = -1;
    protected final int DEFAULT_HEAD = 0;

    protected final E[] data;
    protected int size;
    protected int tail;
    protected int head;

    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        tail = DEFAULT_TAIL;
        head = DEFAULT_HEAD;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }

        if (tail == data.length - 1) {
            tail = -1;
        }
        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        E value = data[head++];
        if (head == data.length) {
            head = 0;
        }
        size--;
        return value;
    }

    @Override
    public E peekFront() {
        return data[head];
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
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0, j = head; i < size; i++, j++) {
            if (j == data.length) {
                j = 0;
            }
            sb.append(data[j]);
            if (j != tail) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }
}
