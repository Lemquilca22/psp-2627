package actividad2;

public class Correo implements Runnable {
    private final String nombre;
    private final long milisegundos;

    public Correo(String nombre, long milisegundos) {
        this.nombre = nombre;
        this.milisegundos = milisegundos;
    }
    @Override
    public void run(){
        try {
            System.out.println("[" + nombre + "] reviso varios mensasjes cada " + milisegundos + " ms...");
            this.writeEmail();
            this.writeEmail();
            this.writeEmail();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[" + nombre + "] me interrumpieron mientras leia");
        }
    }
    private void writeEmail() throws InterruptedException {
        Thread.sleep(milisegundos);
        System.out.println("[" + nombre + "] ¡paginas revisadas!");
    }
}
