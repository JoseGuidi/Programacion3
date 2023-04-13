package Practico_1;

public class MyDobleLinkedList<T> {
    private NodeDoble<T> first;
    private int size;
    public MyDobleLinkedList() {
        this.first = null;
        this.size = 0;
    }
    public void insertFront(T info){
        NodeDoble<T> newNode = new NodeDoble<>(info,null);
        if(isEmpty()){
            first = newNode;
        }else{
            first.setPrevious(newNode);
            newNode.setNext(first);
            first = newNode;
        }
        size++;
    }
    public T extractFront(){
        if(!isEmpty()){
            T aux = first.getInfo();
            if(first.getNext() != null) {
                first.getNext().setPrevious(null);
            }
            first = first.getNext();
            size--;
            return aux;
        }else
            return null;

    }
    public boolean isEmpty(){
        return size == 0;
    }
    public T get(int index){
        if(index < size){
            NodeDoble<T> aux = first;
            int i = 0;
            while (aux != null && i < index){
                aux = aux.getNext();
                i++;
            }
            return aux.getInfo();
        }else
            return null;
    }
    public int size(){
        return size;
    }
    public int indexOf(T elemento){
        NodeDoble<T> aux = first;
        int i = 0;
        while (aux != null && i < size && !aux.getInfo().equals(elemento)){
            aux = aux.getNext();
            i++;
        }
        if(aux == null){
            return -1;
        }else{
            return i;
        }
    }
    public void insertSorted(T info){
        NodeDoble<T> aux = new NodeDoble<>(info,null);
        if(isEmpty()){
            first = aux;
        } else if ((Integer) info < (Integer) first.getInfo()) {
            NodeDoble<T> aux2 = first;
            first = aux;
            aux2.setPrevious(aux);
            aux.setNext(aux2);
        }else{
            first.insertSorted(aux);
        }
        size++;
    }

    @Override
    public String toString() {
        if (isEmpty()){
            return "Lista vacia";
        }else{
            return "null <--> " + first.toString();
        }
    }
}
