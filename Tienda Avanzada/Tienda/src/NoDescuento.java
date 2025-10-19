public class NoDescuento implements Descuento {

    @Override
    public double aplicar(double valor) {
        return valor;
    }

}
