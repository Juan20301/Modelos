import javax.swing.JOptionPane;

public class SalidaGrafica extends Salida {
    private JOptionPane jOptionPane;

    public SalidaGrafica() {
        this.jOptionPane = new JOptionPane();
    }
    @Override
    public void enviar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje); 
    }

}
