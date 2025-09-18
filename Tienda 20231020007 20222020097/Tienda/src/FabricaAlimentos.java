public class FabricaAlimentos extends FabricaProducto {
    
    @Override
    public Producto getProducto() {
        return new Alimento();
    }

}
