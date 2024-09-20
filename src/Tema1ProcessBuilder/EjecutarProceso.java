package Tema1ProcessBuilder;

/**
 *
 * @author FP
 */
public class EjecutarProceso {

    public void ejecutar(String ruta) {
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder(ruta);
            
            pb.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
