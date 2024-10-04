package Sumatorio;

/**
 *
 * @Liz FP
 */
public class Sumatorio extends Thread { //lo metemos en un hilo porque es critico (Thread)

    private double numero;
    private double resultado;

    public double getResultado() {
        return resultado;
    }

    public Sumatorio(int numero) {
        this.numero = numero;
    }

    public double calImpar() {
        if (numero % 2 == 0) {
            numero = numero - 1;
        }
        double total = 0;
        for (double i = numero; i >= 1; i = i - 2) {
            total += i;
        }
        return total;
    }

    @Override
    public void run() {
        this.resultado = calImpar();
    }
}
