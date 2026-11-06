package ejercicio2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Tengo que pasarle el runnable y un nombre
        Thread mecanicoThread = new Thread(new Mecanico("mecánico",8),"mecánico");
        Thread chapaThread = new Thread(new Chapa("chapa",6),"chapa");
        Thread pinturaThread = new Thread(new Pintura("pintura",4),"pintura");

        System.out.println("Abriendo taller");

        mecanicoThread.start();
        chapaThread.start();
        pinturaThread.start();

        mecanicoThread.join();
        chapaThread.join();
        pinturaThread.join();

        System.out.println("Cerrando taller.");
    }
}
