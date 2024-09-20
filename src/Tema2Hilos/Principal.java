package Tema2Hilos;

/**
 *
 * @Liz FP
 */
public class Principal {

    public static void main(String[] args) {

        Tarea tarea = new Tarea();
        Tarea2 tarea2 = new Tarea2();

        //Para que se ejecuten por orden las tareas
        //1º start y 2º join
        
        tarea.start();
        try {
            tarea.join();   //cuando pongo los join hasta que no pasan las 2 tareas, no continua el programa

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        tarea2.start();
        try {
            tarea2.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.println("Yo soy el programa principal y sigo currando");
        System.out.println("Fin del hilo ppal");
    }
}
