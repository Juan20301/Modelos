public class FabricaTeclado extends FabricaAbstracta {
    @Override
    public Entrada getEntrada(){
        return new EntradaTeclado();
    }
    @Override
    public Salida getSalida(){
        return new SalidaPantalla();
    }
}
