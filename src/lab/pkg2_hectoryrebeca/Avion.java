package lab.pkg2_hectoryrebeca;

public class Avion extends Vehiculo {

    public Avion(String nombre, int x, int y, Jugador jugador, String color) {
        super(nombre, x, y, jugador, color, 1);

    }

    public void mover() {
        System.out.println("Es el turno del Avion moverse");
    }

}
