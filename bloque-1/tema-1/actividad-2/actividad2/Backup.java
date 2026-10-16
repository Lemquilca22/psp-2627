package actividad2;

public class Backup implements Runnable {
    private final String nombre;
    private final long milisegundos;

    public Backup(String nombre, long milisegundos) {
        this.nombre = nombre;
        this.milisegundos = milisegundos;
    }
    @Override
    public void run(){
        try {
            System.out.println("[" + nombre + "] Hago copia de seguridad cada " + milisegundos + " ms...");

            this.doBackup();
            this.doBackup();
            this.doBackup();

//            Thread.sleep(milisegundos);
//            System.out.println("[" + nombre + "] ¡Backup realizado con exito! (nadie hizo notify)");
//
//            Thread.sleep(milisegundos);
//            System.out.println("[" + nombre + "] ¡Backup realizado con exito! (nadie hizo notify)");
//
//            Thread.sleep(milisegundos);
//            System.out.println("[" + nombre + "] ¡Backup realizado con exito! (nadie hizo notify)");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[" + nombre + "] me interrumpieron mientras hacia Backup");
        }
    }

    private void doBackup() throws InterruptedException {
        Thread.sleep(milisegundos);
        System.out.println("[" + nombre + "] ¡Backup realizado con exito!");
    }
}
