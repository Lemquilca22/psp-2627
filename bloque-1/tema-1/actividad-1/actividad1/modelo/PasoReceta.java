package actividad1.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasoReceta {
    private String DescripcionAccion;
    private Recipiente tipoRecipiente;
    private List<Ingrediente> listIngredientePasoReceta;
    private int duracionSegundos;

    public PasoReceta(String descripcionAccion, Recipiente tipoRecipiente, Random random, int minSeg, int maxSeg) {
        DescripcionAccion = descripcionAccion;
        this.tipoRecipiente = tipoRecipiente;
        this.duracionSegundos = minSeg + random.nextInt(maxSeg - minSeg + 1);
        this.listIngredientePasoReceta = new ArrayList<>();

    }

    public String getDescripcionAccion() {
        return DescripcionAccion;
    }

    public void setDescripcionAccion(String descripcionAccion) {
        DescripcionAccion = descripcionAccion;
    }

    public Recipiente getTipoRecipiente() {
        return tipoRecipiente;
    }

    public void setTipoRecipiente(Recipiente tipoRecipiente) {
        this.tipoRecipiente = tipoRecipiente;
    }

    public List<Ingrediente> getListIngredientePasoReceta() {
        return listIngredientePasoReceta;
    }

    public void setListIngredientePasoReceta(List<Ingrediente> listIngredientePasoReceta) {
        this.listIngredientePasoReceta = listIngredientePasoReceta;
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
