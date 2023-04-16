package Practico_2;
public class Ejercicio_2 {
    public static void main(String[] args) {

        int[] arrayMergeSort = {4, 3, 5, 8, 1, 9, 0};
        Ejercicio_1.mostrarArreglo(arrayMergeSort);
        mergeSort(arrayMergeSort,0,arrayMergeSort.length-1);
        Ejercicio_1.mostrarArreglo(arrayMergeSort);

        /*int[] arrayQuickSort = {4, 3, 5, 8, 1, 9, 0};
        Ejercicio_1.mostrarArreglo(arrayQuickSort);

        Ejercicio_1.mostrarArreglo(arrayQuickSort);*/
    }
    public static void mergeSort(int[] arr,int inicio, int fin){
         //final real del arreglo
        if(inicio < fin){
            int medio = (inicio + fin)/2;
            mergeSort(arr,inicio,medio);
            mergeSort(arr,medio+1,fin);

            merge(arr,inicio,fin,medio);
        }
    }
    public static void merge(int[] arr, int low, int high, int middle){
        int[] helper = new int[arr.length];
        for (int i = low; i <= high; i++) {
            helper[i] = arr[i];
        }
        int i = low;
        int j = middle + 1;
        int k = low;
    // copiar de manera ordenada al array original los valores de la
    // mitad izquierda o de la derecha
        while (i <= middle && j <= high) {
            if (helper[ i ] <= helper[ j ]) {
                arr[ k ] = helper[ i ];
                i++;
            } else {
                arr[ k ] = helper[ j ];
                j++;
            }
            k++;
        }
    // si quedaron elementos copiarlos al array original
        while (i <= middle) {
            arr[ k ] = helper[ i ];
            k++;
            i++;
        }
        while (j <= high) {
            arr[ k ] = helper[ j ];
            k++;
            j++;
        }
    }
}

