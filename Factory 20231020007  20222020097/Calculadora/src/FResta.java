public class FResta extends FOperacion{
    @Override
    public Operacion crearOperacion() {
        return new Resta();
    }   
}