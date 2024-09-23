
package Tema2Sincronización;

/**
 *
 * @Liz FP
 */
public class Principal {
    public static void main(String[] args) {
        RecursoJardin jardin = new RecursoJardin();
        //crea un objeto RecursoJardin
        for (int i = 1; i < 10; i++) {
            (new EntraJardin("Entra el "+i, jardin)).start();
        }//entrada de 10 hilos al jardin
        
        for (int i = 0; i < 15; i++) {
            (new SaleJardin("Sale el "+ i, jardin)).start();
        }//salida de 15 hilos del jardin
        
    }
}
