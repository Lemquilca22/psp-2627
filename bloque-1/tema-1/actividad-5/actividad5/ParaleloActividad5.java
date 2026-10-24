package actividad5;

import e10.Secuencial;
import e10.Tarea;
import e10.Trozo;

public class ParaleloActividad5 {

    public static void main(String[] args) throws InterruptedException{
        //Entiendo que esto comprueba si la cantidad total de tareas dividida por Hilos*PorTareasxHilo
        //No deja residuo, o sea que hay tareas equitativamente asignadas por cada hilo.
        if (TareaActividad5.TOTAL != TareaActividad5.HILOS * TareaActividad5.POR_HILO){
            throw new IllegalStateException("TOTAL tiene que repartirse exacto entre los hilos");
        }

        long[] resultados = new long[TareaActividad5.TOTAL];//Array de 800 espacios.
        TrozoActividad5[] trozos = new TrozoActividad5[TareaActividad5.HILOS];//Array de 8 objetos tipo TrozoAc...
        Thread[] hilos = new Thread[TareaActividad5.HILOS];// Array de 8 objetos tipo Threads.

        System.out.println("Paralelo. Hilo: " + Thread.currentThread().getName());
        System.out.println(TareaActividad5.HILOS + " hilos × " + TareaActividad5.POR_HILO + " tareas × " + Tarea.DURACION_MS + " ms");
        System.out.println("Esperado: unos " + (TareaActividad5.POR_HILO * TareaActividad5.DURACION_MS / 1000) + " s, si van a la vez");
        System.out.println("---");

        long inicio = System.nanoTime();//guarda el tiempo en el que inicia
        for (int h = 0; h < TareaActividad5.HILOS; h++) {//Mientras h sea menor a la cantidad de hilos (8)
            int desde = h * TareaActividad5.POR_HILO +1; //(0*100 +1)= "1" ;
                                                        // (1*100 + 1)=101;
            int hasta = desde + TareaActividad5.POR_HILO -1; //(1+100 -1), (101+100 -1)
            trozos[h] = new TrozoActividad5(h+1,desde,hasta); //Objeto tipo trozoActividad5 =(1, 1,100):
                                                                    // [(1,1,100); (2,101,200)]
            hilos[h] = new Thread(trozos[h],"hilo-"+(h + 1)); // [(Objeto trozo1, hilo 1)]
            hilos[h].start(); //¿Lo que hace esto es comenzar es el run de TrozoActividad5?
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }

        for (TrozoActividad5 trozo : trozos){ //Va a pasar 8 veces porque esa es la cantidad de hilos.
            guardar(resultados, trozo);
        }

        long ms = (System.nanoTime() - inicio) /1_000_000;

        SecuencialActividad5.informar(resultados, ms);
    }
    private static void guardar(long[] resultados, TrozoActividad5 trozo) {
        for (int i = 0; i < trozo.parcial.length; i++) { // va a recorrer 100 veces, porque, "i" comienza como 0
                                                        // y parcial vale en cada hilo 100, la "i" debe llegar a 99 y se para
            resultados[trozo.desdeInicio - 1 + i] = trozo.parcial[i];//[0-1+0]
        }
        System.out.println("[main] guardo el tramo " + trozo.desdeInicio + ".." + trozo.hastaFin);
    }
}
