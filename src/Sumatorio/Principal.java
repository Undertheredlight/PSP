package Sumatorio;

/**
 *
 * @Liz FP
 */
public class Principal {

    public static double sumatorio(double numero) {

        double acumulador = 0.0;
        for (int i = 1; i <= numero; i++) {
            acumulador += i;

        }

        return acumulador;
    }

    public static void main(String[] args) {
        
        double formula;
        formula = (sumatorio(5) + sumatorio(8) + sumatorio(20)) / (3 * sumatorio(5));
        System.out.println("El sumatorio es: " + formula);
    }
}
