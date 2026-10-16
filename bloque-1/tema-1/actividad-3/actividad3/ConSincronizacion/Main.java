package actividad3.ConSincronizacion;

import actividad3.SinSincronizar.Incrementador;

public class Main {
    private static final int VISITANTES_POR_HILO = 1000;

    public static void main(String[] args) throws InterruptedException {
        AforoSincronizado aforoSinc = new AforoSincronizado();

        Thread v1 = new Thread(new IncrementadorSincronizado(aforoSinc, VISITANTES_POR_HILO),"visitante1");
        Thread v2 = new Thread(new IncrementadorSincronizado(aforoSinc, VISITANTES_POR_HILO),"visitante2");
        Thread v3 = new Thread(new IncrementadorSincronizado(aforoSinc, VISITANTES_POR_HILO),"visitante3");
        Thread v4 = new Thread(new IncrementadorSincronizado(aforoSinc, VISITANTES_POR_HILO),"visitante4");

        System.out.println("Cuatro visitantes × " + VISITANTES_POR_HILO + " = esperado "
                + (4 * VISITANTES_POR_HILO));
        System.out.println("Sin Lock. Arrancamos...");

        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v1.join();
        v2.join();
        v3.join();
        v4.join();

        System.out.println("Resultado real: " + aforoSinc.getTotal());
        System.out.println("(Si es menor que el esperado: se han pisado lecturas/escrituras)");
    }
}
