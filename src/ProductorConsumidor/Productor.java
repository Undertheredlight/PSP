package ProductorConsumidor;


/**
 *
 * @author Liz
 */
 class Productor implements Runnable{
    ObjetoCompartido compartido;
    
    Productor(ObjetoCompartido compartido){
        this.compartido = compartido;
    }
    
    @Override
    public void run(){
        for(int y = 0;y<5;y++){
            System.out.println("El productor produce: "+y);
            this.compartido.set(y);
            try{
                Thread.currentThread().sleep(500);
            }catch(InterruptedException e){   
                System.out.println(e.getMessage());
            }
        }
    }
}
