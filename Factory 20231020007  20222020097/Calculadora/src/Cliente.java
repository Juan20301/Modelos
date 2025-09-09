public class Cliente{
    private FOperacion fabrica;
    
    public Cliente(FOperacion fabrica){
        this.fabrica = fabrica;
    }
    
    public double ejecutarOPeracion(float a, float b){
        Operacion op =  fabrica.crearOperacion(); 
        return op.calcular(a, b);
    }
}
