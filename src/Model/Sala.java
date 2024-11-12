package Model;

import java.util.Scanner;
import Controller.SalaDAO;
import java.util.List;

public class Sala {

    private int nro_sala;
    private String ubicacion;
    private int capacidad;

    private static final Scanner scanner = new Scanner(System.in);
    private static final SalaDAO salaDAO = new SalaDAO();

    //Constructor
    public Sala(int nro_sala, String ubicacion, int capacidad) {
        this.nro_sala = nro_sala;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    //Getters y Setters
    public int getNro_sala() {
        return nro_sala;
    }

    public void setNro_sala(int nro_sala) {
        this.nro_sala = nro_sala;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    //Crud
    public static void insertarSala() {
        System.out.print("Ingrese la ubicación de la sala: ");
        String ubicacion = scanner.nextLine();

        System.out.print("Ingrese la capacidad de la sala: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();

        Sala sala = new Sala(0, ubicacion, capacidad);
        salaDAO.insertarSala(sala);
        System.out.println("Sala insertada exitosamente.");
    }

    public static void mostrarSalas() {
        List<Sala> salas = salaDAO.obtenerSalas();
        if (salas.isEmpty()) {
            System.out.println("No hay salas para mostrar.");
        } else {
            for (Sala sala : salas) {
                System.out.println("nro_sala: " + sala.getNro_sala() + " - Ubicación: " + sala.getUbicacion() + " - Capacidad: " + sala.getCapacidad());
            }
        }
    }

    public static void actualizarSala() {
        System.out.print("Ingrese el número de la sala a actualizar: ");
        int nroSala = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la nueva ubicación de la sala: ");
        String ubicacion = scanner.nextLine();

        System.out.print("Ingrese la nueva capacidad de la sala: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();

        Sala sala = new Sala(nroSala, ubicacion, capacidad);
        salaDAO.actualizarSala(sala);
        System.out.println("Sala actualizada exitosamente.");
    }

    public static void eliminarSala() {
        System.out.print("Ingrese el número de la sala a eliminar: ");
        int nroSala = scanner.nextInt();
        scanner.nextLine();

        salaDAO.eliminarSala(nroSala);
        System.out.println("Sala eliminada exitosamente.");
    }
}