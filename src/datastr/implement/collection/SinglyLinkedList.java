package datastr.implement.collection;

import datastr.interfaces.List;

public class SinglyLinkedList implements List {
    private static class LinkedNode {
        Object element;
        LinkedNode next;

        public LinkedNode(Object element, LinkedNode next) {
            this.element = element;
            this.next = next;
        }
    }

    private final LinkedNode header;
    private int size;

    public SinglyLinkedList() {
        this.header = new LinkedNode(null, null);
        this.size = 0;
    }

    @Override
    public void add(Object object) {
        add(size, object);
    }

    @Override
    public void remove(Object object) {
        LinkedNode curr = header;
        while (curr.next != null && !curr.next.element.equals(object)) {
            curr = curr.next;
        }
        removeAfter(curr);
    }

    private void removeAfter(LinkedNode p) {
        if (p.next != null) {
            p.next = p.next.next;
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
        return size;
    }

    private LinkedNode nodeAt(int i) {
        LinkedNode curr = header;
        for (int j = -1; j < i; j++) {
            curr = curr.next;
        }
        return curr;
    }

    @Override
    public void add(int i, Object object) {
        LinkedNode curr = nodeAt(i - 1);
        curr.next = new LinkedNode(object, curr.next);
        size++;
    }

    @Override
    public void remove(int i) {
        LinkedNode p = nodeAt(i - 1);
        removeAfter(p);
    }

    @Override
    public Object get(int i) {
        return nodeAt(i).element;
    }

    @Override
    public Object set(int i, Object object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }
        return nodeAt(i).element = object;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ header -> ");
        LinkedNode curr = header.next;
        while (curr != null) {
            sb.append(curr.element);
            if (curr.next != null) {
                sb.append(" -> ");
            }
            curr = curr.next;
        }
        sb.append(" -> null ]");
        return sb.toString();
    }
}
