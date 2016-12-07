package Main.Lists;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList {

    class Node<E> {
        public E data;
        public Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public MyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void add(Object data) {
        try {
            if (isEmpty()) {
                first = new Node(data, null);
                last = first;
            } else {
                Node previousNode = last;
                last = new Node(data, null);
                previousNode.next = last;
            }
            size++;
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    @Override
    public void insert(int position, Object data) {
        Node currentNode = first;
        Node insertNode = new Node(data, null);
        if (position > size || position < 0) {
            throw new IndexOutOfBoundsException();
        }
        try {
            for (int i = 0; i < position && currentNode.next != null; i++) {
                currentNode = currentNode.next;
            }
            insertNode.next = currentNode.next;
            currentNode.next = insertNode;
            size++;
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public void remove(int position) {
        if (position > size || position < 0) {
            throw new IndexOutOfBoundsException();
        }
        try {
            Node currentNode = first;
            for (int i = 0; i < position; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
            size--;
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0 ? true : false;
    }

    class MyIterator implements Iterator<E> {

        private Node currentNode = first;

        @Override
        public boolean hasNext() {
            return currentNode != null ? true : false;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = (E) currentNode.data;
            currentNode = currentNode.next;
            return data;
        }
    }

    public Iterator<E> getIterator() {
        return new MyIterator();
    }
}
