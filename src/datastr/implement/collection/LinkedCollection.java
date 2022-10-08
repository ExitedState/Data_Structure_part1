package datastr.implement.collection;

import datastr.interfaces.Collection;

public class LinkedCollection implements Collection {
    private static class LinkedNode {
        private Object element;
        private LinkedNode next;

        LinkedNode(Object element, LinkedNode next) {
            this.element = element;
            this.next = next;
        }
    }

    private LinkedNode header;
    private int size;

    public LinkedCollection() {
        this.header = new LinkedNode(null, null);
        this.size = 0;
    }

    @Override
    public void add(Object object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }
        header.next = new LinkedNode(object, header.next);
        size++;
    }

    @Override
    public void remove(Object object) {
        LinkedNode curr = header;
        while (curr.next != null && !curr.next.element.equals(object)) {
            curr = curr.next;
        }
        if (curr.next != null) {
            curr.next = curr.next.next;
            size--;
        }
    }

    @Override
    public boolean contains(Object object) {
        LinkedNode curr = header.next;
        while (curr != null && !curr.element.equals(object)) {
            curr = curr.next;
        }
        return curr != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

}
