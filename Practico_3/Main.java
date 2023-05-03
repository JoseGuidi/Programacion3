package Practico_3;

public class Main {
    public static void main(String[] args) {
        GrafoDirigido<Integer> grafo = new GrafoDirigido<>();

        grafo.agregarVertice(1);
        grafo.agregarVertice(8);
        grafo.agregarVertice(7);
        grafo.agregarVertice(3);
        grafo.agregarVertice(9);

        grafo.agregarArco(1,9,null);
        grafo.agregarArco(8,7,null);
        grafo.agregarArco(7,1,null);
        grafo.agregarArco(3,8,null);
        grafo.agregarArco(3,9,null);
        grafo.agregarArco(9,8,null);

        grafo.imprimirGrafo();

    }
}
