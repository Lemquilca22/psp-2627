package actividad3.SinSincronizar;

public class Aforo {
    private int valor = 0;

    public void entrar(){
        int actual = valor;
        valor = actual + 1;
    }
    public int getAforo(){
        return valor;
    }
}
