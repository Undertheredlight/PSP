package Tema1ProcessBuilder;

import java.util.Scanner;

/**
 *
 * @author FP
 */
public class Principal {

    public static void main(String[] args) throws InterruptedException {
        Scanner teclado = new Scanner(System.in);
        String ruta1 = "calc.exe";
        EjecutarProceso lp = new EjecutarProceso();
        lp.ejecutar(ruta1);

        Thread.sleep(2000);

        String ruta2 = "\"C:\\Program Files\\Microsoft Office\\root\\Office16\\POWERPNT.EXE\"";
        EjecutarProceso pp = new EjecutarProceso();
        pp.ejecutar(ruta2);

       
        String ruta3 = "\"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe\"";
        EjecutarProceso ch = new EjecutarProceso();
        ch.ejecutar(ruta2);
        
        System.out.println("Introduce la ruta del ejecutable: ");
        String ruta = teclado.nextLine();
        
        
        
        
        
        System.out.println("Finalizado");

    }
}
