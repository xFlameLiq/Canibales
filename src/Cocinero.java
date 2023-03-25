
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cocinero extends Thread {

    private Buffer cocinero;
    private String nombre = "Cocinero";

    public Cocinero(Buffer intermedio) {
        this.cocinero = intermedio;
    }

    public void run() {
        Random aleatorio = new Random();
        while (true) {
            int comida = aleatorio.nextInt(15) + 1;
            cocinero.producir(comida);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }

        }
    }
}
