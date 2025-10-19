import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Producto> productos = new ArrayList<>();
        boolean opcion = true;
        Producto producto = null;
        double total = 0;

        while (opcion) {
            System.out.println("\nSeleccione el tipo de producto:");
            System.out.println("1. Electrónico");
            System.out.println("2. Alimentos");
            System.out.println("3. Ropa");
            System.out.println("4. Salir");
            int tipoProducto = sc.nextInt(); 

            if (tipoProducto >= 4) {
                opcion = false;
                break;
            }

            System.out.println("Ingrese el nombre del producto:");
            String nombre = sc.next();
            System.out.println("Ingrese el precio del producto:");
            double precio = sc.nextDouble();
            System.out.println("Ingrese la cantidad del producto:");
            int cantidad = sc.nextInt();
            System.out.println("Seleccione el tipo de descuento:");
            System.out.println("1. Sin descuento");
            System.out.println("2. Descuento por porcentaje");
            System.out.println("3. Descuento fijo");
            int tipoDescuento = sc.nextInt();

            Descuento descuento = null;
            switch (tipoDescuento) {
                case 1:
                    descuento = new NoDescuento();
                    break;
                case 2:
                    System.out.println("Ingrese el porcentaje de descuento:");
                    double porcentaje = sc.nextDouble();
                    descuento = new DescuentoPorcentaje(porcentaje);
                    break;
                case 3:
                    System.out.println("Ingrese el monto de descuento:");
                    double monto = sc.nextDouble();
                    descuento = new DescuentoFijo(monto);
                    break;
                default:
                    System.out.println("Tipo de descuento no válido.");
            }

            if (tipoProducto == 1) {
                producto = new Electronico(nombre, precio, cantidad, descuento);
                producto.otroDato();
            } 
            if (tipoProducto == 2) {
                producto = new Comida(nombre, precio, cantidad, descuento);
                producto.otroDato();
                
            }
            if (tipoProducto == 3) {
                producto = new Ropa(nombre, precio, cantidad, descuento);
                producto.otroDato();
            }

            System.out.println("¿Aplicar impuesto al producto? (s/n): ");
            String aplicarImpuesto = sc.next();
            if (aplicarImpuesto.equalsIgnoreCase("s")) {
                System.out.println("Ingrese porcentaje de impuesto en decimal:");
                double porc = sc.nextDouble();
                producto = new ImpuestoDecorator(producto, porc);
            }

            System.out.println("¿Aplicar empaque con cargo extra? (s/n): ");
            String aplicarEmpaque = sc.next();
            if (aplicarEmpaque.equalsIgnoreCase("s")) {
                System.out.println("Ingrese cargo fijo por empaque:");
                double cargo = sc.nextDouble();
                producto = new EmpaqueDecorator(producto, cargo);
            }
            productos.add(producto);
            total = total + producto.calcularPrecio();
            System.out.print("¿Desea agregar otro producto? (s/n): ");
            String respuesta = sc.next();
            if (respuesta.equalsIgnoreCase("s")) {
                opcion = true;
            } else {
                opcion = false;
            }
        }
        System.out.println("\nProductos ingresados:");
        for (Producto p : productos) {
            System.out.println("\n Nombre: " + p.nombre + ", Precio Final: " + p.calcularPrecio());
            if (p instanceof Electronico) {
                System.out.println("Tipo: Electrónico, Garantía: " + ((Electronico) p).getGarantia());
            } 
            if (p instanceof Comida) {
                System.out.println("Tipo: Alimentos, Fecha de Caducidad: " + ((Comida) p).getFechaCaducidad());
            }
            if (p instanceof Ropa) {
                System.out.println("Tipo: Ropa, Talla: " + ((Ropa) p).getTalla());
            }
        }
        System.out.println("El total de la compra es: " + total);
    }
}
