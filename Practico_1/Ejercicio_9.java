package Practico_1;

public class Ejercicio_9 {
    public static void main(String[] args) {
        String texto = "seres";
        System.out.println("La palabra " + texto + " es capicua: " + esCapicua(texto));
    }
    public static boolean esCapicua(String palabra){
        if(palabra.length() <= 1){
            return true;
        }
        if(palabra.charAt(0) == palabra.charAt(palabra.length()-1) ){
            return esCapicua(palabra.substring(1,palabra.length()-1));
        }else {
            return false;
        }
    }
}
