public class ImpuestoDecorator extends ProductoDecorador {
    private double porcentaje;

    public ImpuestoDecorator(Producto componente, double porcentaje) {
        super(componente);
        this.porcentaje = porcentaje;
    }

    @Override
    public double calcularPrecio() {
        double respuesta = componente.calcularPrecio() + componente.calcularPrecio() * porcentaje;
        return respuesta;
    }
}
