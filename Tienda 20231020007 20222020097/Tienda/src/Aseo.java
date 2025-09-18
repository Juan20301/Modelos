import java.util.Scanner;

public class Aseo extends Producto {
    @Override
    public Object crear() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio del producto: ");
        int precio = Integer.parseInt(scanner.nextLine());

        InfoProducto infoProducto = new InfoProducto(nombre, precio, "Aseo");
        return infoProducto;
    }


}
