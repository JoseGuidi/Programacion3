package Practico_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioDFS {
    private Grafo<?> grafo;
    private HashMap<Integer,String> recorrido;
    // en ves de string podria ser otra clase q tenga color, descu y final
    int tiempo;
    public ServicioDFS(Grafo<?> grafo) {
        this.grafo = grafo;
        this.recorrido = new HashMap<>();
        this.tiempo = 0;
    }

    public List<Integer> dfsForest() {
        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()){
            recorrido.put(it.next(), "BLANCO");
        }
        it = recorrido.keySet().iterator();
        while(it.hasNext()) {
            if(recorrido.get(it.next()).equals("BLANCO")){
               visitar(it.next());
            }
        }
        return new ArrayList<>();
    }
    private void visitar(Integer vertice){
        recorrido.put(vertice,"AMARILLO");
        tiempo++;
        // descubrimiento
        Iterator<Integer> it = grafo.obtenerAdyacentes(vertice);
        Integer temp;
        while (it.hasNext()){
            temp = it.next();
            if(recorrido.get(temp).equals("BLANCO")){
                visitar(temp);
            }
        }
        recorrido.put(vertice,"NEGRO");
        tiempo++;
    }
}
