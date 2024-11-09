package Main;

import Controller.PlanDAO;
import Model.Plan;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import static JDBC.BDConnection.ConectarBD;
import static JDBC.BDConnection.DesconectarBD;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final PlanDAO planDAO = new PlanDAO();
    private static Connection BD = null;

    public static void main(String[] args){
        BD = ConectarBD();

        int opcion;
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

        scanner.close();
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

        Plan plan = new Plan(hora, dia, descripcion, 0);
        planDAO.actualizarPlan(plan);
        System.out.println("Plan actualizado exitosamente.");
    }

    private static void eliminarPlan() {
        System.out.print("Ingrese el Código del plan a eliminar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        planDAO.eliminarPlan(codigo);
        System.out.println("Plan eliminado exitosamente.");

        DesconectarBD(BD);
    }
}