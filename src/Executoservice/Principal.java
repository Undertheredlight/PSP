package Executoservice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Liz
 */
public class Principal {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //Declaro e instancio el ExecutorService
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //Preparo una coleccion de objetos Callables que harán cada uno una cosa
        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        //hacemos un hasmap de callables
        //añado los objetos a la cola, cada uno con su operación 
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Tarea 1";
            }
        });

        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Tarea 2";
            }
        });

        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Tarea 3";
            }
        });

        //declaro la lista de objetos Future y utilizo el método de llamar a todos
        java.util.List<Future<String>> futures = executorService.invokeAll(callables);

        //recojo las soluciones de cada uno de los objetos Future
        for (Future<String> future : futures) {
            System.out.println("future.get = " + future.get());
        }
        //Hay que terminar el proceso siempre, sino no se cierra
        executorService.shutdown();

    }
}
