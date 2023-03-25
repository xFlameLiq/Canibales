
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Buffer {

    private int buffer = 0;
    private boolean estaVacia = true;
    private boolean estaLlena = false;

    public Buffer() {

    }
    
    public void finalizado() {
        if(this.estaVacia){
            System.out.println("LOS CANIBALES HAN TERMINADO DE COMER");
        }
    }

    public synchronized int consumir() {
        while (this.estaVacia) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        this.buffer = this.buffer - 1;
        if (this.buffer <= 0) {
            this.estaVacia = true;
            this.estaLlena = false;
            notifyAll();
        }
        return buffer;
    }

    public synchronized void producir(int preparando) {
        while (this.estaLlena) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        for (int i = 1; i <= preparando; i++) {
            this.buffer++;
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            System.out.println("Cocinero preparando comida: " + this.buffer);
            if (this.buffer == preparando) {
                this.estaLlena = true;
            }
        }
        System.out.println("COMIDA LISTA");
        this.estaVacia = false;
        notifyAll();
    }

    public int getBuffer() {
        return this.buffer;
    }

}
