public class DescuentoPorcentaje implements Descuento {
    private double porcentaje;

    public DescuentoPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public double aplicar(double valor) {
        return valor - ((valor * porcentaje) / 100);
    }
}
