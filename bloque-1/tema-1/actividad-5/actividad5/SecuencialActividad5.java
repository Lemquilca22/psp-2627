package actividad5;

import e10.Tarea;

public class SecuencialActividad5 {
    public static void main(String[] args) throws InterruptedException{
        long[] resultados = new long[TareaActividad5.TOTAL]; //Entiendo que es para darle tamaño al array

        System.out.println("Secuencial. Hilo "+ Thread.currentThread().getName());
        System.out.println(TareaActividad5.TOTAL+" tareas x "+ TareaActividad5.DURACION_MS+ "ms");
        System.out.println("Esperando: unos "+(TareaActividad5.TOTAL * TareaActividad5.DURACION_MS/1000)+" s");
        System.out.println("---");

        long inicio = System.nanoTime();

        for (int numero = 1; numero <= TareaActividad5.TOTAL; numero++) {
            resultados[numero-1] = TareaActividad5.ejecutar(numero);
            if (numero%100 == 0){
                System.out.println("[main] guardada la tarea " + numero + " / " + TareaActividad5.TOTAL);
            }
        }
        long ms = (System.nanoTime() - inicio)/1_000_000;

        informar(resultados, ms);
    }
    static void informar(long[] resultados, long ms){
        long suma = TareaActividad5.suma(resultados);
        System.out.println("[main] guardé " + resultados.length + " resultados");
        System.out.println("[main] resultado final = " + suma + " (esperado " + TareaActividad5.sumaEsperada() + ")");
        System.out.println("[main] tiempo = " + ms + " ms");
    }
}
