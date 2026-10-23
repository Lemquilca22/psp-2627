package actividad3.SinSincronizar;

public class Incrementador implements Runnable{
    private final Aforo aforo;
    private final int veces;

    public Incrementador(Aforo aforo, int veces) {
        this.aforo = aforo;
        this.veces = veces;
    }

    @Override
    public void run(){
        for (int i = 0; i < veces; i++) {
            aforo.entrar();
        }
    }
}
