package actividad6;

import java.io.IOException;

public class Trabajador2 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("[trabajador] espero órdenes en " + Canal2.ARCHIVO);

        while (true) {
            Mensaje mensaje = recibirSeguro();

            if (mensaje != null && mensaje.esFin()) {
                System.out.println("[trabajador] leo: fin. cierro.");
                return;
            }

            if (mensaje != null && mensaje.esEjecuta()) {
                int numero = mensaje.tarea;

                System.out.println("[trabajador] leo: ejecuta tarea " + numero);
                System.out.println("[trabajador] estoy trabajando");

                enviarSeguro(Mensaje.trabajando(numero));
                long resultado = ejecutar(numero);
                enviarSeguro(Mensaje.completa(numero, resultado));

                System.out.println("[trabajador] digo: tarea " + numero + " completa, resultado=" + resultado);
            }
            Thread.sleep(Canal2.PAUSA_MS);
        }
    }

    private static long ejecutar(int numero) throws InterruptedException {
        Thread.sleep(Canal2.ANTES_DE_CONTESTAR_MS);
        return 3L * numero; // con 3*n, la suma de las tareas 1..8 es 108
    }

    private static Mensaje recibirSeguro() {
        try {
            return Canal2.recibir();
        } catch (IOException | IllegalArgumentException e) {
            return null;
        }
    }

    private static void enviarSeguro(Mensaje mensaje) throws InterruptedException {
        while (true) {
            try {
                Canal2.enviar(mensaje);
                return;
            } catch (IOException e) {
                System.out.println("[trabajador] fallo al escribir, reintento: " + e);
                Thread.sleep(Canal2.PAUSA_MS);
            }
        }
    }
}