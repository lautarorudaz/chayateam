package Main;

import java.sql.Connection;
import java.util.InputMismatchException;
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
            System.out.println("1. Entrenador");
            System.out.println("2. Máquina");
            System.out.println("3. Plan");
            System.out.println("4. Sala");
            System.out.println("5. Socio");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine();
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    MenuPrincipal.crudEntrenador();
                    break;
                case 2:
                    MenuPrincipal.crudMaquina();
                    break;
                case 3:
                    MenuPrincipal.crudPlan();
                    break;
                case 4:
                    MenuPrincipal.crudSala();
                    break;
                case 5:
                    MenuPrincipal.crudSocio();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    if (opcion != -1) {
                        System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
                    }
            }
        } while (opcion != 6);

        scanner.close();
        DesconectarBD(bd);
    }
}