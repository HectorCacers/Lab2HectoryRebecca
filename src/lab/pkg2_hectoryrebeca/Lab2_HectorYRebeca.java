package lab.pkg2_hectoryrebeca;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab2_HectorYRebeca {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void printMatriz(char[][] matriz, ArrayList<Vehiculo> vehiculos) {
        int fila = matriz.length;
        int columna = matriz[0].length;
        int x = 0;
        int y = 0;
        for (int i = 0; i < fila; ++i) {
            for (int j = 0; j < columna; ++j) {
                System.out.print("|");
                if (matriz[i][j] != ' ') {
                    for (int k = 0; k < vehiculos.size(); ++k) {
                        x = vehiculos.get(k).getCoorx();
                        y = vehiculos.get(k).getCoory();
                        if (x == i && y == j) {
                            if (vehiculos.get(k).getColor() == "rojo") {
                                System.out.print(ANSI_RED + matriz[i][j] + ANSI_RESET);
                            } else {
                                System.out.print(ANSI_BLUE + matriz[i][j] + ANSI_RESET);
                            }
                        }
                    }
                } else {
                    System.out.print(matriz[i][j]);
                }
                //System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }
    }

    public static char[][] iniciarMatriz(char[][] matriz) {
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                matriz[i][j] = ' ';
            }
        }
        return matriz;
    }

    public static char[][] llenarMatriz(char[][] matriz, int n_jugadores, ArrayList<Vehiculo> vehiculos) {

        for (int i = 0; i < 10; ++i) {
            for (int j = 0; i < 10; ++i) {
                matriz[i][j] = ' ';
            }
            System.out.println("");
        }
        int x = 0;
        int y = 0;
        for (int i = 0; i < vehiculos.size(); ++i) {
            x = vehiculos.get(i).getCoorx();
            y = vehiculos.get(i).getCoory();
            //System.out.println("x"+x+ " y"+y); 
            if (vehiculos.get(i).getTipo() == 1) {
                matriz[x][y] = '*';
            }
            if (vehiculos.get(i).getTipo() == 2) {
                matriz[x][y] = '+';
            }
            if (vehiculos.get(i).getTipo() == 3) {
                matriz[x][y] = '-';
            }

        }
        return matriz;
    }

    public static char[][] actualizarEstado(char[][] matriz, int n_jugadores, ArrayList<Vehiculo> vehiculos) {
        char[][] tablero_temp = new char[10][10];
        tablero_temp = matriz;
        int x = 0;
        int y = 0;
        int k_temp = 0;
        int tipo = 0;
        String tipoColor = "";
        for (int i = 1; i < 9; ++i) {
            for (int j = 1; j < 9; ++j) {
                if (tablero_temp[i][j] != ' ') {
                    for (int k = 0; k < vehiculos.size(); ++k) {
                        x = vehiculos.get(k).getCoorx();
                        y = vehiculos.get(k).getCoory();
                        tipo = vehiculos.get(i).getTipo();
                        if (x == i && y == j) {
                            k_temp = k;
                        }
                    }
                    if (tablero_temp[i + 1][j] == ' ') {
                        matriz[i + 1][j] = tablero_temp[i][j];
                        matriz[i][j] = ' ';
                        vehiculos.get(k_temp).setCoorx(i + 1);
                        vehiculos.get(k_temp).setCoory(j);

                    } else if (tablero_temp[i - 1][j] == ' ') {
                        matriz[i - 1][j] = tablero_temp[i][j];
                        matriz[i][j] = ' ';
                        vehiculos.get(k_temp).setCoorx(i - 1);
                        vehiculos.get(k_temp).setCoory(j);

                    } else if (tablero_temp[i][j + 1] == ' ') {
                        matriz[i][j + 1] = tablero_temp[i][j];
                        matriz[i][j] = ' ';
                        vehiculos.get(k_temp).setCoorx(i);
                        vehiculos.get(k_temp).setCoory(j + 1);

                    } else if (tablero_temp[i][j - 1] == ' ') {
                        matriz[i][j - 1] = tablero_temp[i][j];
                        matriz[i][j] = ' ';
                        vehiculos.get(k_temp).setCoorx(i);
                        vehiculos.get(k_temp).setCoory(j - 1);

                    }

                }
            }

        }
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (tablero_temp[i][j] == '*') {
                    for (int k = 0; k < vehiculos.size(); ++k) {
                        x = vehiculos.get(k).getCoorx();
                        y = vehiculos.get(k).getCoory();
                        tipoColor = vehiculos.get(i).getColor();
                        if (tipoColor == "rojo") {
                            double distancia = Math.sqrt((x - i) * (x - i) + (y - j) * (y - j));
                        }

                    }
                    if (matriz[i][j] == 'a' || matriz[i][j] == 'b' || matriz[i][j] == 'c' || matriz[i][j] == 'd' || matriz[i][j] == 'e' || matriz[i][j] == 'f' || matriz[i][j] == 'g' || matriz[i][j] == 'h' || matriz[i][j] == 'i' || matriz[i][j] == 'j' || matriz[i][j] == 'k' || matriz[i][j] == 'l' || matriz[i][j] == 'm' || matriz[i][j] == 'n') {
                        System.out.println("Has derrivado un avion enemigo");
                        matriz[i][j] = ' ';
                    }

                }
            }

        }

        return matriz;
    }

    static Scanner lea = new Scanner(System.in);

    public static void main(String[] args) {
        int n_jugadores = 0;
        boolean menu = true;
        System.out.println("");
        System.out.println("-------------------------");
        System.out.println("Bienvenido a Azules contra rojos");
        System.out.println("Simbologia");
        System.out.println("	Barcos: *");
        System.out.println("	Aviones: +");
        System.out.println("	Submarinos: -");

        System.out.println("-------------------------");
        System.out.print("Ingrese la cantidad de Jugadores: ");
        n_jugadores = lea.nextInt();
        char[][] tablero = new char[10][10];
        tablero = iniciarMatriz(tablero);
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        if (n_jugadores < 11) {
            char[] caracter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n'};
            for (int i = 0; i < n_jugadores / 2; ++i) {
                Jugador jugador = new Jugador();
                jugador.setNombre("jugador" + i);
                jugador.setCaracter(caracter[i]);
                int unidad = (int) (Math.random() * 3 + 1);
                int x_randon = (int) (Math.random() * 10);
                int y_randon = (int) (Math.random() * 10);

                if (unidad == 1) {
                    Vehiculo vehiculo1 = new Avion("jugador" + i, x_randon, y_randon, jugador, "rojo");
                    vehiculos.add(vehiculo1);
                } else if (unidad == 2) {
                    if (y_randon % 2 == 0) {
                        y_randon = 0;
                    } else {
                        y_randon = 9;
                    }
                    Vehiculo vehiculo2 = new Barco("jugador" + i, x_randon, y_randon, jugador, "rojo");
                    vehiculos.add(vehiculo2);
                } else if (unidad == 3) {
                    if (y_randon % 2 == 0) {
                        y_randon = 1;
                    } else {
                        y_randon = 8;
                    }
                    Vehiculo vehiculo3 = new Submarino("jugador" + i, x_randon, y_randon, jugador, "rojo");
                    vehiculos.add(vehiculo3);
                }

            }
            for (int i = n_jugadores / 2; i < n_jugadores; ++i) {
                Jugador jugador = new Jugador();
                jugador.setNombre("jugador" + i);
                jugador.setCaracter(caracter[i]);
                int unidad = (int) (Math.random() * 3 + 1);
                int x_randon = (int) (Math.random() * 10);
                int y_randon = (int) (Math.random() * 10);

                if (unidad == 1) {
                    Vehiculo vehiculo1 = new Avion("jugador" + i, x_randon, y_randon, jugador, "azul");
                    vehiculos.add(vehiculo1);
                } else if (unidad == 2) {
                    if (y_randon % 2 == 0) {
                        y_randon = 0;
                    } else {
                        y_randon = 9;
                    }
                    Vehiculo vehiculo2 = new Barco("jugador" + i, x_randon, y_randon, jugador, "azul");
                    vehiculos.add(vehiculo2);
                } else if (unidad == 3) {
                    if (y_randon % 2 == 0) {
                        y_randon = 1;
                    } else {
                        y_randon = 8;
                    }
                    Vehiculo vehiculo3 = new Submarino("jugador" + i, x_randon, y_randon, jugador, "azul");
                    vehiculos.add(vehiculo3);
                }
            }
            tablero = llenarMatriz(tablero, n_jugadores, vehiculos);
        }
        int numero_turnos = n_jugadores * 5;
        int k = 0;
        int contador = 0;
        System.out.println("Los jugadores son: ");
        for (int i = 0; i < vehiculos.size(); ++i) {
            System.out.print(vehiculos.get(i).getNombre());
            System.out.println(" caracter: " + vehiculos.get(i).getNombre());
        }
        System.out.println(" Cada jugador cuenta con 0 victorias. Todos tienen 500 de vida");
        while (menu == true) {
            printMatriz(tablero, vehiculos);
            System.out.print("Cambiar estado.");
            k = lea.nextInt();
            try {
                tablero = actualizarEstado(tablero, n_jugadores, vehiculos);
            } catch (Exception e) {
                System.out.println("Hubo un error desconocido. Comuniquese con los desarrolladores");
            }

            numero_turnos++;
            if (contador == numero_turnos) {
                menu = true;
            }
        }

    }
}
