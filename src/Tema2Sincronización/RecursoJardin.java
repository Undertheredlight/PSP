
package Tema2Sincronización;

/**
 *
 * @Liz FP
 */
public class RecursoJardin {
        //clase que simula las entradas y aslidas al Jardín
    private int cuenta;//para contar las entradas y salidas al jardin
    
    public RecursoJardin(){
        cuenta = 100; //inicialmente hay 100 personas en el jardín
    }
    
    //lo unico que necesitamos para que sea ordenador es colocar la palabra reservada synchronized
    public synchronized void incrementaCuenta(){
        //método que incrementa en 1 la variable cuenta
        System.out.println("Hilo "+Thread.currentThread().getName()
        +" ---- Entra en Jardin");
        
        //muestra el hilo que entra en el método
        cuenta++;
        System.out.println(cuenta+ " en jardin");
    }
    
    public synchronized void decrementaCuenta(){
        //método que decrementa en 1 la variable cuenta
         System.out.println("Hilo "+Thread.currentThread().getName()
        +" ---- Sale en Jardin");
        
        //muestra el hilo que entra en el método
        cuenta--;
        System.out.println(cuenta+ " en jardin");
    }
}
