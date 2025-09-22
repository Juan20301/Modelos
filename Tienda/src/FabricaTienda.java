public interface FabricaTienda {
    Producto crearAseo(String nombre, double precio, int cantidad);
    Producto crearAlimento(String nombre, double precio, int cantidad);
    Producto crearPapeleria(String nombre, double precio, int cantidad);
}
