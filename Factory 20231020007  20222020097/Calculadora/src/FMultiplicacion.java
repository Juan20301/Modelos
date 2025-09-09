public class FMultiplicacion extends FOperacion{
    @Override
    public Operacion crearOperacion() {
        return new Multiplicacion();
    }   
}
