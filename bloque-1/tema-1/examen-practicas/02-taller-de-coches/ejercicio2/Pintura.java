package ejercicio2;

public class Pintura implements Runnable {
    private final String nombre;
    private final long milisegundos;

    public Pintura(String nombre, long milisegundos) {
        this.nombre = nombre;
        this.milisegundos = milisegundos;
    }

    @Override
    public void run(){
        try {
            System.out.println("[" + nombre + "] Pinto un coche nuevo cada " + milisegundos + " ms...");
            this.toPaint();
            this.toPaint();
            this.toPaint();
            this.toPaint();
            this.toPaint();

        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("[" + nombre + "] me interrumpieron mientras pintaba");
        }
    }
    private void toPaint() throws InterruptedException {
        Thread.sleep(milisegundos);
        System.out.println("[" + nombre + "] ¡Pintura acabada con exito!");
    }
}
