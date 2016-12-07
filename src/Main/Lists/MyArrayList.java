package Main.Lists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements MyList {

    private E[] array;
    private int size;

    public MyArrayList() {
        size = 0;
        array = (E[]) new Object[size];
    }

    @Override
    public void add(Object data) {
        try {
            size++;
            array = Arrays.copyOf(array, size);
            array[size - 1] = (E) data;
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    @Override
    public void insert(int position, Object data) {
        if (position > size || position < 0) {
            throw new IndexOutOfBoundsException();
        }
        try {
            size++;
            E[] tmp = (E[]) new Object[size];
            System.arraycopy(array, 0, tmp, 0, position - 1);
            tmp[position - 1] = (E) data;
            System.arraycopy(array, position - 1, tmp, position, size - position);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    @Override
    public void remove(int position) {
        if (position > size || position < 0) {
            throw new IndexOutOfBoundsException();
        }
        try {
            size--;
            E[] tmp = (E[]) new Object[size];
            System.arraycopy(array, 0, tmp, 0, position - 1);
            System.arraycopy(array, position, tmp, position, size - position);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    @Override
    public int size() {
        return size;
    }

    class MyIterator implements Iterator<E> {

        private int position = 0;
        private E current = array[position];

        @Override
        public boolean hasNext() {
            return position < size - 1 ? true : false;
        }

        @Override
        public E next() {
            position++;
            current = array[position];
            return current;
        }
    }

    @Override
    public Iterator getIterator() {
        return new MyIterator();
    }
}
