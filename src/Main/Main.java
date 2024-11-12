package Main;

import java.sql.Connection;
import java.util.Scanner;
import static JDBC.BDConnection.ConectarBD;
import static JDBC.BDConnection.DesconectarBD;

public class Main {

    private static Connection bd = null;

    public static void main(String[] args){
        bd = ConectarBD();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione una entidad para trabajar:");
            System.out.println("1. Plan");
            System.out.println("2. Máquina");
            System.out.println("3. Socio");
            System.out.println("4. Entrenador");
            System.out.println("5. Sala");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    MenuPrincipal.crudPlan();
                    break;
                case 2:
                    MenuPrincipal.crudMaquina();
                    break;
                case 3:
                    MenuPrincipal.crudSocio();
                    break;
                case 4:
                    MenuPrincipal.crudEntrenador();
                    break;
                case 5:
                    MenuPrincipal.crudSala();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
        DesconectarBD(bd);
    }
}