public class EmpaqueDecorator extends ProductoDecorador {
    private double cargo;

    public EmpaqueDecorator(Producto componente, double cargo) {
        super(componente);
        this.cargo = cargo;
    }

    @Override
    public double calcularPrecio() {
        return componente.calcularPrecio() + cargo;
    }
}
