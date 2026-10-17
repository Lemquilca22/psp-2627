package actividad4.OnlyNotify;

public class Alumno implements Runnable {
    private final Timbre timbre;
    private final String nombre;

    public Alumno(Timbre timbre, String nombre) {
        this.timbre = timbre;
        this.nombre = nombre;
    }

    @Override
    public void run(){
        try {
           timbre.esperar(nombre);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
