package ejercicio2;

public class Chapa implements Runnable {
    private final String nombre;
    private final long milisegundos;

    public Chapa(String nombre, long milisegundos) {
        this.nombre = nombre;
        this.milisegundos = milisegundos;
    }

    @Override
    public void run(){
        try {
            System.out.println("[" + nombre + "] enchapo un coche cada " + milisegundos + " ms...");
            this.toPlate();
            this.toPlate();
            this.toPlate();
            this.toPlate();
            this.toPlate();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[" + nombre + "] me interrumpieron mientras enchapaba un coche");
        }
    }
    private void toPlate() throws InterruptedException {
        Thread.sleep(milisegundos);
        System.out.println("[" + nombre + "] ¡coche enchapado!");
    }
}
