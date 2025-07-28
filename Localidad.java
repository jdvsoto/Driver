
public class Localidad {

    private String nombre;
    private double precio;
    private int capacidadMaxima;
    private int boletosVendidos;

    // Constructor para inicializar los atributos
    public Localidad(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.capacidadMaxima = 20;
        this.boletosVendidos = 0;
    }

    // Getters para los atributos
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }
    public int getDisponibles() {
        return capacidadMaxima - boletosVendidos;
    }

    public boolean tieneEspacioPara(int cantidad) {
        return cantidad <= getDisponibles();
    }

    public boolean presupuestoSuficiente(double presupuesto) {
        return precio <= presupuesto;
    }

    public int venderBoletos(int cantidadDeseada){
        int vendidos = Math.min(cantidadDeseada, getDisponibles());
        boletosVendidos += vendidos;
        return vendidos;
    }

    public double totalGenerado() {
        return boletosVendidos * precio;
    }
}
