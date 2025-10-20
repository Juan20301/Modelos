import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;  

class Tienda {
    private final Map<String, List<ProductoContexto>> infoExtra = new HashMap<>();

    public Tienda() {
        // Cargamos productos base (flyweights)
        FlyweightFactory.getProducto("Galletas", 2.5, 100);
        FlyweightFactory.getProducto("Camiseta", 20.0, 50);
        FlyweightFactory.getProducto("Jugo", 3.0, 80);
        FlyweightFactory.getProducto("Pantalon", 35.0, 30);

        // Asociamos contextos (datos extrínsecos)
        agregarContexto("Galletas", new ProductoContexto("Comida", 10, "2025-12-01", null));
        agregarContexto("Camiseta", new ProductoContexto("Ropa", 5, null, "M"));
        agregarContexto("Jugo", new ProductoContexto("Comida", 8, "2025-11-20", null));

        // Pantalones con diferentes tallas (extrínsecos)
        agregarContexto("Pantalon", new ProductoContexto("Ropa", 7, null, "L"));
        agregarContexto("Pantalon", new ProductoContexto("Ropa", 7, null, "M"));
    }

    private void agregarContexto(String nombre, ProductoContexto contexto) {
        String key = nombre.toLowerCase();
        infoExtra.computeIfAbsent(key, k -> new ArrayList<>()).add(contexto);
    }

    public void mostrarInventario() {
        System.out.println("=== INVENTARIO DE LA TIENDA ===");
        for (ProductoFlyweight p : FlyweightFactory.getInventario()) {
            List<ProductoContexto> contextos = infoExtra.get(p.getNombre().toLowerCase());
            if (contextos != null) {
                for (ProductoContexto contexto : contextos) {
                    p.mostrarInfo(contexto);
                }
            }
        }
    }

    public void comprarProducto(Scanner sc) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = sc.nextLine().trim().toLowerCase();
        ProductoFlyweight producto = FlyweightFactory.buscarProducto(nombre);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        List<ProductoContexto> contextos = infoExtra.get(nombre);
    ProductoContexto contextoSeleccionado = null;

    if (contextos == null || contextos.isEmpty()) {
        System.out.println("❌ No hay información extrínseca para este producto.");
        return;
    }

    // Si tiene más de una talla, preguntar cuál quiere
    if (contextos.size() > 1) {
        System.out.println("Tallas disponibles:");
        for (int i = 0; i < contextos.size(); i++) {
            ProductoContexto ctx = contextos.get(i);
            System.out.println((i + 1) + ". Talla: " + ctx.getTalla() + " (Descuento " + ctx.getDescuento() + "%)");
        }

        System.out.print("Seleccione una talla (número): ");
        int seleccion = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        if (seleccion < 1 || seleccion > contextos.size()) {
            System.out.println("❌ Opción inválida.");
            return;
        }
        contextoSeleccionado = contextos.get(seleccion - 1);
    } else {
        contextoSeleccionado = contextos.get(0);
    }

        System.out.print("Ingrese la cantidad que desea comprar: ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        if (cantidad <= 0) {
            System.out.println("Cantidad inválida.");
            return;
        }

        if (producto.getCantidad() >= cantidad) {
            producto.reducirCantidad(cantidad);
            System.out.println("Compra realizada con éxito.");
            System.out.println("Total a pagar: $" + (producto.getPrecio() * cantidad));
            if (producto.getCantidad() == 0) {
                System.out.println("" + producto.getNombre() + " se ha agotado.");
            }
        } else {
            System.out.println("Stock insuficiente. Solo quedan " + producto.getCantidad() + " unidades.");
        }
    }
}
