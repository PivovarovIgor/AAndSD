package lesson3.stack;

public class StackImpl<E> implements Stack<E> {

    private final Object[] data;
    private int size;

    public StackImpl(int maxSize) {
        this.data =  new Object[maxSize];
    }

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        data[size++] = value;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E value = peek();
        data[--size] = null;
        return value;
    }

    @Override
    public E peek() {
        return (E)data[size - 1];
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
        for (int i = size - 1; i >= 0 ; i--) {
            sb.append(data[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }
}
