package Model;

import java.util.Scanner;
import Controller.EntrenadorDAO;
import java.util.List;

public class Entrenador {

    private int id;
    private String nombre;
    private String apellido;
    private long telefono;

    private static final Scanner scanner = new Scanner(System.in);
    private static final EntrenadorDAO entrenadorDAO = new EntrenadorDAO();

    //Constructor
    public Entrenador(int id, String nombre, String apellido, long telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    //Getters y Setters
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

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //Crud
    public static void insertarEntrenador() {
        System.out.print("Ingrese el nombre del entrenador: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del entrenador: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese el teléfono del entrenador: ");
        long telefono = scanner.nextLong();
        scanner.nextLine();

        Entrenador entrenador = new Entrenador(0, nombre, apellido, telefono);
        entrenadorDAO.insertarEntrenador(entrenador);
        System.out.println("Entrenador insertado exitosamente.");
    }

    public static void mostrarEntrenadores() {
        List<Entrenador> entrenadores = entrenadorDAO.obtenerEntrenadores();
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores para mostrar.");
        } else {
            for (Entrenador entrenador : entrenadores) {
                System.out.println("ID: " + entrenador.getId() + " - Nombre: " + entrenador.getNombre() + " - Apellido: " + entrenador.getApellido() + " - Teléfono: " + entrenador.getTelefono());
            }
        }
    }

    public static void actualizarEntrenador() {
        System.out.print("Ingrese el ID del entrenador a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre del entrenador: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del entrenador: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese el teléfono del entrenador: ");
        long telefono = scanner.nextLong();
        scanner.nextLine();

        Entrenador entrenador = new Entrenador(id, nombre, apellido, telefono);
        entrenadorDAO.actualizarEntrenador(entrenador);
        System.out.println("Entrenador actualizado exitosamente.");
    }

    public static void eliminarEntrenador() {
        System.out.print("Ingrese el ID del entrenador a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        entrenadorDAO.eliminarEntrenador(id);
        System.out.println("Entrenador eliminado exitosamente.");
    }
}