package Main.Lists;

import java.util.Iterator;

public interface MyList<E> {
    void add(E data);

    void insert(int position, E data);

    void remove(int position);

    int size();

    Iterator<E> getIterator();
}
