
import java.util.Random;

public class Ticket {

    private int numeroTicket;
    private int a;
    private int b;

    // Constructor para inicializar los atributos
    public Ticket() {
        Random random = new Random();
        this.numeroTicket = random.nextInt(9) + 1;
        do {
            this.a = random.nextInt(9) + 1;
            this.b = random.nextInt(9) + 1;
        } while (this.a >= this.b);
    }

    public boolean esValido() {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return numeroTicket >= min && numeroTicket <= max;
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
