package Model;

import java.util.Scanner;
import Controller.PlanDAO;
import java.util.List;

public class Plan {

    private int codigo_plan;
    private String hora;
    private String dia;
    private String descripcion;

    private static final Scanner scanner = new Scanner(System.in);
    private static final PlanDAO planDAO = new PlanDAO();

    //Constructor
    public Plan(int codigo_plan, String hora, String dia, String descripcion) {
        this.hora = hora;
        this.dia = dia;
        this.descripcion = descripcion;
        this.codigo_plan = codigo_plan;
    }

    //Getters y Setters
    public int getCodigo_plan() {
        return codigo_plan;
    }

    public void setCodigo_plan(int codigo_plan) {
        this.codigo_plan = codigo_plan;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //Crud
    public static void insertarPlan() {
        System.out.print("Ingrese la hora (formato HH:MM): ");
        String hora = scanner.nextLine();

        System.out.print("Ingrese el día: ");
        String dia = scanner.nextLine();

        System.out.print("Ingrese la descripción: ");
        String descripcion = scanner.nextLine();

        Plan plan = new Plan(0, hora, dia, descripcion);
        planDAO.insertarPlan(plan);
        System.out.println("Plan insertado exitosamente.");
    }

    public static void mostrarPlanes() {
        List<Plan> planes = planDAO.obtenerPlanes();
        if (planes.isEmpty()) {
            System.out.println("No hay planes para mostrar.");
        } else {
            for (Plan plan : planes) {
                System.out.println("código_plan: " + plan.getCodigo_plan() + " - Hora: " + plan.getHora() + " - Día: " + plan.getDia() + " - Descripción: " + plan.getDescripcion());
            }
        }
    }

    public static void actualizarPlan() {
        System.out.print("Ingrese el código del plan a actualizar: ");
        int codigo_plan = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la hora (formato HH:MM): ");
        String hora = scanner.nextLine();

        System.out.print("Ingrese el día: ");
        String dia = scanner.nextLine();

        System.out.print("Ingrese la descripción: ");
        String descripcion = scanner.nextLine();

        Plan plan = new Plan(codigo_plan, hora, dia, descripcion);
        planDAO.actualizarPlan(plan);
        System.out.println("Plan actualizado exitosamente.");
    }

    public static void eliminarPlan() {
        System.out.print("Ingrese el código del plan a eliminar: ");
        int codigo_plan = scanner.nextInt();
        scanner.nextLine();

        planDAO.eliminarPlan(codigo_plan);
        System.out.println("Plan eliminado exitosamente.");
    }
}