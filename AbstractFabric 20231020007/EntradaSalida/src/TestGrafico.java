
public class TestGrafico {
    public static void main(String[] args) {
        ClienteSuma clienteGrafica = new ClienteSuma(new FabricaGrafica());
        clienteGrafica.sumar();
    }
}


