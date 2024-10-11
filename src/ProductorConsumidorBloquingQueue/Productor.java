package ProductorConsumidorBloquingQueue;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Liz
 */
public class Productor implements Runnable {

    private BlockingQueue<Integer> cola;

    public Productor(BlockingQueue<Integer> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println("El productor produce: " + i);
            try {
                cola.put(i);
                Thread.sleep(40);
            } catch (InterruptedException ex) {

            }
        }
    }
}
