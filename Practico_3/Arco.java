package Practico_3;

public class Arco<T> {
    private int origen, destino;
    private T etiqueta;
    public Arco(int o, int d, T e){
        origen = o;
        destino = d;
        etiqueta = e;
    }

    public int getOrigen() {
        return origen;
    }

    public int getDestino() {
        return destino;
    }

    public T getEtiqueta() {
        return etiqueta;
    }
}
