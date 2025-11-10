import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tipo de archivo desea administrar: \n1.PlanoTxt \n2.MemoriaString \n3.Cadena");
        String opcion = scanner.nextLine();
        switch (opcion) {
            case "1":
                Archivo archivoTxt = new PlanoTxt();
                archivoTxt.procesarArchivo();
                break;
            case "2":
                Archivo memoriaString = new MemoriaString();
                memoriaString.procesarArchivo();
                break;
            case "3":
                Archivo cadena = new Cadena();
                cadena.procesarArchivo();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
