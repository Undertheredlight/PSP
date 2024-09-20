
package Tema2Hilos;

/**
 *
 * @Liz FP
 */
public class Tarea2 extends Thread{
     @Override
    public void run(){
        for (int i = 20; i < 31; i++) {
            System.out.println("Soy el hilo "+i+" y esto es lo que hago");
        }
    }
}
