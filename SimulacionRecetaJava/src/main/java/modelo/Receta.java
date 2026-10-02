package modelo;

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
}
