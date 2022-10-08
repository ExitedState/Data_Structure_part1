package datastr.interfaces;

public interface List extends Collection {
    void add(int i, Object object);

    void remove(int i);

    Object get(int i);

    Object set(int i, Object object);
}
