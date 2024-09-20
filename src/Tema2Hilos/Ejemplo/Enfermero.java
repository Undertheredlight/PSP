
package Tema2Hilos.Ejemplo;

/**
 *
 * @Liz FP
 */
public class Enfermero {
    private String nombre;

    public Enfermero(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    private void tiempoVacunacion(int segundos){ 
        try{
            Thread.sleep(segundos * 1000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        
    }
    
    public void vacunar(ListaPaciente lista, long timeStamp){
            System.out.println("El enfermero "+this.nombre
            + " Comienza a vacunar la compra del cliente "
            +lista.getNombre()
            +" En el tiempo: "+(System.currentTimeMillis()-timeStamp)/1000
            +" segundos");
            
            for (int i = 0; i < lista.getTiempoPacientes().length; i++) {
                this.tiempoVacunacion(lista.getTiempoPacientes()[i]);
                System.out.println("Vacunando al paciente "+ (i+1)
                +" ->Tiempo: "+(System.currentTimeMillis()-timeStamp)/1000
                + " seg");
            }
            
            System.out.println("El emfermero "+ this.nombre+" ha terminado de vacunar"
            +lista.getNombre()+" en el tiempo: "
            +(System.currentTimeMillis()-timeStamp)/1000+" seg");
        }
    }

