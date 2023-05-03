package Practico_2_1;

public class main {
    public static void main(String[] args) {
        Tree arbol = new Tree(15);

        arbol.insert(8);
        arbol.insert(3);
        arbol.insert(16);
        arbol.insert(10);
        arbol.insert(20);
        arbol.insert(11);
        arbol.insert(17);
        arbol.insert(21);
        arbol.insert(27);
        arbol.insert(1);

    //  arbol.printTree();
        System.out.println("Print in order: ");
        arbol.printInOrder();
    /*    System.out.println("\n Print pos order");
        arbol.printPosOrder();
        System.out.println("\n Print pre order");
        arbol.printPreOrder();*/
     /*   System.out.println(" ");
        System.out.println("Se borro el elemento 17?: " + arbol.delete(17));
        System.out.println(" ");
        arbol.printInOrder();*/
    //  arbol.printTree();
    //    System.out.println("\n Altura: " + arbol.getHeight());
    /*    System.out.println("Rama mas larga: ");
        for(Tree t: arbol.getLongestBranch()){
            System.out.print(t.getRoot() + " ");
        }*/
    /*    System.out.println("\n Frontera: ");
        for(Tree t: arbol.getFrontera()){
            System.out.print(t.getRoot() + " ");
        }
        System.out.println("\n Maximo elemento: " + arbol.getMaxElem());
    */  System.out.println("\nElementos en el nivel 1: ");
        for (Tree t: arbol.getElemAtLevel(4)){
            System.out.print(t.getRoot() + " ");
        }
        System.out.println("\nSuma de internos: " + arbol.getSumOfIntern() );
        System.out.println("\nHojas mayores a 8: ");
        for (Tree t: arbol.getLeavesBiggerThat(8)){
            System.out.print(t.getRoot() + " ");
        }
    }
}
