package actividad3.ConSincronizacion;

public class AforoSincronizado {
    private int valor= 0;

    public synchronized void entrar(){
        int actual= valor;
        valor = actual + 1;
    }
    public synchronized int getTotal(){
        return valor;
    }
}
