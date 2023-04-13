package Practico_1;

import java.lang.reflect.Array;

public class Ejericicio_10 {
    public static void main(String[] args) {
        int[] array = {0,5,6,8,9};
        for (Integer ele:array){
            System.out.print(ele + " | ");
        }
        System.out.println("\n" + estaOrdenado(array,0,array.length));

    }
    public static boolean estaOrdenado(int[] array,int pos,int length) {
        System.out.println(pos);
        if(pos < length - 1 ){
            return (array[pos] <= array[pos+1] && estaOrdenado(array,pos+1,length));
        }
        if(pos == length - 1){
            return true;
        }
        return false;
    }
}
