public class FabricaSolido implements FabricaTienda {
    @Override
    public Producto crearAseo(String nombre, double precio, int cantidad) {
        return new AseoSolido(nombre, precio, cantidad);
    }

    @Override
    public Producto crearAlimento(String nombre, double precio, int cantidad) {
        return new AlimentoSolido(nombre, precio, cantidad);
    }

    @Override
    public Producto crearPapeleria(String nombre, double precio, int cantidad) {
        return new PapeleriaSolida(nombre, precio, cantidad);
    }
}

