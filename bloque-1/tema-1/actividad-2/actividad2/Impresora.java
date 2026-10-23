package actividad2;

public class Impresora implements Runnable{
    private final String nombre;
    private final long milisegundos;

    public Impresora(String nombre, long milisegundos) {
        this.nombre = nombre;
        this.milisegundos = milisegundos;
    }
    @Override
    public void run(){
        try {
            System.out.println("[" + nombre + "] imprimo cada " + milisegundos + " ms...");

            this.doPrint();
            this.doPrint();
            this.doPrint();
            this.doPrint();
            this.doPrint();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[" + nombre + "] me interrumpieron mientras imprimia");
        }
    }
    private void doPrint() throws InterruptedException {
        Thread.sleep(milisegundos);
        System.out.println("[" + nombre + "] ¡pagina impresa con exito!");
    }
}
