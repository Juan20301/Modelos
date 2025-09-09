public class ClienteSuma {
    float a, b;
    FabricaAbstracta fabrica;
    Salida salida;
    Entrada entrada;
    Suma suma = new Suma();

    public ClienteSuma(FabricaAbstracta fabrica) {
        this.fabrica = fabrica;
        entrada = fabrica.getEntrada();
        salida = fabrica.getSalida();
    }

    public void sumar(){
        
        if (entrada instanceof EntradaArchivo) {
        String datos = entrada.recibir();
        String[] lineas = datos.split("\\n");
        float num1 = Float.parseFloat(lineas[0].trim());
        float num2 = Float.parseFloat(lineas[1].trim());
        float sumaArchivo = num1 + num2;
        salida.enviar("La suma desde archivo es: " + sumaArchivo);
        }
        else {
            salida.enviar("Proporciona el primer sumando:");
            a = Float.parseFloat(entrada.recibir());
            salida.enviar("Proporciona el segundo sumando:");
            b = Float.parseFloat(entrada.recibir());
            float resultado = suma.operar(a, b);
            salida.enviar("El resultado de la suma es: " + resultado + "\n" );
        }
    }
}
