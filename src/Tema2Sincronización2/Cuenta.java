package Tema2Sincronización2;

/**
 *
 * @Liz FP
 */
public class Cuenta {

    private int saldo;

    Cuenta(int s) {
        saldo = s;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    private void restar(int cantidad) {
        saldo = saldo - cantidad;
    }

    synchronized void RetirarDinero(int cant, String nom) {
        if (getSaldo() >= cant) {
            System.out.println(nom + ": SE VA A TETIRAR SALDO (ACTUAL ES: " + getSaldo() + ")");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }

            restar(cant);//aqui resto 

            System.out.println("\t " + nom + " retira =>" + cant + " ACTUAL(" + getSaldo() + ")");

        } else {
            System.out.println("No se puede retirar dinero, NO HAY SALDO(" + getSaldo() + ")");
        }
        if (getSaldo() < 0) {
            System.out.println("SALDO NEGATIVO =>" + getSaldo());
        }
    }//retirar

}
