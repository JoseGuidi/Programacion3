package Practico_1;

public class Ejercicio_1 {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> listaVinculada = new MySimpleLinkedList<>();

        listaVinculada.insertFront(4);
        listaVinculada.insertFront(50);
        listaVinculada.insertFront(6);
        listaVinculada.insertFront(10);

        System.out.println(listaVinculada);
        System.out.println("------------");
        System.out.println(listaVinculada.extractFront());
        System.out.println(listaVinculada);
        System.out.println("------------");
        System.out.println("Esta vacia: " + listaVinculada.isEmpty());
        System.out.println("Tamaño: " + listaVinculada.size());
        System.out.println("Nodo 1: " + listaVinculada.get(1));
    }

}
