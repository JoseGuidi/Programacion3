package Practico_1;

public class Node<T> {
    private T info;
    private Node<T> next;

    public Node() {
        this.info = null;
        this.next = null;
    }

    public Node(T info, Node<T> next) {
        this.setInfo(info);
        this.setNext(next);
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
    public boolean hasNext(){
        return this.next != null;
    }
    public void insertSorted(Node<T> newNode){
        if( !hasNext() ){
            next = newNode;
        }else if( (Integer) this.info > (Integer) next.getInfo()){
            newNode.setNext(this);
        }else{
            next.insertSorted(newNode);
        }
    }
    @Override
    public boolean equals(Object obj) {
        Node<T> otro = (Node<T>) obj;
        return otro.getInfo().equals(this.info);
    }

    @Override
    public String toString() {
        String text = "";
        if(next !=null){
            text = info.toString() + " --> " + next.toString();
        }else{
            text = info.toString();
        }
        return text;
    }
}
