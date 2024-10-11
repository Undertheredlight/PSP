
package FilosofosSemaforos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Liz
 */
public class Principal {
    public static void main(String[] args) {
        
        final int numPhilosophers = 5;
        Semaphore[] forks = new Semaphore[numPhilosophers];
        Philosopher[] philosophers = new Philosopher [numPhilosophers];
        //Inicializar los tenedores
        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new Semaphore(1);
        }
        //Crear e iniciar los filósofos
        for (int i = 0; i < numPhilosophers; i++) {
            Semaphore leftFork = forks[i];
            Semaphore rightFork = forks[(i+1)% numPhilosophers];
            //El tenedor derecho es el siguiente tenedor
            philosophers[i] = new Philosopher(i,leftFork,rightFork);
            philosophers[i].start();
        }
                
    }
}
