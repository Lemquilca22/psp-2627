package ejercicio2;

public class Mecanico implements Runnable {
    private final String nombre;
    private final long milisegundos;

    public Mecanico(String nombre, long milisegundos) {
        this.nombre = nombre;
        this.milisegundos = milisegundos;
    }
    @Override
    public void run(){
        try {
            System.out.println("[" + nombre + "] Reparo el motor de un coche cada " + milisegundos + " ms...");

            this.doRepair();
            this.doRepair();
            this.doRepair();
            this.doRepair();
            this.doRepair();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[" + nombre + "] me interrumpieron mientras reparaba un coche");
        }
    }

    private void doRepair() throws InterruptedException {
        Thread.sleep(milisegundos);
        System.out.println("[" + nombre + "] ¡Coche reparado con exito!");
    }
}
