package Practico_1;

public class Ejercicio_3 {
    public static void main(String[] args) {
        Stack<String> pila = new Stack<>();

        pila.push("Hola");
        pila.push("Como");
        pila.push("Te");
        pila.push("Está yendo");

        System.out.println(pila);
        System.out.println("Reversa: ");
        pila.reverse();
        System.out.println(pila);

        Stack<String> pila2 = new Stack<>();

        pila2.push("Hola");
        pila2.push("Como");
        pila2.push("Te");
        pila2.push("Está yendo");

        System.out.println("Tope: " + pila2.top());

        pila2.pop();
        System.out.println(pila);

    }
}
