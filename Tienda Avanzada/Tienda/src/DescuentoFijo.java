public class DescuentoFijo implements Descuento {
    private double montoFijo;

    public DescuentoFijo(double montoFijo) {
        this.montoFijo = montoFijo;
    }

    @Override
    public double aplicar(double valor) {
        double resultado = valor - montoFijo;
        return resultado;
    }
    


}
