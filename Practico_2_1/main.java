package Practico_2_1;

public class main {
    public static void main(String[] args) {
        Tree arbol = new Tree(15);

        arbol.insert(8);
        arbol.insert(3);
        arbol.insert(16);
        arbol.insert(10);
        arbol.insert(17);

    //  arbol.printTree();
        arbol.printInOrder();
        System.out.println(" ");
        System.out.println("Se borro el elemento 17?: " + arbol.delete(17));
        System.out.println(" ");
        arbol.printInOrder();
    //  arbol.printTree();
    }
}
