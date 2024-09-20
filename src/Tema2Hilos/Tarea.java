
package Tema2Hilos;

/**
 *
 * @Liz FP
 */
public class Tarea extends Thread{
    
    @Override
    public void run(){
        for (int i = 0; i < 11; i++) {
            System.out.println("Soy el hilo "+i+" y esto es lo que hago");
        }
    }
}
