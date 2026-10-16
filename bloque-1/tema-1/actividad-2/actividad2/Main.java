package actividad2;

import e09.Alarma;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread impresora = new Thread(new Impresora("impresora", 500), "impresora");
        Thread correo = new Thread(new Correo("correo", 1000), "correo");
        Thread backup = new Thread(new Backup("backup", 1500), "backup");

        System.out.println("sleep: Una impresora imprime, un empleado revisa varios mientras se realiza un backup automatica se duermen, cada uno despierta solo");
        System.out.println("---");
        impresora.start();
        correo.start();
        backup.start();

        System.out.println("[main] mientras ellos duermen, yo sigo (no estoy bloqueado)");

        impresora.join();
        correo.join();
        backup.join();
        System.out.println("---");
        System.out.println("main: fin");
    }
}
