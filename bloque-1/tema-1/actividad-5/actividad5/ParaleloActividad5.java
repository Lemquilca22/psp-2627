package actividad5;

import e10.Secuencial;
import e10.Tarea;
import e10.Trozo;

public class ParaleloActividad5 {

    public static void main(String[] args) throws InterruptedException{
        if (TareaActividad5.TOTAL != TareaActividad5.HILOS * TareaActividad5.POR_HILO){
            throw new IllegalStateException("TOTAL tiene que repartirse exacto entre los hilos");
        }

        long[] resultados = new long[TareaActividad5.TOTAL];
        TrozoActividad5[] trozos = new TrozoActividad5[TareaActividad5.HILOS];
        Thread[] hilos = new Thread[TareaActividad5.HILOS];

        System.out.println("Paralelo. Hilo: " + Thread.currentThread().getName());
        System.out.println(TareaActividad5.HILOS + " hilos × " + TareaActividad5.POR_HILO + " tareas × " + Tarea.DURACION_MS + " ms");
        System.out.println("Esperado: unos " + (TareaActividad5.POR_HILO * TareaActividad5.DURACION_MS / 1000) + " s, si van a la vez");
        System.out.println("---");

        long inicio = System.nanoTime();
        for (int h = 0; h < TareaActividad5.HILOS; h++) {
            int desde = h * TareaActividad5.POR_HILO +1;
            int hasta = desde + TareaActividad5.POR_HILO -1;
            trozos[h] = new TrozoActividad5(h+1,desde,hasta);
            hilos[h] = new Thread(trozos[h],"hilo-"+(h + 1));
            hilos[h].start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }

        for (TrozoActividad5 trozo : trozos){
            guardar(resultados, trozo);
        }

        long ms = (System.nanoTime() - inicio) /1_000_000;

        SecuencialActividad5.informar(resultados, ms);
    }
    private static void guardar(long[] resultados, TrozoActividad5 trozo) {
        for (int i = 0; i < trozo.parcial.length; i++) {
            resultados[trozo.desdeInicio - 1 + i] = trozo.parcial[i];
        }
        System.out.println("[main] guardo el tramo " + trozo.desdeInicio + ".." + trozo.hastaFin);
    }
}
