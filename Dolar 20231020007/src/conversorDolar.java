public class conversorDolar {
    private static final double tasaCambio = 4100;

    public double convertirADolar (double pesos) {
        return pesos / tasaCambio;
    }

    public double convertirAPesos(double dolar) {
        return dolar * tasaCambio;
    }

}
