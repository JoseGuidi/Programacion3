package Practico_1;

public class Ejercicio_4 {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> listaVinculada = new MySimpleLinkedList<>();

        listaVinculada.insertFront(4);
        listaVinculada.insertFront(50);
        listaVinculada.insertFront(6);
        listaVinculada.insertFront(10);

        System.out.println(listaVinculada);
        System.out.println("s------------");
        int valBuscado = 4;
        System.out.println("Index de " + +valBuscado + ": " + listaVinculada.indexOf(valBuscado));
    }
}
