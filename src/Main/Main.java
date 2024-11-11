package Main;

import Controller.*;
import Model.*;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import static JDBC.BDConnection.ConectarBD;
import static JDBC.BDConnection.DesconectarBD;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final PlanDAO planDAO = new PlanDAO();
    private static final EntrenadorDAO entrenadorDAO = new EntrenadorDAO();
    private static final SocioDAO socioDAO = new SocioDAO();
    private static final SalaDAO salaDAO = new SalaDAO();
    private static final MaquinaDAO maquinaDAO = new MaquinaDAO();
    private static Connection BD = null;

    public static void main(String[] args){
        BD = ConectarBD();

        int opcion;

        do {
            System.out.println("Seleccione una operación:");
            System.out.println("1. Insertar una nueva sala");
            System.out.println("2. Mostrar todas las salas");
            System.out.println("3. Actualizar una sala");
            System.out.println("4. Eliminar una sala");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    insertarSala();
                    break;
                case 2:
                    mostrarSalas();
                    break;
                case 3:
                    actualizarSala();
                    break;
                case 4:
                    eliminarSala();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        do {
            System.out.println("Seleccione una operación:");
            System.out.println("1. Insertar un nuevo plan");
            System.out.println("2. Mostrar todos los planes");
            System.out.println("3. Actualizar un plan");
            System.out.println("4. Eliminar un plan");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    insertarPlan();
                    break;
                case 2:
                    mostrarPlanes();
                    break;
                case 3:
                    actualizarPlan();
                    break;
                case 4:
                    eliminarPlan();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        do {
            System.out.println("Seleccione una operación:");
            System.out.println("1. Insertar un nuevo entrenador");
            System.out.println("2. Mostrar todos los entrenadores");
            System.out.println("3. Actualizar un entrenador");
            System.out.println("4. Eliminar un entrenador");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    insertarEntrenador();
                    break;
                case 2:
                    mostrarEntrenadores();
                    break;
                case 3:
                    actualizarEntrenador();
                    break;
                case 4:
                    eliminarEntrenador();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        do {
            System.out.println("Seleccione una operación:");
            System.out.println("1. Insertar un nuevo socio");
            System.out.println("2. Mostrar todos los socios");
            System.out.println("3. Actualizar un socio");
            System.out.println("4. Eliminar un socio");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    insertarSocio();
                    break;
                case 2:
                    mostrarSocios();
                    break;
                case 3:
                    actualizarSocio();
                    break;
                case 4:
                    eliminarSocio();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
        DesconectarBD(BD);
    }

    static void insertarMaquina() {
        System.out.print("Ingrese la marca de la máquina: ");
        String marca = scanner.nextLine();

        System.out.print("Ingrese el modelo de la máquina: ");
        String modelo = scanner.nextLine();

        System.out.print("Ingrese el número de sala (referencia a Sala): ");
        int nroSala = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        Maquina maquina = new Maquina(0, marca, modelo, nroSala);
        maquinaDAO.insertarMaquina(maquina);
        System.out.println("Máquina insertada exitosamente.");
    }

    private static void mostrarMaquinas() {
        List<Maquina> maquinas = maquinaDAO.obtenerMaquinas();
        if (maquinas.isEmpty()) {
            System.out.println("No hay máquinas disponibles.");
        } else {
            for (Maquina maquina : maquinas) {
                System.out.println("Código Máquina: " + maquina.getCodigoMaquina() +
                        " - Marca: " + maquina.getMarca() +
                        " - Modelo: " + maquina.getModelo() +
                        " - Nro Sala: " + maquina.getNroSala());
            }
        }
    }

    private static void actualizarMaquina() {
        System.out.print("Ingrese el código de la máquina a actualizar: ");
        int codigoMaquina = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        System.out.print("Ingrese la nueva marca de la máquina: ");
        String marca = scanner.nextLine();

        System.out.print("Ingrese el nuevo modelo de la máquina: ");
        String modelo = scanner.nextLine();

        System.out.print("Ingrese el número de sala (referencia a Sala): ");
        int nroSala = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        Maquina maquina = new Maquina(codigoMaquina, marca, modelo, nroSala);
        maquinaDAO.actualizarMaquina(maquina);
        System.out.println("Máquina actualizada exitosamente.");
    }

    private static void eliminarMaquina() {
        System.out.print("Ingrese el código de la máquina a eliminar: ");
        int codigoMaquina = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        maquinaDAO.eliminarMaquina(codigoMaquina);
        System.out.println("Máquina eliminada exitosamente.");
    }

    private static void insertarSala() {
        System.out.print("Ingrese la ubicación de la sala: ");
        String ubicacion = scanner.nextLine();

        System.out.print("Ingrese la capacidad de la sala: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        Sala sala = new Sala(0, ubicacion, capacidad);
        salaDAO.insertarSala(sala);
        System.out.println("Sala insertada exitosamente.");
    }

    private static void mostrarSalas() {
        List<Sala> salas = salaDAO.obtenerSalas();
        if (salas.isEmpty()) {
            System.out.println("No hay salas disponibles.");
        } else {
            for (Sala sala : salas) {
                System.out.println("Nro Sala: " + sala.getNro_sala() + " - Ubicación: " + sala.getUbicacion() + " - Capacidad: " + sala.getCapacidad());
            }
        }
    }

    private static void actualizarSala() {
        System.out.print("Ingrese el número de sala a actualizar: ");
        int nroSala = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        System.out.print("Ingrese la nueva ubicación de la sala: ");
        String ubicacion = scanner.nextLine();

        System.out.print("Ingrese la nueva capacidad de la sala: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        Sala sala = new Sala(nroSala, ubicacion, capacidad);
        salaDAO.actualizarSala(sala);
        System.out.println("Sala actualizada exitosamente.");
    }

    private static void eliminarSala() {
        System.out.print("Ingrese el número de sala a eliminar: ");
        int nroSala = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        salaDAO.eliminarSala(nroSala);
        System.out.println("Sala eliminada exitosamente.");
    }

    private static void insertarSocio() {
        System.out.print("Ingrese el nombre del socio: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del socio: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la dirección del socio: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese el teléfono del socio: ");
        long telefono = scanner.nextLong();
        scanner.nextLine(); // Consumir la nueva línea

        Socio socio = new Socio(0, nombre, apellido, direccion, telefono); // La id será generada automáticamente
        socioDAO.insertarSocio(socio);
        System.out.println("Socio insertado exitosamente.");
    }

    private static void mostrarSocios() {
        List<Socio> socios = socioDAO.obtenerSocios();
        if (socios.isEmpty()) {
            System.out.println("No hay socios disponibles.");
        } else {
            for (Socio socio : socios) {
                System.out.println(socio.getNumSocio() + " - " + socio.getNombre() + " - " + socio.getApellido() + " - " + socio.getDireccion() + " - " + socio.getTelefono());
            }
        }
    }

    private static void actualizarSocio() {
        System.out.print("Ingrese el número de socio a actualizar: ");
        int numSocio = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        System.out.print("Ingrese el nuevo nombre del socio: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el nuevo apellido del socio: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la nueva dirección del socio: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese el nuevo teléfono del socio: ");
        long telefono = scanner.nextLong();
        scanner.nextLine(); // Consumir la nueva línea

        Socio socio = new Socio(numSocio, nombre, apellido, direccion, telefono);
        socioDAO.actualizarSocio(socio);
        System.out.println("Socio actualizado exitosamente.");
    }

    private static void eliminarSocio() {
        System.out.print("Ingrese el número de socio a eliminar: ");
        int numSocio = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        socioDAO.eliminarSocio(numSocio);
        System.out.println("Socio eliminado exitosamente.");
    }

    private static void insertarPlan() {
        System.out.print("Ingrese la Hora (formato HH:MM): ");
        String hora = scanner.nextLine();

        System.out.print("Ingrese el Día: ");
        String dia = scanner.nextLine();

        System.out.print("Ingrese la Descripción: ");
        String descripcion = scanner.nextLine();

        Plan plan = new Plan(hora, dia, descripcion, 0);
        planDAO.insertarPlan(plan);
        System.out.println("Plan insertado exitosamente.");
    }

    private static void mostrarPlanes() {
        List<Plan> planes = planDAO.obtenerPlanes();
        if (planes.isEmpty()) {
            System.out.println("No hay planes disponibles.");
        } else {
            for (Plan plan : planes) {
                System.out.println(plan.getHora() + " - " + plan.getDia() + " - " + plan.getDescripcion() + " - " + plan.getCodigo());
            }
        }
    }

    private static void actualizarPlan() {
        System.out.print("Ingrese el Código del plan a actualizar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        System.out.print("Ingrese la nueva Hora (formato HH:MM): ");
        String hora = scanner.nextLine();

        System.out.print("Ingrese el nuevo Día: ");
        String dia = scanner.nextLine();

        System.out.print("Ingrese la nueva Descripción: ");
        String descripcion = scanner.nextLine();

        Plan plan = new Plan(hora, dia, descripcion, codigo);
        planDAO.actualizarPlan(plan);
        System.out.println("Plan actualizado exitosamente.");
    }

    private static void eliminarPlan() {
        System.out.print("Ingrese el Código del plan a eliminar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        planDAO.eliminarPlan(codigo);
        System.out.println("Plan eliminado exitosamente.");
    }

        private static void insertarEntrenador() {
            System.out.print("Ingrese el nombre del entrenador: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el apellido del entrenador: ");
            String apellido = scanner.nextLine();

            System.out.print("Ingrese el telefono del entrenador: ");
            long telefono = scanner.nextLong();

            Entrenador entrenador = new Entrenador(nombre, apellido, telefono);
            entrenadorDAO.insertarEntrenador(entrenador);
            System.out.println("Entrenador insertado exitosamente.");
        }

        private static void mostrarEntrenadores() {
            List<Entrenador> entrenadores = entrenadorDAO.obtenerEntrenadores();
            if (entrenadores.isEmpty()) {
                System.out.println("No hay entrenadores disponibles.");
            } else {
                for (Entrenador entrenador : entrenadores) {
                    System.out.println(entrenador.getId() + " - " + entrenador.getNombre() + " - " + entrenador.getApellido() + " - " + entrenador.getTelefono());
                }
            }
        }

        private static void actualizarEntrenador() {
            System.out.print("Ingrese el ID del entrenador a actualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            System.out.print("Ingrese el nuevo nombre del entrenador: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el nuevo apellido del entrenador: ");
            String apellido = scanner.nextLine();

            System.out.print("Ingrese el nuevo teléf5ono del entrenador: ");
            long telefono = scanner.nextLong();

            Entrenador entrenador = new Entrenador(id, nombre, apellido, telefono);
            entrenadorDAO.actualizarEntrenador(entrenador);
            System.out.println("Entrenador actualizado exitosamente.");
        }

        private static void eliminarEntrenador() {
            System.out.print("Ingrese el ID del entrenador a eliminar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            entrenadorDAO.eliminarEntrenador(id);
            System.out.println("Entrenador eliminado exitosamente.");

    }
}