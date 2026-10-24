package actividad5;

public class TrozoActividad5 implements Runnable{

    //Es un abstracto
    final int idHilo;
    final int desdeInicio;
    final int hastaFin;
    final long[] parcial;

    public TrozoActividad5(int idHilo, int desdeInicio, int hastaFin) {
        this.idHilo = idHilo;
        this.desdeInicio = desdeInicio;
        this.hastaFin = hastaFin;
        this.parcial = new long[hastaFin - desdeInicio + 1];//99-0+1 = 100; 199-100+1= 100;
                                                            //Array de 100 espacios
    }

    @Override
    public void run(){
    try {
        System.out.println("[Hilo-" + idHilo +"] empiezo tareas "+ desdeInicio +".."+ hastaFin);
        for (int numero = desdeInicio; numero <= hastaFin; numero++) { //(numero <= 100)=(1; 1<=100) - va a ejecutarse 100 veces
            parcial[numero - desdeInicio] = TareaActividad5.ejecutar(numero);// parcial[1-1] = 1
                                                                            // parcial [2-1] = 1
        }
        System.out.println("[hilo-" + idHilo + "] tramo listo");
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("[hilo-" + idHilo + "] me interrumpieron");
    }
    }
}
