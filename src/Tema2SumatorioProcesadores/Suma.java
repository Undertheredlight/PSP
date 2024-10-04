//implementa el Callable
package Tema2SumatorioProcesadores;

import java.util.concurrent.Callable;

/**
 *
 * @author Liz
 */
public class Suma implements Callable<Long> {

    private long n1;
    private long n2;

    //constructores
    public Suma() {
        this.n1=0;
        this.n2=0;
    }

    public Suma(long n1, long n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public Long call() {
        long result = 0;
        try {
            Thread hiloActual = Thread.currentThread(); //esto lo hago para preguntar quien soy, a nivel informativo
            System.out.println("Iniciando el hilo " + hiloActual.getName() + ": Suma (" + this.n1 + "," + this.n2 + ")");

            //acumulador del sumatorio (inicio al final)
            for (long y = this.n1; y <= this.n2; y++) {
                result = result + y;
            }

            //añadimos una pausa para simular mayot carga en los calculos
            Thread.sleep(500); //Utilizamos la version estatica de sleep
            System.out.println("Finalizando el hilo " + hiloActual.getName());
            System.out.println("Resultado dle hilo: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
