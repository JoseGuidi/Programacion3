package Practico_4;

public class Casillero {
    private int valor;
    private boolean norte,este,sur,oeste;

    public Casillero(int valor, boolean norte, boolean este, boolean sur, boolean oeste) {
        this.valor = valor;
        this.norte = norte;
        this.este = este;
        this.sur = sur;
        this.oeste = oeste;
    }

    public int getValor() {
        return valor;
    }

    public boolean getNorte() {
        return norte;
    }

    public boolean getEste() {
        return este;
    }

    public boolean getSur() {
        return sur;
    }

    public boolean getOeste() {
        return oeste;
    }
    public boolean equals(Object otro){
        Casillero c = (Casillero) otro;
        return c.getValor() == valor;
    }
}
