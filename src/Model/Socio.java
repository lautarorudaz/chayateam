package Model;

import java.util.Scanner;
import Controller.SocioDAO;
import java.util.List;

public class Socio {

    private int num_socio;
    private String nombre;
    private String apellido;
    private String direccion;
    private long telefono;

    private static final Scanner scanner = new Scanner(System.in);
    private static final SocioDAO socioDAO = new SocioDAO();

    //Constructor
    public Socio(int num_socio, String nombre, String apellido, String direccion, long telefono) {
        this.num_socio = num_socio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    //Getters y Setters
    public int getNum_socio() {
        return num_socio;
    }

    public void setNum_socio(int num_socio) {
        this.num_socio = num_socio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    //Crud
    public static void insertarSocio() {
        System.out.print("Ingrese el nombre del socio: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del socio: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la dirección del socio: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese el teléfono del socio: ");
        long telefono = scanner.nextLong();
        scanner.nextLine();

        Socio socio = new Socio(0, nombre, apellido, direccion, telefono);
        socioDAO.insertarSocio(socio);
        System.out.println("Socio insertado exitosamente.");
    }

    public static void mostrarSocios() {
        List<Socio> socios = socioDAO.obtenerSocios();
        if (socios.isEmpty()) {
            System.out.println("No hay socios para mostrar.");
        } else {
            for (Socio socio : socios) {
                System.out.println("num_socio: " + socio.getNum_socio() + " - Nombre: " + socio.getNombre() + " - Apellido: " + socio.getApellido() + " - Dirección: " + socio.getDireccion() + " - Teléfono: " + socio.getTelefono());
            }
        }
    }

    public static void actualizarSocio() {
        System.out.print("Ingrese el número del socio a actualizar: ");
        int num_socio = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre del socio: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del socio: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la dirección del socio: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese el teléfono del socio: ");
        long telefono = scanner.nextLong();
        scanner.nextLine();

        Socio socio = new Socio(num_socio, nombre, apellido, direccion, telefono);
        socioDAO.actualizarSocio(socio);
        System.out.println("Socio actualizado exitosamente.");
    }

    public static void eliminarSocio() {
        System.out.print("Ingrese el número del socio a eliminar: ");
        int num_socio = scanner.nextInt();
        scanner.nextLine();

        socioDAO.eliminarSocio(num_socio);
        System.out.println("Socio eliminado exitosamente.");
    }
}