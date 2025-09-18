public class FabricaPapeleria extends FabricaProducto {
    @Override
    public Producto getProducto() {
        return new Papeleria();
    }

}
