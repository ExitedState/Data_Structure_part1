package datastr.implement.collection;

import datastr.interfaces.List;

public class ArrayList implements List {

    Object[] elementData;
    int size;

    public ArrayList() {
        this.elementData = new Object[1];
        this.size = 0;
    }

    @Override
    public void add(Object object) {
        add(size, object);
    }

    private void ensureCapacity(int cap) {
        if (cap > elementData.length) {
            int s = Math.max(cap, elementData.length * 2);
            Object[] temp = new Object[s];
            for (int i = 0; i < size; i++) {
                temp[i] = elementData[i];
            }
            elementData = temp;
        }
    }

    @Override
    public void remove(Object object) {
        int i = indexOf(object);
        if (i >= 0) {
            remove(i);
        }
    }

    private int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int i, Object object) {
        ensureCapacity(size + 1);
        for (int j = size - 1; j >= i; j--) {
            elementData[j + 1] = elementData[j];
        }
        elementData[i] = object;
        size++;
    }

    @Override
    public void remove(int i) {
        for (int j = i + 1; j < size; j++) {
            elementData[j - 1] = elementData[j];
        }
        elementData[size--] = null;
    }

    @Override
    public Object get(int i) {
        return elementData[i];
    }

    @Override
    public Object set(int i, Object object) {
        return elementData[i] = object;
    }
}
