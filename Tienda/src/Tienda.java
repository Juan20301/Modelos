import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tienda {
    private List<Producto> productos = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto buscarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public void venderProducto() {
        boolean opcion = true;
        double totalCompra = 0.0;
        StringBuilder recibo = new StringBuilder("\n=== RECIBO DE COMPRA ===\n");
        do {
            System.out.println("\n Productos disponibles ");
            mostrarInventario();
            if (productos.isEmpty()) {
                System.out.println("No hay productos disponibles para la venta.");
                break;
            }
            System.out.print("\nSeleccione un producto para comprar: (o 'salir' para terminar): ");
            String nombreProducto = sc.nextLine();
            if (nombreProducto.equalsIgnoreCase("salir")) {
                opcion = false;
                break;
            }
            System.out.print("Ingrese la cantidad a comprar:  ");
            int cantidadCompra = Integer.parseInt(sc.nextLine());
            Producto producto = buscarProducto(nombreProducto);
            if (producto != null && producto.getCantidad() >= cantidadCompra) {
                double subtotal = producto.getPrecio() * cantidadCompra;
                totalCompra += subtotal;
                recibo.append(producto.getNombre())
                        .append(" x").append(cantidadCompra)
                        .append(" - $").append(subtotal).append("\n");
                ((ProductoBase)producto).reducirCantidad(cantidadCompra);
                System.out.println("Producto agregado al carrito.");
                if (producto.getCantidad() == 0) {
                    productos.remove(producto);
                    System.out.println("El producto se agotó y fue removido del inventario.");
                }
            } else {
                System.out.println("Producto no encontrado o stock insuficiente.");
                break;
            }
        } while (opcion);
        if (totalCompra > 0) {
            System.out.println(recibo.toString());
            System.out.println("\nTotal a pagar: $" + totalCompra);
        } else {
            System.out.println("No se realizaron compras.");
        }
        

    }

    public void mostrarInventario() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto.getCategoria() + "\t" + producto.getTipo() + ":\t " +
                                    producto.getNombre() + " \t$" + producto.getPrecio() +
                                    " | Stock: " + producto.getCantidad());
            }
        }
    }



}
