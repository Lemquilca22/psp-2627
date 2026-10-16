package actividad3.ConSincronizacion;

public class IncrementadorSincronizado implements Runnable {
    private final AforoSincronizado aforo;
    private final int veces;

    public IncrementadorSincronizado(AforoSincronizado aforo, int veces) {
        this.aforo = aforo;
        this.veces = veces;
    }
    @Override
    public void run() {
        for (int i = 0; i < veces ; i++) {
            aforo.entrar();
        }
    }
}
