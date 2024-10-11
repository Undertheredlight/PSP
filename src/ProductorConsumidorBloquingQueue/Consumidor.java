package ProductorConsumidorBloquingQueue;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Liz
 */
public class Consumidor implements Runnable {

    private BlockingQueue<Integer> cola;

    public Consumidor(BlockingQueue<Integer> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                System.out.println("El consumidor consume: " + cola.take());
                Thread.sleep(100);
            } catch (InterruptedException ex) {

            }
        }
    }

}
