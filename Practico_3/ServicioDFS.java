package Practico_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioDFS {
    private Grafo<?> grafo;
    private HashMap<Integer,VerticeRecorrido> recorrido;
    // en ves de string podria ser otra clase q tenga color, descu y final
    int tiempo;
    private  ArrayList<Integer> listaDeRecorridos;
    public ServicioDFS(Grafo<?> grafo) {
        this.grafo = grafo;
        this.recorrido = new HashMap<>();
        this.tiempo = 0;
        listaDeRecorridos = new ArrayList<>();
    }

    public List<Integer> dfsForest() {
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()){
            recorrido.put(vertices.next(),new VerticeRecorrido());
        }

        tiempo = 0;
        vertices = recorrido.keySet().iterator();
        while (vertices.hasNext()){
            Integer temp = vertices.next();
            if(recorrido.get(temp).getColor().equals("BLANCO")){
                visitar(temp);
            }
        }
        return listaDeRecorridos;
    }
    private void visitar(Integer vertice){
        recorrido.get(vertice).setColor("AMARILLO");
        tiempo++;
        recorrido.get(vertice).settDescubrimiento(tiempo);
        Iterator<Integer> vAdyacentes = grafo.obtenerAdyacentes(vertice);
        while (vAdyacentes.hasNext()){
            Integer temp = vAdyacentes.next();
            if(recorrido.get(temp).getColor().equals("BLANCO")){
                visitar(temp);
            }else if (recorrido.get(temp).getColor().equals("AMARILLO")){
                System.out.println("Hay ciclo");
            }
        }
        recorrido.get(vertice).setColor("NEGRO");
        listaDeRecorridos.add(vertice);
        tiempo++;
        recorrido.get(vertice).settFinal(tiempo);
    }
}
