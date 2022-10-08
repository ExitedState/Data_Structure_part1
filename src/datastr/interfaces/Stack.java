package datastr.interfaces;

public interface Stack {
    boolean isEmpty();

    int size();

    void push(Object object);

    Object pop();

    Object peek();
}
