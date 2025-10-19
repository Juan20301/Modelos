import java.util.Scanner;
public class Ropa extends Producto {
    public Ropa(String nombre, double precio, int cantidad, Descuento descuento) {
        super(nombre, precio, cantidad, descuento);
    }

    @Override
    public void otroDato(){
        System.out.println("Que talla es la ropa?");
        Scanner scanner = new Scanner(System.in);
        this.datoAdicional = scanner.nextLine();
    }

    public String getTalla() {
        return datoAdicional;
    }
    
}
