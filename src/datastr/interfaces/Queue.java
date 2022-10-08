package datastr.interfaces;

public interface Queue {
    boolean isEmpty();

    int size();

    void enqueue(Object object);

    Object dequeue();

    Object peek();
}
