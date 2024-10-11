package Tema2SumatorioProcesadoresCallable;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 *
 * @author Liz
 */
public class Principal {

    public static void main(String[] args) {

        //capturamos parametros cuando hagamos la llamada
        Long index1 = 1L;
        Long index2 = 100L;

        try {
            /*
            //Ordenamos los indices
        //por si el primero es mayor que el segundo
        if(index1>index2){
            Long tmp = index1;
            index1 = index2;
            index2 = tmp;
        }
             */

            //Particionen el rango de valores en tantos rangos como procesadores tenemos
            //calculamos primero la cantidad de procesadores
            Runtime runtime = Runtime.getRuntime();
            int num_procesadores = runtime.availableProcessors();
            System.out.println("Diviendo la tarea " + num_procesadores + " hilos");

            //obtencion de los rangos
            Long incremento = index2 / num_procesadores; //debido a que 1 se utiliza para ejecutar esto, dejamos los demas libres
            System.out.println("El rango de incremento es de " + incremento);

            //creacion del vector de sumas parciales (FutureTask)
            ArrayList<FutureTask<Long>> sumaFuture = new ArrayList<FutureTask<Long>>();

            //creamos el vector de los hilos de tipo Thread con el nº de procesadores
            Thread vectorHilos[] = new Thread[num_procesadores];

            for (int i = 0; i < num_procesadores; i++) {
                //creamos objeto tipo suma, que es threadable
                long ini = index1 + incremento * i;
                long fin = index1 + incremento * (i + 1) - 1;
                if (fin > index2) {
                    fin = index2;
                }
                    //creamos ahora suma, que es Callable
                    Suma sumaParcial = new Suma(ini, fin);

                    //cremaos el futuretask que la encapsula para que sea runnabñe
                    sumaFuture.add(new FutureTask<Long>(sumaParcial));

                    //creamos y lanzamos el hilo a partir del FutureTask
                    vectorHilos[i] = new Thread(sumaFuture.get(i));
                    vectorHilos[i].setName("Hilo " + i);
                    vectorHilos[i].start();
                
            }

            //esperamos que terminen todos, vamos añadiendo su valor de retorno a un acumulador
            long ac = 0;

            for (int i = 0; i < num_procesadores; i++) {
                vectorHilos[i].join();
                ac = ac + sumaFuture.get(i).get();
            }

            System.out.println("Suma total: " + ac);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
