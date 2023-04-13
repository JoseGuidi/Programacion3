package Practico_1;

public class Ejercicio_13 {
    public static void main(String[] args) {
        int numeroMaximo = 6;
        System.out.println(calcularSerieFibonacci(numeroMaximo,0,1));
    }
    public static String calcularSerieFibonacci(int numeroMaximo, int numeroAnterior,int numeroActual){
        if(numeroActual+numeroAnterior > numeroMaximo){
            return "";
        }else{
            int numeroNuevo = numeroActual+numeroAnterior;
            if(numeroAnterior == 0 && numeroActual == 1) {
                return numeroAnterior + " " + numeroActual + " " + numeroNuevo + " " + calcularSerieFibonacci(numeroMaximo, numeroActual, numeroNuevo);
            } else {
                return numeroNuevo + " " + calcularSerieFibonacci(numeroMaximo, numeroActual, numeroNuevo);
            }
        }

    }
}
