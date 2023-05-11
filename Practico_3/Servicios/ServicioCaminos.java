package Practico_3.Servicios;

import Practico_3.Grafo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ServicioCaminos {

    private Grafo<?> grafo;
    private int origen;
    private int destino;
    private int lim;

    // Servicio caminos
    public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
        this.grafo = grafo;
        this.origen = origen;
        this.destino = destino;
        this.lim = lim;
    }



    public List<List<Integer>> caminos(){
        return caminos(grafo,origen,destino,lim,new ArrayList<>());
    }
    private List<List<Integer>> caminos(Grafo<?> grafo, int actual, int destino, int lim,ArrayList<Integer> camino){
        List<List<Integer>> listaCaminos = new ArrayList<>();
        Iterator<Integer> iteradorAdyacentes = grafo.obtenerAdyacentes(actual);

        if(actual == destino){
            camino.add(destino);
            listaCaminos.add(camino);
        }else{
            camino.add(actual);
            while (iteradorAdyacentes.hasNext() && camino.size() <= lim){
                Integer temp = iteradorAdyacentes.next();
                listaCaminos.addAll(caminos(grafo,temp,destino,lim,camino));
            }
        }
        return listaCaminos;
    }
    /*public List<List<Integer>> caminos() {
        List<List<Integer>> listaCaminos = new ArrayList<>();
        Iterator<Integer> iteradorAdyacentes = grafo.obtenerAdyacentes(origen);
        Integer temp;
        while (iteradorAdyacentes.hasNext()){
            temp = iteradorAdyacentes.next();
            ArrayList<Integer> camino = new ArrayList<>();
            camino.add(temp);
            if(temp==destino){
                listaCaminos.add(camino);
                return listaCaminos;
            }else{
                if(camino.size() < lim){
                    listaCaminos.addAll(this.caminos(grafo,origen,destino,lim));
                }
            }
        }
        return listaCaminos;
    }
    private List<List<Integer>> caminos(Grafo<?> grafo, int actual, int destino, int lim){
        if(actual == destino){
            return new ArrayList<>(actual);
        }else{

        }
    }*/
}









