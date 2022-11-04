package lab.pkg2_hectoryrebeca;

public class Barco extends Vehiculo {

    public Barco(String nombre, int x, int y, Jugador jugador, String color) {
        super(nombre, x, y, jugador, color, 2);
    }

    public void mover() {
        System.out.println("Es el turno del Barco moverse");
    }
}
