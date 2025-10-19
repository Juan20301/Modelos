import java.util.Scanner;
public class Electronico extends Producto {
    public Electronico(String nombre, double precio, int cantidad, Descuento descuento) {
        super(nombre, precio, cantidad, descuento);
    }


    @Override
    public void otroDato() {
        System.out.println("¿que garantia tiene el producto?");
        Scanner scanner = new Scanner(System.in);
        this.datoAdicional = scanner.nextLine();
    }

    public String getGarantia() {
        return datoAdicional;
    }


}
