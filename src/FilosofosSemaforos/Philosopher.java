package FilosofosSemaforos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Liz
 */
public class Philosopher extends Thread {

    private Semaphore leftFork, rightFork;
    private int id;

    public Philosopher(int id, Semaphore leftFork, Semaphore rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                //Filósofo piensa
                System.out.println("Filosofo " + id + " esta pensando.");
                //Filósofo intenta adquirir el tenedor izquierdo
                leftFork.acquire();
                System.out.println("Filosofo " + id + " ha tomado el tenedor izquierdo.");
                //Filósofo intenta adquirir tendor derecho
                rightFork.acquire();
                System.out.println("Filosofo " + id + " ha tomado el tenedor derecho");
                //Filósofo come
                System.out.println("Filosofo " + id + " esta comiendo");
                //Filósofo suelta el tenedor izquierdo
                leftFork.release();
                System.out.println("Filosofo " + id + " ha soltado el tenedor izquierdo");
                //Filósofo suelta el tenedor derecho
                rightFork.release();
                System.out.println("Filosofo " + id + " ha soltado el tenedor derecho");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
