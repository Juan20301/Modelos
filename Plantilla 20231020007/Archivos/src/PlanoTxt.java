import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class PlanoTxt extends Archivo {
    Scanner sc = new Scanner(System.in);

    public void crear() {
        System.out.println("nombre del archivo:");
        String nombreArchivo = sc.nextLine();
        try {
            File archivo = new File(nombreArchivo);
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo.");
            e.printStackTrace();
        }
    }

    @Override
    public void borrar() {
        System.out.println("Ingrese el nombre del archivo a borrar:");
        String nombreArchivo = sc.nextLine();
        File archivo = new File(nombreArchivo);
        if (archivo.delete()) {
            System.out.println("Archivo borrado: " + nombreArchivo);
        } else {
            System.out.println("No se pudo borrar el archivo o no existe.");
        }
    
    }

    @Override
    public void escribir() {
        System.out.println("Ingrese el contenido a guardar en el archivo:");
        String contenido = sc.nextLine();
        guardar(contenido);
    }

    @Override
    public void guardar(String contenido) {
        System.out.println("Ingrese el nombre del archivo para guardar contenido:");
        String nombreArchivo = sc.nextLine();
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            try (FileWriter writer = new FileWriter(archivo, true)) {
                writer.write(contenido);
                writer.write(System.lineSeparator());
                System.out.println("Contenido guardado en el archivo.");
            } catch (IOException e) {
                System.out.println("Ocurrió un error al guardar en el archivo.");
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    @Override
    public void accionAdicional() {
        System.out.println("no se puede mostrar buscar en los archivos disponibles.");
    }

}

        
    
