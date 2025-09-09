import javax.swing.JOptionPane;

public class EntradaGrafica extends Entrada {
    private String mensaje;
    private JOptionPane jOptionPane;

    public EntradaGrafica() {
        this.mensaje = "Ingrese un número:";
    }
        

    public EntradaGrafica (String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String recibir() {
        String dato = jOptionPane.showInputDialog(null, this.mensaje);
        return dato;
    }

}
