package datastr.implement;

import datastr.interfaces.Collection;

public class ArrayCollection implements Collection {

    private Object[] elementData;
    private int size;

    public ArrayCollection() {
        this.elementData = new Object[1];
        this.size = 0;
    }

    @Override
    public void add(Object object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }
        ensureCap(++size);
        elementData[size] = object;
    }

    private void ensureCap(int cap) {
        if (elementData.length < cap) {
            int c = Math.max(cap, elementData.length * 2);
            Object[] temp = new Object[c];
            for (int i = 0; i < size; i++) {
                temp[i] = elementData[i];
            }
            elementData = temp;
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
    public void remove(Object object) {
        int tar = indexOf(object);
        if (tar != -1) {
            elementData[tar] = elementData[--size];
            elementData[size] = null;
        }
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
}
