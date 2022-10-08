package datastr.interfaces;

public interface Map {
    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

    Object get(Object key);

    Object put(Object key, Object value);

    void remove(Object key);
}
