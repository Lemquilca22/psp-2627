package actividad5;

public class TareaActividad5 {
    public static final int TOTAL = 800;
    public static final int HILOS = 8;
    public static final int POR_HILO = TOTAL / HILOS;
    public static final long DURACION_MS = 25;

    private TareaActividad5(){}

    public static long ejecutar(int numero) throws InterruptedException{
        Thread.sleep(DURACION_MS);
        return 1;
    }

    public static long suma(long[] resultados){
        long total = 0;
        for (long resultado : resultados){
            total += resultado;
        }
        return total;
    }
    public static long sumaEsperada(){ return TOTAL;}
}
