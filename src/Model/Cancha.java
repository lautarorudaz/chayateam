package Model;

import Controller.CanchaDAO;

import java.util.List;
import java.util.Scanner;

public class Cancha {

    private int id;
    private String nombre;
    private double precioPorHora;

    private static final Scanner scanner = new Scanner(System.in);
    private static final CanchaDAO canchaDAO = new CanchaDAO();

    public Cancha(int id, String nombre, double precioPorHora) {
        this.id = id;
        this.nombre = nombre;
        this.precioPorHora = precioPorHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(double precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

    //Crud
    public static void crearCancha() {
        System.out.print("Nombre de la cancha: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio por hora: ");
        double precio = scanner.nextDouble();
        Cancha nuevaCancha = new Cancha(0, nombre, precio);
        CanchaDAO.crearCancha(nuevaCancha);

        System.out.println("Cancha creada exitosamente.");
    }

    public static void listarCancha() {
        List<Cancha> canchas = canchaDAO.listarCancha();
        if (canchas.isEmpty()) {
            System.out.println("No hay entrenadores para mostrar.");
        } else {
                for (Cancha cancha : canchas) {
                System.out.println("ID: " + cancha.getId() + " - Nombre: " + cancha.getNombre() + " - Precio por hora: " + cancha.getPrecioPorHora());
            }
        }
    }

    public static void actualizarCancha() {
        System.out.print("ID de la Cancha a actualizar: ");
        int idActualizar = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo Precio por hora: ");
        double precio = scanner.nextDouble();
        Cancha canchaActualizada = new Cancha(idActualizar, nombre, precio);
        canchaDAO.actualizarCancha(canchaActualizada);

        System.out.println("Cancha actualizada exitosamente.");
    }

    public static void eliminarCancha() {
        System.out.print("ID de la Cancha a eliminar: ");
        int idEliminar = scanner.nextInt();
        scanner.nextLine();
        canchaDAO.eliminarCancha(idEliminar);

        System.out.println("Cancha eliminada exitosamente.");
    }
}