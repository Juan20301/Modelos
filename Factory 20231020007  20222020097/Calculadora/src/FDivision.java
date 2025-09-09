public class FDivision extends FOperacion{
    @Override
    public Operacion crearOperacion() {
        return new Division();
    }   
}