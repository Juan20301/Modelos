public class dolarAdapter implements Conversor{
    private conversorDolar conversor;

    public dolarAdapter(conversorDolar conversorDolar) {
        this.conversor = conversorDolar;
    }

    @Override
    public double convertirPeso(double cantidad) {
        return conversor.convertirADolar(cantidad);
    }

    @Override 
    public double convertirDolar(double cantidad){
        return conversor.convertirAPesos(cantidad); 
    }

}
