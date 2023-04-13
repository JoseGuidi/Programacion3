package Practico_1;

public class Ejercicio_12 {
    public static void main(String[] args) {
        System.out.println(pasajeBinario(-2));
    }
    public static String pasajeBinario(int numero){
        if(numero == 1){
            return "1";
        }else if (numero%2 == 0){
            return pasajeBinario(numero/2) +"0" ;
        }else if(numero%2 == 1){
            return pasajeBinario(numero/2) +"1" ;
        }else{
            return "0";
        }

    }
}
