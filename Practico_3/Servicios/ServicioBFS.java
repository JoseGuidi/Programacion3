package Practico_3.Servicios;

import Practico_3.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioBFS {

    private Grafo<?> grafo;
    private ArrayList<Integer> listaDeRecorridos, fila;
    private HashMap<Integer,String> recorrido;

    public ServicioBFS(Grafo<?> grafo) {
        this.grafo = grafo;
        listaDeRecorridos = new ArrayList<>();
        fila = new ArrayList<>();
        recorrido = new HashMap<>();
    }

    public List<Integer> bfsForest() {
        Iterator<Integer> vertices = grafo.obtenerVertices();
        listaDeRecorridos.clear();
        while (vertices.hasNext()){
            recorrido.put(vertices.next(),"BLANCO");
        }
        vertices = grafo.obtenerVertices();
        while (vertices.hasNext()){
            Integer temp = vertices.next();
            if(recorrido.get(temp).equals("BLANCO")){
                visitarBFS(temp);
            }
        }
        return listaDeRecorridos;
    }
    private void visitarBFS(Integer vertice){
        recorrido.put(vertice,"NEGRO");
        fila.add(vertice);
        listaDeRecorridos.add(vertice);
        Integer temp;
        while (!fila.isEmpty()){
            Integer actual = fila.remove(0);
            Iterator<Integer> vADY = grafo.obtenerAdyacentes(actual);
            while (vADY.hasNext()){
                temp = vADY.next();
                if(recorrido.get(temp).equals("BLANCO")){
                    listaDeRecorridos.add(temp);
                    recorrido.put(temp,"NEGRO");
                    fila.add(temp);
                }
            }
        }
    }
}
