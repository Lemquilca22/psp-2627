package modelo;

import java.time.LocalTime;
import java.util.List;

public class Cocinero {
    private String nombre;

    public Cocinero(){}
    public Cocinero(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void ejecutarPasoReceta(PasoReceta paso){
        Recipiente recipiente = paso.getTipoRecipiente();
        recipiente.setEstado("EN USO");
        List<Ingrediente> ingredientesDelPaso = paso.getListIngredientePasoReceta();
        recipiente.agregarIngredientes(ingredientesDelPaso);

        long tiempoInicio = System.currentTimeMillis();
        LocalTime horaInicio = LocalTime.now();

        System.out.println("Hora inicio: " + horaInicio);
        System.out.println("Cocinero " + this.nombre + " -> " + paso.getDescripcionAccion());
        System.out.println("Recipiente utilizado: " + recipiente.getNombrerecipiente() + " [Estado: " + recipiente.getEstado() + "]");

        System.out.println("Ingredientes añadidos en este paso:");
        if(ingredientesDelPaso.isEmpty()){
            System.out.println("Ninguno");
        } else {
            //Utilicé este for ya que de otra manera el programa petaría ya que los ingredientes estan dentro de un arraylsit,
            //que yo sepa el sout por si solo no podría imprimir directamente todo lo que hay en un list, ya que estamos tratando con objetos.
            for (Ingrediente ing : ingredientesDelPaso){
                System.out.println(" - "+ing.getNombreIngrediente()+": "+ing.getCantidad()+" "+ing.getUnidadMedida());
            }
        }
        System.out.println("Contenido total acumulado en " + recipiente.getNombrerecipiente() + ":");
        for (Ingrediente ing : recipiente.getListIngrediente()) {
            System.out.println("  * " + ing.getNombreIngrediente());
        }
        //Aquí se imprime la cantidad de segundos que se le asigno a este paso de la receta.
        System.out.println("Cocinando durante " + paso.getDuracionSegundos() + " segundo(s)...");

        try {
            Thread.sleep(paso.getDuracionSegundos() * 1000L);
        } catch (InterruptedException e) {
            System.out.println("El paso fue interrumpido.");
        }

        recipiente.setEstado("TERMINADO");
        long tiempoFin = System.currentTimeMillis();
        LocalTime horaFin = LocalTime.now();

        System.out.println("Hora fin: " + horaFin);
        System.out.println("Paso completado. Tiempo transcurrido en este paso: " + (tiempoFin - tiempoInicio) + " ms.");
    }
    }

}
