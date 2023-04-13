package Practico_1;

import java.util.Iterator;

public class MyListIterator<T> implements Iterator<T> {
    private Node<T> cursor;

    public MyListIterator(Node<T> first) {
        this.cursor = first;
    }

    public boolean hasNext(){
        return this.cursor != null;
    }
    public T getNext(){
        return cursor.getInfo();
    }
    public T next(){
        T aux = cursor.getInfo();
        cursor = cursor.getNext();
        return aux;
    }
}
