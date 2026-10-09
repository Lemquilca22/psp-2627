package actividad1.modelo;

import java.util.ArrayList;
import java.util.List;

public class Recipiente {
    private String nombreRecipiente;
    private EstadoRecipiente estado;
    private List<Ingrediente> listIngrediente;

    public Recipiente(String nombre) {
        this.nombreRecipiente = nombre;
        this.estado = EstadoRecipiente.VACIO;
        this.listIngrediente = new ArrayList<>();
    }

    public String getNombrerecipiente() {
        return nombreRecipiente;
    }

    public void setNombrerecipiente(String nombrerecipiente) {
        this.nombreRecipiente = nombrerecipiente;
    }

    public EstadoRecipiente getEstado() {
        return estado;
    }

    public void setEstado(EstadoRecipiente estado) {
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
