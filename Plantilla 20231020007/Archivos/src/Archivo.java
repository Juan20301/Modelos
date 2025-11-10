
import java.util.Scanner;

public abstract class Archivo {

    public final void procesarArchivo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese que opcion quiere realizar: crear, escribir, mostrar, borrar");
        String opcion = sc.nextLine();
        switch (opcion) {
            case "crear":
                crear();
                break;
            case "escribir":
                escribir();
                break;
            case "mostrar":
                accionAdicional();
                break;
            case "borrar":
                borrar();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    protected abstract void accionAdicional();
    protected abstract void crear();
    protected abstract void escribir();
    protected abstract void guardar(String contenido);
    protected abstract void borrar();

}
