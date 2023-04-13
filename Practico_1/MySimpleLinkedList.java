package Practico_1;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T>{
    private Node<T> first;
    private int size;
    public MySimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info,null);
        if(first == null){
            first = tmp;
        }else{
            tmp.setNext(first);
            first = tmp;
        }
        size++;
    }

    public T extractFront() {
        if(first != null) {
            T infoFirst = first.getInfo();
            first = first.getNext();
            return infoFirst;
        }else
            return null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T get(int index) {
        System.out.println("hola");
        if(index < size && index >= 0) {
            int i = 0;
            Node<T> tmp = first;
            while (i < index){
                tmp.getNext();
                i++;
            }
            return tmp.getInfo();
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    public int indexOf(T elemento){
        Node<T> tmp = first;
        Node<T> aux2 = new Node<>(elemento,null);
        int i = 0;
        boolean encontro = false;
        while (i < size && !encontro){
           if(/*tmp.equals(aux2*/ tmp.getInfo().equals(elemento)){
               encontro= true;
           }else{
               i++;
               tmp = tmp.getNext();
           }
        }
        if(!encontro){
            i = -1;
        }
        return i;
    }
    public MySimpleLinkedList<T> getComunList(MySimpleLinkedList<T> otra){
        MySimpleLinkedList<T> newList = new MySimpleLinkedList<>();
        for(T elem: this){
            if(otra.contains(elem)){
                newList.insertSorted(elem);
            }
        }
        return newList;
    }
    public boolean contains(T elem){
        Node<T> tmp = first;
        while (tmp != null){
            if(tmp.getInfo().equals(elem)){
                return true;
            }else{
                tmp = tmp.getNext();
            }
        }
        return false;
    }
    public void insertSorted(T newElem){
        Node<T> newNode = new Node<>(newElem,null);
        if(this.isEmpty() || (Integer) first.getInfo() > (Integer) newNode.getInfo()){
            newNode.setNext(first);
            first = newNode;
        }else {
            Node<T> tmp = first;
            while (tmp.getNext() != null && (Integer) newElem > (Integer) tmp.getNext().getInfo()) {
                tmp = tmp.getNext();
            }
            newNode.setNext((tmp.getNext()));
            tmp.setNext(newNode);
        }
    }
    public MySimpleLinkedList<T> getComunListSorted(MySimpleLinkedList<T> otra){
        MySimpleLinkedList<T> newList = new MySimpleLinkedList<>();
        MyListIterator<T> it_1 = new MyListIterator<>(first);
        MyListIterator<T> it_2 = new MyListIterator<>(otra.first);
        while (it_1.hasNext() && it_2.hasNext()){
            if(it_1.getNext().equals(it_2.getNext())){
                newList.insertSorted(it_1.getNext());
                it_2.next();
                it_1.next();
            }else if ((Integer) it_1.getNext() > (Integer) it_2.getNext()){
                it_2.next();
            }else{
                it_1.next();
            }
        }
        return newList;
    }

    public MySimpleLinkedList<T> getNotComunList(MySimpleLinkedList<T> otra){
        MySimpleLinkedList<T> newList = new MySimpleLinkedList<>();
        for(T elem: this){
            if(!otra.contains(elem)){
                newList.insertSorted(elem);
            }
        }
        for(T elem:otra){
            if(!this.contains(elem) && !newList.contains(elem)){
                newList.insertSorted(elem);
            }
        }
        return newList;
    }
    public MySimpleLinkedList<T> getNotComunListSorted(MySimpleLinkedList<T> otra){
        MySimpleLinkedList<T> newList = new MySimpleLinkedList<>();
        MyListIterator<T> it_1 = new MyListIterator<>(first);
        MyListIterator<T> it_2 = new MyListIterator<>(otra.first);
        while (it_1.hasNext() && it_2.hasNext()){

            if((Integer) it_1.getNext() < (Integer) it_2.getNext() && !it_1.getNext().equals(it_2.getNext())){
                newList.insertSorted(it_1.getNext());
                it_1.next();
            }else if((Integer) it_1.getNext() > (Integer) it_2.getNext() && !it_1.getNext().equals(it_2.getNext())){
                newList.insertSorted(it_2.getNext());
                it_2.next();
            }else{
                it_1.next();
                it_2.next();
            }

        }
        return newList;
    }

    @Override
    public String toString() {
        if(first != null){
            return first.toString();
        }else
            return "lista vacia";
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator<>(first);
    }
}
