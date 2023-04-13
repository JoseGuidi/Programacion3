package Practico_1;

public class NodeDoble<T> {
    private NodeDoble<T> previous;
    private NodeDoble<T> next;
    private T info;
    public NodeDoble(T info, NodeDoble<T> anterior){
        this.previous = anterior;
        this.info = info;
        next = null;
    }

    public void setNext(NodeDoble<T> next) {
        this.next = next;
    }

    public void setPrevious(NodeDoble<T> previous) {
        this.previous = previous;
    }

    public NodeDoble<T> getPrevious() {
        return previous;
    }

    public NodeDoble<T> getNext() {
        return next;
    }

    public T getInfo() {
        return info;
    }
    public void insertSorted(NodeDoble<T> newNode){
        if(next == null){
            next = newNode;
            newNode.setPrevious(this);
        }else if( (Integer) newNode.getInfo() < (Integer) next.getInfo()){
            next.setPrevious(newNode);
            newNode.setNext(next);
            next=newNode;
        }else{
            next.insertSorted(newNode);
        }
    }
    @Override
    public String toString() {
        String texto;
        if(next != null){
            return getInfo().toString() + " <--> " + next.toString();
        }else{
            return getInfo().toString() + " <--> null";
        }

    }
}
