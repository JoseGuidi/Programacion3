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

    public boolean hasElem(Integer elem) { //O(n)
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
    } //O(1)

    public void insert(Integer elem) { //O(log(n))
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

    public void printInOrder() { //O(n)
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
    public void printPosOrder(){//O(n)
        if(left != null)
            left.printPosOrder();
        if(right != null)
            right.printPosOrder();
        System.out.print(value + " ");
    }
    public void printPreOrder(){//O(n)
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
        ArrayList<Tree> aux = new ArrayList<Tree>();
        if(left != null && right != null){
            if(left.getHeight() > right.getHeight()){
                aux.add(left);
                aux.addAll(left.getLongestBranch());
            }else{
                aux.add(right);
                aux.addAll(right.getLongestBranch());
            }
        }else if(left != null){
            aux.add(left);
            aux.addAll(left.getLongestBranch());
        }else if(right != null){
            aux.add(right);
            aux.addAll(right.getLongestBranch());
        }
        return aux;
    }

    public ArrayList<Tree> getFrontera(){
        ArrayList<Tree> aux = new ArrayList<>();
        if(left == null && right == null){
            aux.add(this);
        }else{
            if(right != null){
                aux.addAll(right.getFrontera());
            }
            if(left != null){
                aux.addAll(left.getFrontera());
            }
        }
        return aux;
    }
    public Integer getMaxElem(){
        if(right != null)
            return right.getMaxElem();
        else
            return this.getRoot();
    }
    public ArrayList<Tree> getElemAtLevel(int level){
        return getElemAtLevel(level,0);
    }
    private ArrayList<Tree> getElemAtLevel( int level, int actualH){
        ArrayList<Tree> aux = new ArrayList<>();
        if(level > actualH){// tengo que avanzar de nivel
            if(left != null){
                aux.addAll(left.getElemAtLevel(level,actualH+1));
            }
            if(right != null){
                aux.addAll(right.getElemAtLevel(level,actualH+1));
            }
        }else if(level == actualH){ //agregar nodos
            aux.add(this);
        }
        return aux;
    }
    public int getSumOfIntern(){
        int suma = 0;
        if(left != null || right != null) {
            suma = value;
            if (left != null) {
                suma += left.getSumOfIntern();
            }
            if (right != null) {
                suma += right.getSumOfIntern();
            }
        }
        return suma;
    }
    public ArrayList<Tree> getLeavesBiggerThat(Integer k){
        ArrayList<Tree> aux = new ArrayList<>();
        if(left == null && right == null){ // son hojas
            if(value > k)
                aux.add(this);
        }else{ //tiene hijos
            if(value > k){  //si mi valor es mayor al que quiero encontrar
                            // puede ser que a la izquierda o derecha del nodo tmb
                            // sea mayores al k
                if(left != null)
                    aux.addAll(left.getLeavesBiggerThat(k));
                if(right != null)
                    aux.addAll(right.getLeavesBiggerThat(k));
            }else{  //seguir navegando para encontrar el mayor
                if(right != null)
                    aux.addAll(right.getLeavesBiggerThat(k));
            }
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

    public int setValueNodes() {
        return 0;
    }
}
