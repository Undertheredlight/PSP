package Tema2Hilos.Ejemplo;

/**
 *
 * @Liz FP
 */
public class Enfermero2 extends Thread {

    private String nombre;
    private ListaPaciente lista;
    private long inicio;

    public Enfermero2(String nombre, ListaPaciente lista, long inicio) {
        this.nombre = nombre;
        this.lista = lista;
        this.inicio = inicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaPaciente getLista() {
        return lista;
    }

    public void setLista(ListaPaciente lista) {
        this.lista = lista;
    }

    public long getInicio() {
        return inicio;
    }

    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    private void tiempoVacunacion(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
       public void run(){
            System.out.println("El enfermero "+this.nombre
            + " Comienza a vacunar la compra del cliente "
            +lista.getNombre()
            +" En el tiempo: "+(System.currentTimeMillis()-inicio)/1000
            +" segundos");
            
            for (int i = 0; i < lista.getTiempoPacientes().length; i++) {
                this.tiempoVacunacion(lista.getTiempoPacientes()[i]);
                System.out.println("Vacunando al paciente "+ (i+1)
                +" de la lista "+this.lista.getNombre()
                +" ->Tiempo: "+(System.currentTimeMillis()-inicio)/1000
                + " seg");
            }
            
            System.out.println("El emfermero "+ this.nombre+" ha terminado de vacunar"
            +lista.getNombre()+" en el tiempo: "
            +(System.currentTimeMillis()-inicio)/1000+" seg");
        }
       }
    

