package actividad2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread impresoraThread = new Thread(new Impresora("impresora",5), "impresora");
        Thread correoThread = new Thread(new Correo("correo",10), "correo");
        Thread backupThread = new Thread(new Backup("backup",2), "backup");

        System.out.println("Iniciando ordenador y lanzando procesos");

        impresoraThread.start();
        correoThread.start();
        backupThread.start();

        impresoraThread.join();
        correoThread.join();
        backupThread.join();

        System.out.println("Apagando ordenador.");
    }
}
