package Practico_2;

public class Ejercicio_1 {
    public static void main(String[] args) {
        int[] arraySelection = {4,3,5,8,1,9,0};
        mostrarArreglo(arraySelection);
        sortBySelection(arraySelection); // Complejidad de O(n^2)
        mostrarArreglo(arraySelection);

        int[] arrayBurbujeo = {4,3,5,8,1,9,0};
        mostrarArreglo(arrayBurbujeo);
        sortByBurbujeo(arrayBurbujeo); // Complejidad de O(n^2)
        mostrarArreglo(arrayBurbujeo);
        // ambos tienen dos for anidados, por lo que se accede dos veces
        // a la memoria en cada solicitud.
    }
    public static void sortBySelection(int[] arr){
        int indice;
        for(int i = 0; i < arr.length;i++){
            indice = i;
            for(int j = i; j < arr.length; j++){
                if(arr[j] < arr[indice]){
                    indice = j;
                }
            }
            int tmp = arr[indice];
            arr[indice] = arr[i];
            arr[i] = tmp;
        }
    }
    public static void mostrarArreglo(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "   ");
        }
        System.out.println("\n");
    }
    public static void sortByBurbujeo(int[] arr){
        int tmp;
        for(int i = 0; i < arr.length-1 ; i++){
            for(int j = 0; j < arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}
