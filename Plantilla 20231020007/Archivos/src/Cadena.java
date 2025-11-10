import java.util.Scanner;

public class Cadena extends Archivo {
    private String[] cadena;
    Scanner sc = new Scanner(System.in);

    @Override
    public void crear() {
        this.cadena = null;
    }

    @Override
    public void borrar() {
        this.cadena = null;
    }

    @Override
    public void guardar(String contenido) {
        if (this.cadena == null) {
            this.cadena = new String[]{contenido};
        } else {
            this.cadena[0] = this.cadena[0] + contenido;
        }
    }

    @Override
    public void escribir() {
        System.out.println("Ingrese la cadena a guardar");
        String texto = sc.nextLine();
        guardar(texto);
    }
    
    @Override
    public void accionAdicional(){
        if (cadena != null) {
            System.out.println("Cadena almacenada: " + cadena[0]);
        } else {
            System.out.println("No hay ninguna cadena almacenada.");
        }
    }

}
