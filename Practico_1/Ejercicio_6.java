package Practico_1;

public class Ejercicio_6 {
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

        MySimpleLinkedList<Integer> listaComun = primerLista.getComunList(segundaLista);
        System.out.println(listaComun);

        MySimpleLinkedList<Integer> primerListaOrdenada = new MySimpleLinkedList<>();
        primerListaOrdenada.insertSorted(9);
        primerListaOrdenada.insertSorted(30);
        primerListaOrdenada.insertSorted(1);
        primerListaOrdenada.insertSorted(77);
        primerListaOrdenada.insertSorted(8);
        primerListaOrdenada.insertSorted(0);
        primerListaOrdenada.insertSorted(20);
        System.out.println("Primer lista ordenada: " + primerListaOrdenada);
        MySimpleLinkedList<Integer> segundaListaOrdenada = new MySimpleLinkedList<>();
        segundaListaOrdenada.insertSorted(20);
        segundaListaOrdenada.insertSorted(30);
        segundaListaOrdenada.insertSorted(7);
        segundaListaOrdenada.insertSorted(77);
        segundaListaOrdenada.insertSorted(50);
        System.out.println("Segunda lista ordenada: " + segundaListaOrdenada);

        MySimpleLinkedList<Integer> listaComunOrdenada = primerListaOrdenada.getComunListSorted(segundaListaOrdenada);
        System.out.println("lista comun ordenada: " + listaComunOrdenada );

    }
}
