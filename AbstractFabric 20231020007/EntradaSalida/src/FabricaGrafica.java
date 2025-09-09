public class FabricaGrafica extends FabricaAbstracta{

    @Override
    public Entrada getEntrada(){
        return new EntradaGrafica();
    }
    @Override
    public Salida getSalida(){
        return new SalidaGrafica();
    }


}
