
import java.util.Random;

public class Ticket {

    private int numeroTicket;
    private int a;
    private int b;

    // Constructor para inicializar los atributos
    public Ticket() {
        Random random = new Random();
        this.numeroTicket = random.nextInt(1500) + 1;
        this.a = random.nextInt(100) + 1;
        this.b = random.nextInt(100) + 1;
    }

    public boolean esValido() {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return numeroTicket >= min && numeroTicket <= max;
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }
}
