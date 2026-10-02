package modelo;

import java.util.ArrayList;
import java.util.List;

public class PasoReceta {
    private String DescripcionAccion;
    private String tipoRecipiente;
    private List<Ingrediente> listIngredientePasoReceta;
    private int duracionSegundos;

    public PasoReceta(String descripcionAccion, String tipoRecipiente, int duracionSegundos) {
        DescripcionAccion = descripcionAccion;
        this.tipoRecipiente = tipoRecipiente;
        this.listIngredientePasoReceta = new ArrayList<>();
        this.duracionSegundos = duracionSegundos;
    }

    public String getDescripcionAccion() {
        return DescripcionAccion;
    }

    public void setDescripcionAccion(String descripcionAccion) {
        DescripcionAccion = descripcionAccion;
    }

    public String getTipoRecipiente() {
        return tipoRecipiente;
    }

    public void setTipoRecipiente(String tipoRecipiente) {
        this.tipoRecipiente = tipoRecipiente;
    }

    public List<Ingrediente> getIngredientes() {
        return listIngredientePasoReceta;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.listIngredientePasoReceta = ingredientes;
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(int duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }
    public void agregarIngrediente(Ingrediente ingrediente) {
        if (ingrediente != null) {
            this.listIngredientePasoReceta.add(ingrediente);
        }
    }
}
