package Practico_4;

import Practico_3.GrafoDirigido;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio_1 {
    public static void main(String[] args) {
        GrafoDirigido<Integer> edificio = new GrafoDirigido<>();
        // cada Integer es una sala
        edificio.agregarVertice(1);
        edificio.agregarVertice(2);
        edificio.agregarVertice(3);
        edificio.agregarVertice(4);
        edificio.agregarVertice(5);
        edificio.agregarVertice(6);
        edificio.agregarVertice(7);
        edificio.agregarVertice(8);
        edificio.agregarVertice(9);

        edificio.agregarArco(1,2,null);
        edificio.agregarArco(1,6,null);
        edificio.agregarArco(2,3,null);
        edificio.agregarArco(3,4,null);
        edificio.agregarArco(3,5,null);
        edificio.agregarArco(4,6,null);
        edificio.agregarArco(6,3,null);
        edificio.agregarArco(6,5,null);
        edificio.agregarArco(5,7,null);
        edificio.agregarArco(7,8,null);
        edificio.agregarArco(8,9,null);

        for (Integer i: buscarMaximoCamino(edificio,1,9)) {
            System.out.println(i + " ");
        }
    }
    public static ArrayList<Integer> buscarMaximoCamino(GrafoDirigido<Integer> grafo,Integer entrada, Integer salida) {
        ArrayList<Integer> visitados = new ArrayList<>();
        ArrayList<Integer> caminoMayor = new ArrayList<>();
        ArrayList<Integer> caminoActual = new ArrayList<>();
        caminoActual.add(entrada);
        buscarMaximoCamino(grafo,entrada,salida,caminoActual,visitados,caminoMayor);
        return caminoMayor;
    }
    private static ArrayList<Integer> buscarMaximoCamino(GrafoDirigido<Integer> grafo,Integer actual, Integer salida,
                                                  ArrayList<Integer> caminoActual, ArrayList<Integer> visitados,
                                                  ArrayList<Integer> caminoMayor){
        if(actual == salida){
            if(caminoActual.size() >= caminoMayor.size()){
                caminoMayor.clear();
                caminoMayor.addAll(caminoActual);
            }
        }else{
            Iterator<Integer> it = grafo.obtenerAdyacentes(actual);
            while (it.hasNext()){
                Integer tmp = it.next();
                if(!visitados.contains(tmp)){ //evita ciclos
                    visitados.add(tmp);
                    caminoActual.add(tmp);
                    buscarMaximoCamino(grafo,tmp,salida,caminoActual,visitados,caminoMayor);
                    caminoActual.remove(tmp); //para probar con otro camino
                    visitados.remove(tmp); //para probar otro camino que quizas se encuentra tmp
                }
            }
        }
        return caminoMayor;
    }
}
