package Practico_1;

public class Ejercicio_7 {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> primerLista = new MySimpleLinkedList<>();
        primerLista.insertFront(8);
        primerLista.insertFront(3);
        primerLista.insertFront(5);
        primerLista.insertFront(4);
        primerLista.insertFront(7);
        primerLista.insertFront(10);
        MySimpleLinkedList<Integer> segundaLista = new MySimpleLinkedList<>();
        segundaLista.insertFront(8);
        segundaLista.insertFront(0);
        segundaLista.insertFront(4);
        segundaLista.insertFront(6);
        segundaLista.insertFront(10);
        segundaLista.insertFront(7);

        MySimpleLinkedList<Integer> listaNoComun = primerLista.getNotComunList(segundaLista);
        System.out.println("Lista de no comunes desordeanda: " + listaNoComun);
        System.out.println("---------------");
        MySimpleLinkedList<Integer> primerListaOrdenada = new MySimpleLinkedList<>();
        primerListaOrdenada.insertSorted(9);
        primerListaOrdenada.insertSorted(30);
        primerListaOrdenada.insertSorted(2);
        primerListaOrdenada.insertSorted(77);
        primerListaOrdenada.insertSorted(50);

        System.out.println("Primer lista ordenada: " + primerListaOrdenada);
        MySimpleLinkedList<Integer> segundaListaOrdenada = new MySimpleLinkedList<>();
        segundaListaOrdenada.insertSorted(20);
        segundaListaOrdenada.insertSorted(9);
        segundaListaOrdenada.insertSorted(30);
        segundaListaOrdenada.insertSorted(77);
        segundaListaOrdenada.insertSorted(50);
        System.out.println("Segunda lista ordenada: " + segundaListaOrdenada);

        MySimpleLinkedList<Integer> listaNoComunOrdenada = primerListaOrdenada.getNotComunListSorted(segundaListaOrdenada);
        System.out.println("lista de no comunes ordenada: " + listaNoComunOrdenada );
    }
}
