package actividad4.OnlyNotify;

import e06.Bebe;
import e06.Cocinero;
import e06.Plato;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("===1) Tres alumnos + portero con notify() ===");
        demoNotify();

        Thread.sleep(300);
        System.out.println();
        System.out.println("=== 2 ) Tres alumnos + Portero con notifyAll() ==");
        demoNotifyAll();
    }
    private static void demoNotify() throws InterruptedException {
        Timbre timbre = new Timbre();
        Thread[] alumnos = arrancarAlumnos(timbre, 3);
        Thread portero = new Thread(new Portero(timbre, false),"portero");
        portero.start();

        Thread.sleep(400);
        System.out.println(">> Tras notify(): salieron al patio = "+ timbre.getDespertados()+ "(esperado: 1)");

        timbre.liberarRestantes();
        joinAllAlumnos(alumnos);
        portero.join();
        System.out.println(">> Al final (tras limpieza): despertados = " + timbre.getDespertados());
    }
    private static void demoNotifyAll() throws InterruptedException{
        Timbre timbre = new Timbre();
        Thread[] alumnos = arrancarAlumnos(timbre, 3);
        Thread portero = new Thread(new Portero(timbre, true),"portero");
        portero.start();

        joinAllAlumnos(alumnos);
        portero.join();
        System.out.println(">> Tras notifyAll(): despertados = " + timbre.getDespertados() + "esperado; 3");
    }

    private static Thread[] arrancarAlumnos(Timbre timbre, int n){
        Thread[] alumnos = new Thread[n];
        for (int i = 0; i < n; i++) {
            String nombre = "alumno" + (i+1);
            alumnos[i] = new Thread(new Alumno(timbre, nombre),nombre);
            alumnos[i].start();
        }
        return alumnos;
    }
    private static void joinAllAlumnos(Thread[] hilos) throws InterruptedException{
        for (Thread h : hilos){
            h.join();
        }
    }
}
