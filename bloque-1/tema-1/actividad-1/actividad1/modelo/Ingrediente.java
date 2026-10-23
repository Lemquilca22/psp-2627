package actividad1.modelo;

public class Ingrediente {
    private String nombreIngrediente;
    private double cantidad;
    private String unidadMedida;

    public Ingrediente(String nombreIngrediente, double cantidad, String unidadMedida) {
        this.nombreIngrediente = nombreIngrediente;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
}
