
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SistemaVenta {

    private List<Localidad> localidades;

    public SistemaVenta() {
        localidades = new ArrayList<>();
        localidades.add(new Localidad("Localidad 1", 100));
        localidades.add(new Localidad("Localidad 2", 500));
        localidades.add(new Localidad("Localidad 3", 1000));
    }

    public void procesarCompra(Comprador comprador) {
        Ticket ticket = new Ticket();

        System.out.println("Número de Ticket generado:" + ticket.getNumeroTicket());

        if (!ticket.esValido()) {
            System.out.println("El ticket no es válido. " + comprador.getNombre() + " no fue seleccionado para la compra.");
            System.out.println("El numero random a es: " + ticket.getA());
            System.out.println("El numero random b es: " + ticket.getB());
            return;
        }

        Random random = new Random();
        Localidad localidad = localidades.get(random.nextInt(localidades.size()));
        System.out.println("Localidad seleccionada: " + localidad.getNombre());

        if (!localidad.presupuestoSuficiente(comprador.getPresupuestoMaximo())) {
            System.out.println("El presupuesto del comprador no es suficiente para comprar boletos en " + localidad.getNombre());
            return;
        }

        if (localidad.getDisponibles() == 0) {
            System.out.println("No hay boletos disponibles en " + localidad.getNombre());
            return;
        }

        int boletosVendidos = localidad.venderBoletos(comprador.getCantidadDeseada());
        System.out.println("Se vendieron " + boletosVendidos + " boletos a " + comprador.getNombre() + " en " + localidad.getNombre());
    }

    public void mostrarDisponibilidadTotal() {
        for (Localidad l : localidades) {
            System.out.println(l.getNombre() + ": " + l.getDisponibles() + " disponibles / " + l.getBoletosVendidos() + " vendidos");
        }
    }

    public void mostrarDisponibilidadIndividual(String nombre) {
        for (Localidad l : localidades) {
            if (l.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Disponibles en " + nombre + ": " + l.getDisponibles());
                return;
            }
        }
        System.out.println("No se encontró la localidad: " + nombre);
    }

    public void mostrarReporteCaja() {
        double total = 0;
        for (Localidad l : localidades) {
            System.out.println("Total generado en " + l.getNombre() + ": $" + l.totalGenerado());
            total += l.totalGenerado();
        }
        System.out.println("Total recaudado en caja: $" + total);
    }
}
