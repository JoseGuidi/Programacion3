package Practico_1;

public class Stack<T> {
    private MySimpleLinkedList<T> pila;

    public Stack() {
        this.pila = new MySimpleLinkedList<>();
    }
    public void push(T objeto){
        this.pila.insertFront(objeto);
    }
    public T pop(){
        return this.pila.extractFront();
    }
    public T top(){
        return this.pila.get(this.pila.size()-1);
    }
    public void reverse(){
        if(!pila.isEmpty()){
            MySimpleLinkedList<T> pilaAux = new MySimpleLinkedList<>();
            while (!pila.isEmpty()){
                pilaAux.insertFront(this.pop());
            }
           pila = pilaAux;
        }
    }

    @Override
    public String toString() {
        return pila.toString();
    }
}
