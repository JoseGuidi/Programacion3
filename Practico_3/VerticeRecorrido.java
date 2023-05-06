package Practico_3;

public class VerticeRecorrido {
    private String color;
    private int tDescubrimiento, tFinal;

    public VerticeRecorrido() {
        color = "BLANCO";
        tDescubrimiento = 0;
        tFinal = 0;
    }

    public String getColor() {
        return color;
    }

    public int gettDescubrimiento() {
        return tDescubrimiento;
    }

    public int gettFinal() {
        return tFinal;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void settDescubrimiento(int tDescubrimiento) {
        this.tDescubrimiento = tDescubrimiento;
    }

    public void settFinal(int tFinal) {
        this.tFinal = tFinal;
    }
}
