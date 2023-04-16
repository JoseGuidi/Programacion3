package Practico_2_1;

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
