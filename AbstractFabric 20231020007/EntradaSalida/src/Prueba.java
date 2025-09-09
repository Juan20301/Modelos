
public class Prueba {
    public static void main(String[] args) throws Exception {
        int option = 0;
        do {
            SalidaPantalla salidaPantalla = new SalidaPantalla();
            EntradaTeclado entradaTeclado = new EntradaTeclado();
            salidaPantalla.enviar("Selecciona el tipo de entrada/salida: \n1. Teclado/Consola\n2. Archivo\n3. Salir");
            boolean validation = true;
            do {
                try {
                    option = Integer.parseInt(entradaTeclado.recibir());
                    validation = option >= 1 && option <= 4;
                } catch (Exception e) {
                    salidaPantalla.enviar("Valor Invalido");
                    validation = false;
                }
            } while (validation == false);
            switch (option) {
                case 1:
                    ClienteSuma clienteTeclado = new ClienteSuma(new FabricaTeclado());
                    clienteTeclado.sumar();
                    break;
                case 2:
                    ClienteSuma clienteArchivo = new ClienteSuma(new FabricaArchivo());
                    clienteArchivo.sumar();
                    break;
                case 3:
                    salidaPantalla.enviar("Saliendo...");
                    break;
                default:
                    salidaPantalla.enviar("Opción no válida.");
            }
        } while (option != 3);
        

        
    }
}
