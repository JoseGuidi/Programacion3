package Practico_1;

public class Ejercicio_8 {
    public static void main(String[] args) {
        MyDobleLinkedList<Integer> listaDoble = new MyDobleLinkedList<>();
        listaDoble.insertFront(8);
        listaDoble.insertFront(2);
        listaDoble.insertFront(1);
        listaDoble.insertFront(9);
        listaDoble.insertFront(3);

        System.out.println(listaDoble);

        listaDoble.extractFront();
        System.out.println(listaDoble);

        int indexBusqusqueda = 2;
        System.out.println("El elemento en la posicion "  + indexBusqusqueda + " es: " +  listaDoble.get(indexBusqusqueda));

        int elementoBuscado = 8;
        System.out.println("El elemento "  + elementoBuscado + " está en la posicion: " +  listaDoble.indexOf(elementoBuscado));

        MyDobleLinkedList<Integer> listaDobleOrdenada = new MyDobleLinkedList<>();
        listaDobleOrdenada.insertSorted(5);
        listaDobleOrdenada.insertSorted(8);
        listaDobleOrdenada.insertSorted(0);
        listaDobleOrdenada.insertSorted(1);
        listaDobleOrdenada.insertSorted(3);
        listaDobleOrdenada.insertSorted(10);

        System.out.println(listaDobleOrdenada);
    }
}
