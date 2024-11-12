package Model;

import java.util.Scanner;
import Controller.MaquinaDAO;
import java.util.List;

public class Maquina {

    private int codigo_maquina;
    private String marca;
    private String modelo;
    private int nro_sala; //Clave foránea que hace referencia a la sala a la que está asociada la máquina

    private static final Scanner scanner = new Scanner(System.in);
    private static final MaquinaDAO maquinaDAO = new MaquinaDAO();

    public Maquina(int codigo_maquina, String marca, String modelo, int nro_sala) {
        this.codigo_maquina = codigo_maquina;
        this.marca = marca;
        this.modelo = modelo;
        this.nro_sala = nro_sala;
    }

    //Getters y Setters
    public int getCodigoMaquina() {
        return codigo_maquina;
    }

    public void setCodigoMaquina(int codigo_maquina) {
        this.codigo_maquina = codigo_maquina;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNroSala() {
        return nro_sala;
    }

    public void setNroSala(int nro_sala) {
        this.nro_sala = nro_sala;
    }

    //Crud
    public static void insertarMaquina() {
        System.out.print("Ingrese la marca de la máquina: ");
        String marca = scanner.nextLine();

        System.out.print("Ingrese el modelo de la máquina: ");
        String modelo = scanner.nextLine();

        System.out.print("Ingrese el número de la sala a la que corresponde: ");
        int nro_sala = scanner.nextInt();
        scanner.nextLine();

        Maquina maquina = new Maquina(0, marca, modelo, nro_sala);
        maquinaDAO.insertarMaquina(maquina);
        System.out.println("Máquina insertada exitosamente.");
    }

    public static void mostrarMaquinas() {
        List<Maquina> maquinas = maquinaDAO.obtenerMaquinas();
        if (maquinas.isEmpty()) {
            System.out.println("No hay máquinas para mostrar.");
        } else {
            for (Maquina maquina : maquinas) {
                System.out.println("código_máquina: " + maquina.getCodigoMaquina() + " - Marca: " + maquina.getMarca() + " - Modelo: " + maquina.getModelo() + " - nro_sala: " + maquina.getNroSala());
            }
        }
    }

    public static void actualizarMaquina() {
        System.out.print("Ingrese el código de la máquina a actualizar: ");
        int codigo_maquina = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la marca de la máquina: ");
        String marca = scanner.nextLine();

        System.out.print("Ingrese el modelo de la máquina: ");
        String modelo = scanner.nextLine();

        System.out.print("Ingrese el número de la sala a la que corresponde: ");
        int nro_sala = scanner.nextInt();
        scanner.nextLine();

        Maquina maquina = new Maquina(codigo_maquina, marca, modelo, nro_sala);
        maquinaDAO.actualizarMaquina(maquina);
        System.out.println("Máquina actualizada exitosamente.");
    }

    public static void eliminarMaquina() {
        System.out.print("Ingrese el código de la máquina a eliminar: ");
        int codigo_maquina = scanner.nextInt();
        scanner.nextLine();

        maquinaDAO.eliminarMaquina(codigo_maquina);
        System.out.println("Máquina eliminada exitosamente.");
    }
}