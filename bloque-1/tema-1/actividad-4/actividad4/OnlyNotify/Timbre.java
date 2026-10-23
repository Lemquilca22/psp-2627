package actividad4.OnlyNotify;

public class Timbre {
    private boolean lista = false;
    private int despertados = 0;

    public synchronized void esperar(String alumno) throws InterruptedException{
        while (!lista){
            System.out.println("[ "+ alumno + "] Esperando la campana -> wait()" );
            wait();
        }
        despertados++;
        System.out.println("[" + alumno + "] ¡salió al patio! (despertados: " + despertados + ")");

    }

    public synchronized void avisarConNotify(){
        lista = true;
        System.out.println("[Portero] ¡Tocó el timbre! → notify() (solo UNO debería salir al patio)");
        notify();
    }

    public synchronized void avisarConNotifyAll(){
        lista = true;
        System.out.println("[Portero] ¡Tocó el timbre! → notifyAll() (TODOS deberían salir al patio)");
        notifyAll();
    }

    public synchronized int getDespertados() {
        return despertados;
    }

    public synchronized void liberarRestantes() {
        lista = true;
        System.out.println("[Portero] notifyAll() de limpieza (Hace salir a los que siguen esperando)");
        notifyAll();
    }

}
