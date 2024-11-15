package Main;

import java.util.Scanner;
import static Model.Cancha.*;
//import static Model.Entrenador.*;
//import static Model.Maquina.*;
import static Model.Plan.*;
import static Model.Sala.*;
import static Model.Socio.*;

public class MenuPrincipal {

    private static final Scanner scanner = new Scanner(System.in);

    public static void crudCancha() {
        int opcion;
        do {
            System.out.println("Indique la operación que desea realizar:");
            System.out.println("1. Insertar una nueva máquina");
            System.out.println("2. Mostrar todas las máquinas");
            System.out.println("3. Actualizar una máquina");
            System.out.println("4. Eliminar una máquina");
            System.out.println("5. Volver al menú principal");
            System.out.print("Opción N°: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearCancha();
                    break;
                case 2:
                    listarCancha();
                    break;
                case 3:
                    actualizarCancha();
                    break;
                case 4:
                    eliminarCancha();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
            }
        } while (opcion != 5);
    }

    public static void crudPlan() {
        int opcion;
        do {
            System.out.println("Indique la operación que desea realizar:");
            System.out.println("1. Insertar un nuevo plan");
            System.out.println("2. Mostrar todos los planes");
            System.out.println("3. Actualizar un plan");
            System.out.println("4. Eliminar un plan");
            System.out.println("5. Volver al menú principal");
            System.out.print("Opción N°: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

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
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
            }
        } while (opcion != 5);
    }

    public static void crudSala() {
        int opcion;
        do {
            System.out.println("Indique la operación que desea realizar:");
            System.out.println("1. Insertar una nueva sala");
            System.out.println("2. Mostrar todas las salas");
            System.out.println("3. Actualizar una sala");
            System.out.println("4. Eliminar una sala");
            System.out.println("5. Volver al menú principal");
            System.out.print("Opción N°: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

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
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
            }
        } while (opcion != 5);
    }

    public static void crudSocio() {
        int opcion;
        do {
            System.out.println("Indique la operación que desea realizar:");
            System.out.println("1. Insertar un nuevo socio");
            System.out.println("2. Mostrar todos los socios");
            System.out.println("3. Actualizar un socio");
            System.out.println("4. Eliminar un socio");
            System.out.println("5. Volver al menú principal");
            System.out.print("Opción N°: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

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
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }
}