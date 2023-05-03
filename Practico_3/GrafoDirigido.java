package Practico_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GrafoDirigido<T> {
    private HashMap<Integer,ArrayList<Arco<T>>> listaAdyacencia;
    public GrafoDirigido(){
        listaAdyacencia = new HashMap<>();
    }
    public void agregarVertice(int keyVertice){
        this.listaAdyacencia.put(keyVertice,new ArrayList<>());
    }
    public void agregarArco(int keyOrigen, int keyDestino,T etiqueta){
        if(listaAdyacencia.containsKey(keyOrigen) && listaAdyacencia.containsKey(keyDestino)){
            ArrayList<Arco<T>> aux = listaAdyacencia.get(keyOrigen); //obtengo la lista de arcos.
            Arco<T> arcoAux = new Arco<>(keyOrigen,keyDestino,etiqueta); //creo un nuevo arco
            aux.add(arcoAux);
            listaAdyacencia.put(keyOrigen,aux);
        }
    }






    // HECHO POR CHAT GPT
    public void imprimirGrafo() {
        for (Map.Entry<Integer, ArrayList<Arco<T>>> entry : listaAdyacencia.entrySet()) {
            Integer vertice = entry.getKey();
            ArrayList<Arco<T>> arcos = entry.getValue();
            System.out.print(vertice + ": ");
            if (arcos != null) {
                for (Arco<T> arco : arcos) {
                    System.out.print(arco.getDestino() + "(" + arco.getEtiqueta() + ") ");
                }
            }
            System.out.println();
        }
    }
}

