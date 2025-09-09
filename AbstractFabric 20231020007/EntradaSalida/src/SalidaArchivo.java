import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SalidaArchivo extends Salida {

    @Override
    public void enviar(String contenido) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("respuesta.txt"))) {
            bw.write(contenido);
        } catch (IOException e) {
            e.printStackTrace(); 
        }String ruta = "respuesta.txt";
        File archivo = new File(ruta);

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write(contenido);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

}
