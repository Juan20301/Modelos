import java.util.Scanner;
public class Comida extends Producto {
    public Comida(String nombre, double precio, int cantidad, Descuento descuento) {
        super(nombre, precio, cantidad, descuento);
    }


    @Override
    public void otroDato() {
        System.out.println("¿Cual es la fecha de caducidad del producto?");
        Scanner scanner = new Scanner(System.in);
        this.datoAdicional = scanner.nextLine();
    }

    public String getFechaCaducidad() {
        return datoAdicional;
    }

}
