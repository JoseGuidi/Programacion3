package Practico_2_1;

public class Ejercicio_4 {
    public static void main(String[] args) {

    }
    public static int setValueNodes(){
        Tree left = null, right = null;
        Integer value = 0;
        if(left == null && right == null){
            return value;
        }else{
            int aux = 0;
            if(right != null){
                aux = right.setValueNodes();
            }else{
                aux = 0;
            }
            if(left != null){
                value = aux - left.setValueNodes();
            }
            return value;
        }
    }
}
