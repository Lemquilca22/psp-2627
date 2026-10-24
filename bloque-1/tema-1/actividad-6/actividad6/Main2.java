package actividad6;

import java.io.IOException;

public class Main2 {

    private static final int TAREAS = 8; // cuántas tareas hay lo decide Main

    public static void main(String[] args) throws InterruptedException {
        long[] resultados = new long[TAREAS];

        System.out.println("[main] canal: " + Canal2.ARCHIVO);
        System.out.println("[main] el otro proceso es actividad6.Trabajador2. Si no está arrancado, me quedo esperando.");
        System.out.println("---");

        for (int numero = 1; numero <= TAREAS; numero++) {
            enviarSeguro(Mensaje.ejecuta(numero));
            System.out.println("[main] digo: ejecuta tarea " + numero);

            Mensaje respuesta = esperarCompleta(numero);
            resultados[numero - 1] = respuesta.resultado;
            System.out.println("[main] guardo tarea " + numero + " -> " + respuesta.resultado);

            System.out.println("[main] espero antes de contestar");
            Thread.sleep(Canal2.ANTES_DE_CONTESTAR_MS);
        }

        enviarSeguro(Mensaje.fin());

        long suma = 0;
        System.out.println("---");
        System.out.println("[main] guardé " + resultados.length + " resultados:");
        for (int i = 0; i < resultados.length; i++) {
            System.out.println("  tarea " + (i + 1) + " -> " + resultados[i]);
            suma += resultados[i];
        }
        System.out.println("[main] suma = " + suma);
    }

    private static Mensaje esperarCompleta(int numero) throws InterruptedException {
        while (true) {
            Mensaje mensaje = recibirSeguro();
            if (mensaje != null && mensaje.esCompleta() && mensaje.tarea == numero) {
                return mensaje;
            }
            Thread.sleep(Canal2.PAUSA_MS);
        }
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
                System.out.println("[main] fallo al escribir, reintento: " + e);
                Thread.sleep(Canal2.PAUSA_MS);
            }
        }
    }
}