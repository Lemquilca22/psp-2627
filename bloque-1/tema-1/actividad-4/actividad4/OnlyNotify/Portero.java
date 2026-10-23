package actividad4.OnlyNotify;

public class Portero implements Runnable{
    private final Timbre timbre;
    private final boolean aTodos;

    public Portero(Timbre timbre, boolean aTodos) {
        this.timbre = timbre;
        this.aTodos = aTodos;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(250);
            if (aTodos){
                timbre.avisarConNotifyAll();
            } else {
                timbre.avisarConNotify();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
