package lesson3.stack;

public interface Stack<E> {

    boolean push(E value);

    E pop();

    E peek(); //top()

    int size();

    boolean isEmpty();

    boolean isFull();

    void display();

}
