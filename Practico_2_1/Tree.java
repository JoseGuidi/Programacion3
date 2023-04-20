package Practico_2_1;

import java.util.ArrayList;

public class Tree {
    private Integer value;
    private Tree left;
    private Tree right;

    public Tree(int v) {
        this.value = v;
        left = null;
        right = null;
    }

    public Integer getRoot() {
        return value;
    }
    private Tree getRight(){
        return right;
    }
    private Tree getLeft(){
        return left;
    }

    public boolean hasElem(Integer elem) {
        boolean response;
        if (left != null) {
            if (left.value.equals(elem)) {
                response = true;
            } else {
                response = left.hasElem(elem);
            }
        } else if (right != null) {
            if (right.value.equals(elem)) {
                response = true;
            } else {
                response = right.hasElem(elem);
            }
        } else {
            response = false;
        }
        return response;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public void insert(Integer elem) {
        if (value > elem) {
            if (left == null) {
                left = new Tree(elem);
            } else {
                left.insert(elem);
            }
        } else if (value < elem) {
            if (right == null) {
                right = new Tree(elem);
            } else {
                right.insert(elem);
            }
        }
    }

    private void setLeft(Tree left) {
        this.left = left;
    }

    private void setRight(Tree right) {
        this.right = right;
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        if(value!= null) {
            System.out.print(value + " ");
        }
        if (right != null) {
            right.printInOrder();
        }
    }
    public void printPosOrder(){
        if(left != null)
            left.printPosOrder();
        if(right != null)
            right.printPosOrder();
        System.out.print(value + " ");
    }
    public void printPreOrder(){
        System.out.print(value + " ");
        if(left != null)
            left.printPreOrder();
        if(right != null)
            right.printPreOrder();
    }
    public boolean delete(Integer elem){
        return this.deleteWithParent(null,elem);
     }
    private boolean deleteWithParent(Tree parent, Integer elem){
        if(!value.equals(elem)){
            //recorrer
            if(value>elem && left != null) // ya que si elem no existe en el arbol, sin left != null voy a seguir bajando hasta un nullpoint..
                return left.deleteWithParent(this,elem);
            else if( value<elem && right != null)// ya que si elem no existe en el arbol, sin right != null voy a seguir bajando hasta un nullpoint..
                return right.deleteWithParent(this,elem);
        }else{
            //borrar
            if(parent != null){
                boolean isLeft = parent.getRoot() > value; //indica hacia donde debe apuntar el parent
                if(right == null && left == null){
                    if(isLeft){
                        parent.setLeft(null);
                    }else{
                        parent.setRight(null);
                    }
                    return true;
                }else if ((right == null ) || (left== null)){
                    if(right == null) { //si está a la izquierda (el hijo)
                        if (isLeft) {
                            parent.setLeft(left);
                        } else {
                            parent.setRight(left);
                        }
                    }else{ //entonces el hijo del que quiero borrar
                            // esta a la derecha
                        if (isLeft) {
                            parent.setLeft(right);
                        } else {
                            parent.setRight(right);
                        }
                    }
                    return true;
                }else {
                    //ultimo posible caso, que tenga dos hijos
                    //busco el nodo mas izquierdo del sub arbol derecho y lo pongo al que quiero borrar, luego lo elimino (al nmisd).
                    /* PASOS:
                        1) ya encontre el nodo a borrar, es this.
                        2) Apartir de este arbol, tengo que encontrar el NMISB
                        3) Cambio el valor de este arbol por el que encontre y llamo a la funcion de eliminar al que encontre pasandole this como parent.
                        4) Eliminar NMISB antes de cambiar el valor, por lo tanto guardarlo e nuna variable.
                     */
                    Integer value_NMISB = this.searchNMISB().getRoot();
                    this.deleteWithParent(this,value_NMISB);
                    this.value=value_NMISB;
                    return true;
                }
            }else{
                if(right == null && left == null) {
                    value = null;
                }
                else if((right == null ) || (left== null) ){
                    if(right !=null) {
                        value = right.getRoot();
                        right = right.getRight();
                    } else {
                        value = left.getRoot();
                        left = left.getLeft();
                    }
                }else{
                    Integer value_NMISB = this.searchNMISB().getRoot();
                    this.deleteWithParent(this,value_NMISB);
                    this.value=value_NMISB;
                }
                return true;
            }
        }
        return false;
    }

    public Tree searchNMISB(){
        if(left != null){
            return left.searchNMISB();
        }else{
            return this;
        }
    }
    public int getHeight(){
        return getHeight(0);
    }
    private int getHeight(int altura){
        if(left == null && right == null){
            return altura;
        }else{
            int alturaIzq = 0, alturaDer = 0;
            if(left != null)
                alturaIzq = left.getHeight(altura+1);
            if(right != null)
                alturaDer = right.getHeight(altura+1);
            if(alturaIzq > alturaDer)
                return alturaIzq;
            else
                return alturaDer;
        }
    }
    public ArrayList<Tree> getLongestBranch(){
        return getLongestBranch(new ArrayList<Tree>());
    }
    private ArrayList<Tree> getLongestBranch(ArrayList<Tree> aux) {
        if(left != null && right != null){
            if(left.getHeight() > right.getHeight()){
                aux.add(left);
                return left.getLongestBranch(aux);
            }else{
                aux.add(right);
                return right.getLongestBranch(aux);
            }
        }else if (left != null){
            aux.add(left);
            return left.getLongestBranch(aux);
        }else if (right != null){
            aux.add(right);
            return right.getLongestBranch(aux);
        }
        return aux;
    }
    public ArrayList<Tree> getFrontera(){
        return getFrontera(new ArrayList<Tree>());
    }
    private ArrayList<Tree> getFrontera(ArrayList<Tree> aux){
        if(left == null && right == null){
            aux.add(this);
        }else if(right != null && left != null){
            aux.addAll(left.getFrontera(aux));
            aux.addAll(right.getFrontera(aux));
        }else if(left != null){
            aux.addAll(left.getFrontera(aux));
        }else{
            aux.addAll(right.getFrontera(aux));
        }
        return aux;
    }
    // HECHO CON CHAT GPT SOLO DE PRUEBA
    public void printTree() {
        printSubTree("", true);
    }

    private void printSubTree(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + value);
        if (right != null) {
            right.printSubTree(prefix + (isTail ? "    " : "│   "), false);
        }
        if (left != null) {
            left.printSubTree(prefix + (isTail ? "    " : "│   "), isTail && right == null);
        }
    }
}
