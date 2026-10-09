package actividad1.modelo;

import java.util.ArrayList;
import java.util.List;

public class Receta {
    private String nombreReceta;
    private List<PasoReceta> listPasoReceta;

    public Receta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
        this.listPasoReceta = new ArrayList<>();
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public List<PasoReceta> getListPasoReceta() {
        return listPasoReceta;
    }

    public void setListPasoReceta(List<PasoReceta> listPasoReceta) {
        this.listPasoReceta = listPasoReceta;
    }

    public void agregarPaso(PasoReceta paso) {
        if (paso != null) {
            this.listPasoReceta.add(paso);
        }
    }

    public void ejecutarReceta(Cocinero cocinero) {
        System.out.println("==================================================");
        System.out.println("=== INICIANDO RECETA: " + this.nombreReceta.toUpperCase() + " ===");
        System.out.println("Cocinero a cargo: " + cocinero.getNombre());
        System.out.println("Número total de pasos: " + this.listPasoReceta.size());
        System.out.println("==================================================");

        long tiempoInicioTotal = System.currentTimeMillis();
        int contadorPaso = 1;

        // Se usa this.listPasoReceta para iterar sobre la lista de la clase
        for (PasoReceta paso : this.listPasoReceta) {
            System.out.println("\n---> EJECUTANDO PASO " + contadorPaso + " DE " + this.listPasoReceta.size() + " <---");

            cocinero.ejecutarPasoReceta(paso);
            contadorPaso++;
        }

        long tiempoFinTotal = System.currentTimeMillis();
        long duracionTotalSegundos = (tiempoFinTotal - tiempoInicioTotal) / 1000;

        System.out.println("\n==================================================");
        System.out.println("=== RECETA " + this.nombreReceta.toUpperCase() + " FINALIZADA CON ÉXITO ===");
        System.out.println("Tiempo total de preparación: " + duracionTotalSegundos + " segundos.");
        System.out.println("==================================================");
    }
} //