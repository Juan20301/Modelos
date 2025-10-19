public abstract class ProductoDecorador extends Producto {
    protected Producto componente;

    public ProductoDecorador(Producto componente) {
        super(componente.nombre, componente.precio, componente.cantidad, componente.descuento);
        this.componente = componente;
    }

    @Override
    public void otroDato() {
        componente.otroDato();
    }

    @Override
    public double calcularPrecio() {
        return componente.calcularPrecio();
    }

    public Producto getBaseProducto() {
        Producto actual = componente;
        while (actual instanceof ProductoDecorador) {
            actual = ((ProductoDecorador) actual).componente;
        }
        return actual;
    }
}
