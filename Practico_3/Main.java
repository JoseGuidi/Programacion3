package Practico_3;

import Practico_3.Servicios.ServicioBFS;
import Practico_3.Servicios.ServicioCaminos;
import Practico_3.Servicios.ServicioDFS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        //grafo.borrarVertice(8);
        System.out.println(" ");
        //grafo.borrarArco(1,9);
        grafo.imprimirGrafo();
        System.out.println("Existe arco entre 3 y 9: " +grafo.existeArco(3,9));
        System.out.println("Obtener arco entre 3 y 9: " +grafo.obtenerArco(3,9));
        System.out.println("Cantidad de arcos: " + grafo.cantidadArcos());
        System.out.println("\nObtener vertices del grafo: ");
        Iterator<Integer> iteradorKey = grafo.obtenerVertices();
        while (iteradorKey.hasNext()){
            System.out.println(iteradorKey.next());
        }
        System.out.println("\nObtener adyacentes al vertice ...: ");
        Iterator<Integer> iteradorAdyacentes = grafo.obtenerAdyacentes(3);
        while (iteradorAdyacentes.hasNext()){
            System.out.println(iteradorAdyacentes.next());
        }
        System.out.println("\nObtener arcos del grafo: (origen,destino)");
        Iterator<Arco<Integer>> arcoIterator = grafo.obtenerArcos();
        while (arcoIterator.hasNext()){
            System.out.println(arcoIterator.next());
        }
        System.out.println("\nObtener arcos con origen en el vertice ...: ");
        Iterator<Arco<Integer>> arcoIteratorVertice = grafo.obtenerArcos(1);
        while (arcoIteratorVertice.hasNext()){
            System.out.println(arcoIteratorVertice.next());
        }
        System.out.println("-----DFS------");
        ServicioDFS dfs = new ServicioDFS(grafo);
        for(Integer i: dfs.dfsForest()){
            System.out.println(i);
        }
        System.out.println("-----BFS------");
        ServicioBFS bfs = new ServicioBFS(grafo);
        for(Integer i: bfs.bfsForest()){
            System.out.println(i);
        }
        System.out.println("-----CAMINOS------");
        GrafoDirigido<Integer> grafo2 = new GrafoDirigido<>();
        grafo2.agregarVertice(1);
        grafo2.agregarVertice(3);
        grafo2.agregarVertice(5);
        grafo2.agregarVertice(9);
        grafo2.agregarVertice(4);
        grafo2.agregarVertice(8);

        grafo2.agregarArco(1,3,null);
        grafo2.agregarArco(1,5,null);
        grafo2.agregarArco(1,9,null);
        grafo2.agregarArco(3,8,null);
        grafo2.agregarArco(5,8,null);
        grafo2.agregarArco(9,4,null);
        grafo2.agregarArco(4,8,null);

        ServicioCaminos scaminos = new ServicioCaminos(grafo2,1,8,2);
        for(List<Integer> a: scaminos.caminos()){
            System.out.println(a.toString());
        }
    }
}
