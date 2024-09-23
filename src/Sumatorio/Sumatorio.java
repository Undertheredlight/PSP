package Sumatorio;



/**
 *
 * @Liz FP
 */
public class Sumatorio extends Thread {

 

    @Override
    public void run() {//metodo principal de cualquier hilo.(lo que quiero que haga el hilo)
       double acumulador = 0.0;
       for(int i =1; i<=numero;i++){
           acumulador +=1;
       }
       Principal.sumatorio(acumulador);
    }
}
