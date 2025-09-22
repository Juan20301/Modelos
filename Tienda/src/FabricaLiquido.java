public class FabricaLiquido implements FabricaTienda {
    @Override
    public Producto crearAseo(String nombre, double precio, int cantidad) {
        return new AseoLiquido(nombre, precio, cantidad);
    }

    @Override
    public Producto crearAlimento(String nombre, double precio, int cantidad) {
        return new AlimentoLiquido(nombre, precio, cantidad);
    }

    @Override
    public Producto crearPapeleria(String nombre, double precio, int cantidad) {
        return new PapeleriaLiquida(nombre, precio, cantidad);
    }
}


