package actividad1.modelo;

public class main {
    public static void main(String[] args) {
        Cocinero cocinero = new Cocinero("Lem");

        //Recipientes
        Recipiente olla = new Recipiente("Olla para pasta");
        Recipiente sarten = new Recipiente("Sartén grande");
        Recipiente plato = new Recipiente("Plato hondo");

        //Ingredientes
        Ingrediente agua = new Ingrediente("Agua", 2, "litros");
        Ingrediente sal = new Ingrediente("Sal", 10, "gramos");
        Ingrediente espaguetis = new Ingrediente("Espaguetis", 250, "gramos");
        Ingrediente aceite = new Ingrediente("Aceite de oliva", 30, "ml");
        Ingrediente cebolla = new Ingrediente("Cebolla picada", 1, "unidad");
        Ingrediente ajo = new Ingrediente("Ajo picado", 2, "dientes");
        Ingrediente carne = new Ingrediente("Carne picada", 300, "gramos");
        Ingrediente tomate = new Ingrediente("Tomate triturado", 400, "gramos");

        //Receta
        Receta boloñesa = new Receta("Espaguetis a la Boloñesa");

        //Configurar y añadir cada PasoReceta en orden estricto
        PasoReceta paso1 = new PasoReceta("Poner agua a hervir", olla, 4);
        paso1.agregarIngrediente(agua);
        paso1.agregarIngrediente(sal);
        boloñesa.agregarPaso(paso1);

        PasoReceta paso2 = new PasoReceta("Cocer los espaguetis", olla, 6);
        paso2.agregarIngrediente(espaguetis);
        boloñesa.agregarPaso(paso2);

        PasoReceta paso3 = new PasoReceta("Sofreír cebolla y ajo", sarten, 3);
        paso3.agregarIngrediente(aceite);
        paso3.agregarIngrediente(cebolla);
        paso3.agregarIngrediente(ajo);
        boloñesa.agregarPaso(paso3);

        PasoReceta paso4 = new PasoReceta("Añadir la carne picada y dorar", sarten, 4);
        paso4.agregarIngrediente(carne);
        boloñesa.agregarPaso(paso4);

        PasoReceta paso5 = new PasoReceta("Añadir el tomate y reducir salsa", sarten, 5);
        paso5.agregarIngrediente(tomate);
        boloñesa.agregarPaso(paso5);

        PasoReceta paso6 = new PasoReceta("Escurrir la pasta", olla, 2);
        boloñesa.agregarPaso(paso6);

        PasoReceta paso7 = new PasoReceta("Mezclar pasta con la salsa", sarten, 3);
        boloñesa.agregarPaso(paso7);

        PasoReceta paso8 = new PasoReceta("Emplatar la pasta", plato, 2);
        boloñesa.agregarPaso(paso8);

        boloñesa.ejecutarReceta(cocinero);
    }

}