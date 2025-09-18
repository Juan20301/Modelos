public class FabricaAseo extends FabricaProducto {

    @Override
    public Producto getProducto() {
        return new Aseo();
    }

}
