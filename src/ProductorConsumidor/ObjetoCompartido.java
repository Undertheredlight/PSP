package ProductorConsumidor;

/**
 *
 * @author Liz
 */
public class ObjetoCompartido {

    int valor;
    boolean disponible = false; //inicialmente no tenemos valor

    public synchronized int get() {
        //mientras no tengamos datos disponibles esperamos
        while (disponible == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.disponible = false;
        notifyAll();
        return this.valor;

    }

    public synchronized void set(int val) {
        //Mientras quedan datos nos esperamos

        while (disponible == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        /**
         * cuando se despierte, volvemos a establecer la diponibilidad a cierto,
         * establecemos el calor generado por el porductor y notificamos a todos
         * los consumidores de la disponibildad
         */
        this.valor = val;
        this.disponible = true;
        notifyAll();
    }

}
