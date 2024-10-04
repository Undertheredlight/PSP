package ProductorConsumidor;

/**
 *
 * @author Liz
 */


 class Consumidor implements Runnable{
    //referencia a un objeto compartido
    private ObjetoCompartido compartido;

    Consumidor(ObjetoCompartido compartido) {
        this.compartido = compartido;
    }
    
    @Override
    public void run(){
        for(int y =0; y<5;y++){
            System.out.println("El consumidor consume: "+this.compartido.get());
            this.compartido.set(y);
            try{
                Thread.currentThread().sleep(100);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
}
