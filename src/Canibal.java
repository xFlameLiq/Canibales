
import java.util.logging.Level;
import java.util.logging.Logger;

public class Canibal extends Thread {
    
    private Buffer canibal;
    private String nombre = "Canibal";
    
        public Canibal (Buffer intermedio) {
        this.canibal = intermedio;
    }
   
    
    public void run(){
        while(true) {
            int consumo = canibal.consumir();
            consumo = consumo+1;
            System.out.println("Canibal (" +this.getName()+")"+" está consumiendo: " + consumo);
            canibal.finalizado();
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

}
