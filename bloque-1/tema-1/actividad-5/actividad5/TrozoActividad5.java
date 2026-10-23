package actividad5;

public class TrozoActividad5 implements Runnable{

    final int idHilo;
    final int desdeInicio;
    final int hastaFin;
    final long[] parcial;

    public TrozoActividad5(int idHilo, int desdeInicio, int hastaFin) {
        this.idHilo = idHilo;
        this.desdeInicio = desdeInicio;
        this.hastaFin = hastaFin;
        this.parcial = new long[hastaFin - desdeInicio + 1];
    }

    @Override
    public void run(){
    try {
        System.out.println("[Hilo-" + idHilo +"] empiezo tareas "+ desdeInicio +".."+ hastaFin);
        for (int numero = desdeInicio; numero <= hastaFin; numero++) {
            parcial[numero - desdeInicio] = TareaActividad5.ejecutar(numero);
        }
        System.out.println("[hilo-" + idHilo + "] tramo listo");
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("[hilo-" + idHilo + "] me interrumpieron");
    }
    }
}
