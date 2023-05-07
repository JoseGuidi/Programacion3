package Practico_3;

public class PruebaExtraDeBFS {
    public static void main(String[] args) {
        GrafoDirigido<Integer> grafoDirigido = new GrafoDirigido<>();

        grafoDirigido.agregarVertice(1);
        grafoDirigido.agregarVertice(9);
        grafoDirigido.agregarVertice(8);
        grafoDirigido.agregarVertice(10);
        grafoDirigido.agregarVertice(3);
        grafoDirigido.agregarVertice(5);

        grafoDirigido.agregarArco(1,9,null);
        grafoDirigido.agregarArco(9,10,null);
        grafoDirigido.agregarArco(9,3,null);
        grafoDirigido.agregarArco(1,8,null);
        grafoDirigido.agregarArco(8,5,null);

        ServicioBFS bfs = new ServicioBFS(grafoDirigido);
        for(Integer i: bfs.bfsForest()){
            System.out.println(i);
        }

    }
}
