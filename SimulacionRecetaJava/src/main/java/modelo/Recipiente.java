package modelo;

import java.util.ArrayList;
import java.util.List;

public class Recipiente {
    private String nombreRecipiente;
    private String estado;
    private List<Ingrediente> listIngrediente;

    public Recipiente(String recipiente, String estado) {
        this.nombreRecipiente = recipiente;
        this.estado = estado;
        this.listIngrediente = new ArrayList<>();
    }

    public String getNombrerecipiente() {
        return nombreRecipiente;
    }

    public void setNombrerecipiente(String nombrerecipiente) {
        this.nombreRecipiente = nombrerecipiente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Ingrediente> getListIngrediente() {
        return listIngrediente;
    }

    public void setListIngrediente(List<Ingrediente> listIngrediente) {
        this.listIngrediente = listIngrediente;
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        if (ingrediente != null) {
            this.listIngrediente.add(ingrediente);
        }
    }
    public void agregarIngredientes(List<Ingrediente> nuevosIngredientes) {
        if (nuevosIngredientes != null) {
            this.listIngrediente.addAll(nuevosIngredientes);
        }
    }
}
