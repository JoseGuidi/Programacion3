package Practico_1;

import static java.lang.Math.floor;

public class Ejercicio_11 {
    public static void main(String[] args) {
        int[] array = {0,2,5,6,8,9,11,13};
        for (Integer ele:array){
            System.out.print(ele + " | ");
        }
        System.out.println("\n" + existeElemento(array,8,0,array.length-1) );
    }

    public static boolean existeElemento(int[] arr, int nroBuscado, int inicio, int fin){
        if(inicio>fin){
            return false;
        }else {
            int medio = (inicio + fin) / 2;
            if(nroBuscado > arr[medio]){
                return existeElemento(arr,nroBuscado,medio+1,fin);
            }else if (nroBuscado < arr[medio]){
                return existeElemento(arr,nroBuscado,inicio,medio-1);
            }else{
                return true;
            }

        }
    }
}
