
import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static int canibales = 0;

    public static void main(String[] args) {
        
        Buffer intermedio = new Buffer();
        Cocinero cocinero = new Cocinero(intermedio);
        Scanner input = new Scanner(System.in);
       do {
            System.out.println("Ingrese el numero de canibales");
            canibales = input.nextInt();
            if (canibales <= 0 || canibales > 15) {
                System.out.println("Error, rango no permitido");
            } else {

            }
        } while (canibales <= 0 || canibales > 15);
        Canibal canibal[] = new Canibal[canibales];
        cocinero.start();
        for(int i = 0; i < canibales; i++) {
            canibal[i] = new Canibal(intermedio);
        }
        for(int i = 0; i < canibales; i++) {
            canibal[i].start();
        }
        

    }
}
