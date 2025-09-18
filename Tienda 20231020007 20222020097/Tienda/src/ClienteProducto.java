public class ClienteProducto {
    FabricaProducto fabrica;
    Producto producto;

    public ClienteProducto(FabricaProducto fabrica) {
        this.fabrica = fabrica;
        this.producto = fabrica.getProducto();
    }



}
