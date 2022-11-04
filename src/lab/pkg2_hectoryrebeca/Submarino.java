package lab.pkg2_hectoryrebeca;

public class Submarino extends Vehiculo {

    public Submarino(String nombre, int x, int y, Jugador jugador, String color) {
        super(nombre, x, y, jugador, color, 3);
    }

    public void mover() {
        System.out.println("Es el turno del submarino moverse");
    }
}
