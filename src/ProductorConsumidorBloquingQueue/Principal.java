package ProductorConsumidorBloquingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Liz
 */
public class Principal {
    public static void main(String[] args) {
        BlockingQueue <Integer> colaCompartida = new ArrayBlockingQueue<Integer>(3);
        
        Thread p = new Thread (new Productor(colaCompartida));
        Thread c = new Thread (new Consumidor(colaCompartida));
        p.start();
        c.start();
    }
}
