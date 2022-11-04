package lab.pkg2_hectoryrebeca;

public class Vehiculo {

    private String nombre;
    private int danio = 250;
    private int coorx;
    private int coory;
    private int vida = 500;
    private Jugador conductor;
    private String color;
    private int tipo;

    public Vehiculo(String nombre, int x, int y, Jugador jugador, String color, int tipo) {
        this.nombre = nombre;
        this.coorx = x;
        this.coory = y;
        this.conductor = jugador;
        this.color = color;
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getCoorx() {
        return coorx;
    }

    public void setCoorx(int coorx) {
        this.coorx = coorx;
    }

    public int getCoory() {
        return coory;
    }

    public void setCoory(int coory) {
        this.coory = coory;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Jugador getConductor() {
        return conductor;
    }

    public void setConductor(Jugador conductor) {
        this.conductor = conductor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void mover() {

    }

}
