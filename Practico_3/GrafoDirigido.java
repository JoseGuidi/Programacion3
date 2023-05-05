package Practico_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GrafoDirigido<T> implements Grafo<T> {
    private HashMap<Integer,ArrayList<Arco<T>>> listaAdyacencia;
    public GrafoDirigido(){
        listaAdyacencia = new HashMap<>();
    }
    public void agregarVertice(int keyVertice){
        this.listaAdyacencia.put(keyVertice,new ArrayList<>());
    }

    @Override
    public void borrarVertice(int verticeId) {
        for(ArrayList<Arco<T>> arcos: this.listaAdyacencia.values()){ //Recorro las lista de adyacentes -> O(v) -> v = cantidad de vertice
            Iterator<Arco<T>> arcoIterator = arcos.iterator();  // Las voy a iterar
            while(arcoIterator.hasNext()){                      // Mientras sigan habiendo adyacentes en un vertice, voy pidiendo el siguiente
                                                                // O(a) -> a = cantidad de arcos, en el peor de los casos el ultimo enlace es el que buscaba
                Arco<T> aux = arcoIterator.next();              // pido el siguiente
                if(aux.incluyeVertice(verticeId)){

                    arcoIterator.remove();                      // lo elimino
                }
            }
        }
        this.listaAdyacencia.remove(verticeId);

    }
    @Override
    public void agregarArco(int keyOrigen, int keyDestino,T etiqueta){
        if(listaAdyacencia.containsKey(keyOrigen) && listaAdyacencia.containsKey(keyDestino)){
            ArrayList<Arco<T>> aux = listaAdyacencia.get(keyOrigen); //obtengo la lista de arcos.
            Arco<T> arcoAux = new Arco<>(keyOrigen,keyDestino,etiqueta); //creo un nuevo arco
            aux.add(arcoAux);
            listaAdyacencia.put(keyOrigen,aux);
        }
    }

    /*
        Complejidad: O(a)
     */
    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if(listaAdyacencia.containsKey(verticeId1) && listaAdyacencia.containsKey(verticeId2)){
            Iterator<Arco<T>> arcoIterator = listaAdyacencia.get(verticeId1).iterator(); //O(1) -> accedo a un key especifico
            while (arcoIterator.hasNext()){   // O(a) -> a = cantidad arcos
                Arco<T> arcoAux = arcoIterator.next();
                if(arcoAux.incluyeVertice(verticeId2)){
                    arcoIterator.remove(); // O(1) -> elimina el ultimo elemento, no recorre de nuevo.
                }
            }
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return this.listaAdyacencia.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        if(listaAdyacencia.containsKey(verticeId1)&&listaAdyacencia.containsKey(verticeId2)){
            Iterator<Arco<T>> arcoIterator = listaAdyacencia.get(verticeId1).iterator();
            while (arcoIterator.hasNext()){
                Arco<T> aux = arcoIterator.next();
                if(aux.incluyeVertice(verticeId2))
                    return true;
            }
            arcoIterator = listaAdyacencia.get(verticeId2).iterator();
            while (arcoIterator.hasNext()){
                Arco<T> aux = arcoIterator.next();
                if(aux.incluyeVertice(verticeId1)){
                    return true;
                }
            }
            return false;
        }else
            return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if(listaAdyacencia.containsKey(verticeId1) && listaAdyacencia.containsKey(verticeId2)){
            Iterator<Arco<T>> arcoIterator = listaAdyacencia.get(verticeId1).iterator();
            while (arcoIterator.hasNext()){
                Arco<T> arcoAux = arcoIterator.next();
                if(arcoAux.incluyeVertice(verticeId2))
                    return arcoAux;
            }
            return null;
        }else
            return null;
    }

    @Override
    public int cantidadVertices() {
        return listaAdyacencia.size(); //O(1) HashMap tiene un atributo especifico para eso.
    }

    @Override
    public int cantidadArcos() {
        int total = 0;
        for(ArrayList<Arco<T>> arrayList : listaAdyacencia.values()){
            total+= arrayList.size();
        }
        return total;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return listaAdyacencia.keySet().iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        if(listaAdyacencia.containsKey(verticeId)){
            ArrayList<Integer> adyacentes = new ArrayList<>();
            Iterator<Arco<T>> arcoIterator = listaAdyacencia.get(verticeId).iterator();
            while (arcoIterator.hasNext()){ // O(a) -> En el peor de los casos verticeId es el origen de todos los arcos.
                adyacentes.add(arcoIterator.next().getDestino()); // poniendo next ya avanza al siguiente
            }
            return adyacentes.iterator();
        }else
            return null;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        ArrayList<Arco<T>> aux = new ArrayList<>();
        Iterator<ArrayList<Arco<T>>> arrayListIterator = listaAdyacencia.values().iterator();
        while (arrayListIterator.hasNext()){ // O(v) -> v = cantidad de vertices.
            aux.addAll(arrayListIterator.next());
        }
        return aux.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        if(listaAdyacencia.containsKey(verticeId)){
            return listaAdyacencia.get(verticeId).iterator();
        }else
            return null;
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

