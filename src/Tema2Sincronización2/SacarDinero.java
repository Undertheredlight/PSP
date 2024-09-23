package Tema2Sincronización2;

/**
 *
 * @Liz FP
 */
public class SacarDinero extends Thread{

    private Cuenta c;

    public SacarDinero(String n, Cuenta c) {
        super(n);
        this.c = c;
    }

    public void run() {
        for (int x = 0; x <= 4; x++) {
            c.RetirarDinero(10, getName());
            try {
                Thread.sleep(1000);//para que espere 1 segundo y luego pueda entrar otro proceso
            } catch (InterruptedException ex) {
            }
        }
    }

}
