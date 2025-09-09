public class FabricaArchivo extends FabricaAbstracta {
    
    @Override
    public Entrada getEntrada() {
        return new EntradaArchivo();
    }

    @Override
    public Salida getSalida() {
        return new SalidaArchivo();
    }

}
