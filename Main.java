
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaVenta sistema = new SistemaVenta();
        Comprador compradorActual = null;

        int opcion;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Cantidad de boletos: ");
                    int cantidad = sc.nextInt();
                    System.out.print("Presupuesto máximo: ");
                    double presupuesto = sc.nextDouble();
                    compradorActual = new Comprador(nombre, email, cantidad, presupuesto);
                    break;

                case 2:
                    if (compradorActual == null) {
                        System.out.println("Debe crear un comprador primero.");
                    } else {
                        sistema.procesarCompra(compradorActual);
                    }
                    break;
                case 3:
                    sistema.mostrarDisponibilidadTotal();
                    break;
                case 4:
                    System.out.println("Ingrese nombre de la localidad (ej. Localidad 1): ");
                    String nombreLocalidad = sc.nextLine();
                    sistema.mostrarDisponibilidadIndividual(nombreLocalidad);
                    break;
                case 5:
                    sistema.mostrarReporteCaja();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 6);

        sc.close();
    }
}
