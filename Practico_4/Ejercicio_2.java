package Practico_4;

import java.util.ArrayList;

public class Ejercicio_2 {
    public static int MAX_FILAS = 4;
    public static int max_COL = 4;
    public static void main(String[] args) {
        Casillero[][] matrizCasillero = new Casillero[MAX_FILAS][max_COL];
        // norte arriba
        // este derecha
        // sur abajo
        // oeste izquierda
        Casillero c1 = new Casillero(1,false,true,true,false);
        Casillero c2 = new Casillero(2,false,true,true,true);
        Casillero c3 = new Casillero(2,false,true,true,true);
        Casillero c4 = new Casillero(2,false,false,true,true);
        Casillero c5 = new Casillero(5,true,true,true,false);
        Casillero c6 = new Casillero( 6,true,true,true,true);
        Casillero c7 = new Casillero( 7,true,true,true,true);
        Casillero c8 = new Casillero(8,true,false,true,true);
        Casillero c9 = new Casillero(9,true,true,true,false);
        Casillero c10 = new Casillero( 10,true,true,true,true);
        Casillero c11 = new Casillero( 11,true,true,true,true);
        Casillero c12 = new Casillero(12,true,false,true,true);
        Casillero c13 = new Casillero(13,true,true,false,false);
        Casillero c14 = new Casillero(14,true,true,false,true);
        Casillero c15 = new Casillero(15,true,true,false,true);
        Casillero c16 = new Casillero(16,true,false,false,true);

        matrizCasillero[0][0] = c1;
        matrizCasillero[0][1] = c2;
        matrizCasillero[0][2] = c3;
        matrizCasillero[0][3] = c4;

        matrizCasillero[1][0] = c5;
        matrizCasillero[1][1] = c6;
        matrizCasillero[1][2] = c7;
        matrizCasillero[1][3] = c8;

        matrizCasillero[2][0] = c9;
        matrizCasillero[2][1] = c10;
        matrizCasillero[2][2] = c11;
        matrizCasillero[2][3] = c12;

        matrizCasillero[3][0] = c13;
        matrizCasillero[3][1] = c14;
        matrizCasillero[3][2] = c15;
        matrizCasillero[3][3] = c16;
    }
    public static ArrayList<Casillero> buscarCaminoCorto(Casillero entrada,
                                                         Casillero salida,
                                                         Casillero[][] matriz){
        ArrayList<Casillero> visitados = new ArrayList<>();
        ArrayList<Casillero> caminoCorto = new ArrayList<>();
        ArrayList<Casillero> caminoActual = new ArrayList<>();
        caminoActual.add(entrada);

        return caminoCorto;
    }
    private static ArrayList<Casillero> buscarCaminoCorto(Casillero actual,
                                                          Casillero destino,
                                                          Casillero[][] matriz,
                                                          ArrayList<Casillero> caminoCorto,
                                                          ArrayList<Casillero> caminoActual,
                                                          ArrayList<Casillero> visitados){
    if(actual.equals(destino)){
        if(caminoActual.size() < caminoCorto.size()){
            caminoCorto.clear();
            caminoCorto.addAll(caminoActual);
        }
    }else{
        visitados.add(actual);
        ArrayList<Integer> posiciones = buscarPosCasillero(matriz,actual);
        int f = posiciones.get(0);
        int c = posiciones.get(1);
        if(actual.getOeste() && c > 0){ //tiene izquierda
                                // buscar camino por izquierda
            Casillero tmp = matriz[f][c-1];
            if(!visitados.contains(tmp)) {
                caminoActual.add(tmp);
                visitados.add(tmp);
                buscarCaminoCorto(tmp, destino, matriz, caminoCorto, caminoActual, visitados);
                caminoActual.remove(tmp);
                visitados.remove(tmp);
            }
        }

    }

     return caminoCorto;
    }
    private static ArrayList<Integer> buscarPosCasillero(Casillero[][] m, Casillero a){
        int i = 0,f = 0;
        boolean encontro = false;
        ArrayList<Integer> aux = new ArrayList<>();
        while (i < MAX_FILAS && !encontro){
            while (f < max_COL && !encontro){
                if(a.equals(m[i][f])){
                    encontro = true;
                    aux.add(i);
                    aux.add(f);
                }
            }
            i++;
        }
        return aux;
    }
}
