import java.util.Scanner;

public class TiendaBarrioBuilder implements AbstractTienda {
    private Tienda tienda;
    private InfoProducto producto;

    public TiendaBarrioBuilder() {
        Scanner scanner = new Scanner(System.in);
        tienda = new Tienda();
    }

    @Override
    public void buildAgregarProducto() {
        int opcion;
        do {
            System.out.println("Seleccione el tipo de producto a agregar:");
            System.out.println("1. Alimento");
            System.out.println("2. Aseo");
            System.out.println("3. Papeleria");
            System.out.println("4. Salir");
            opcion = Integer.parseInt(new Scanner(System.in).nextLine());
            FabricaProducto fabrica =  null;
            switch (opcion) {
                case 1 -> fabrica = new FabricaAlimentos();
                case 2 -> fabrica = new FabricaAseo();
                case 3 -> fabrica = new FabricaPapeleria();

                default -> System.out.println("Opción no válida.");
            }
            if (fabrica != null) {
                ClienteProducto cliente = new ClienteProducto(fabrica);
                this.producto = (InfoProducto)cliente.producto.crear();
                System.out.print("Cantidad a agregar: ");
                int cantidad = Integer.parseInt(new Scanner(System.in).nextLine());
                tienda.agregarProducto(this.producto, cantidad);
            }
        } while (opcion != 4);
    }

    @Override
    public void buildRealizarVenta() {
        boolean opcion = true;
        double totalCompra = 0.0;
        StringBuilder recibo = new StringBuilder("\n=== RECIBO DE COMPRA ===\n");

    do {
        System.out.println("=== Productos disponibles ===");
        System.out.println(tienda.listarInventario());

        System.out.print("Seleccione un producto para comprar: (o 'salir' para terminar): ");
        String nombreProducto = new Scanner(System.in).nextLine();

        if (nombreProducto.equalsIgnoreCase("salir")) {
            opcion = false;
            break;
        }

        
        InfoProducto productoSeleccionado = null;
        for (InfoProducto p : tienda.getInventario().keySet()) {
            if (p.getNombre().equalsIgnoreCase(nombreProducto)) {
                productoSeleccionado = p;
                break;
            }
        }

        if (productoSeleccionado != null) {
            System.out.print("Cantidad a comprar (0 para dejar de comprar): ");
            int cantidad = Integer.parseInt(new Scanner(System.in).nextLine());

            if (cantidad == 0) {
                opcion = false;
                break;
            }

            if (tienda.quitarProducto(productoSeleccionado, cantidad)) {
                double subtotal = productoSeleccionado.getPrecio() * cantidad;
                totalCompra += subtotal;

                recibo.append(productoSeleccionado.getNombre())
                      .append(" x").append(cantidad)
                      .append(" -> $").append(subtotal)
                      .append("\n");

                System.out.println("Venta realizada: " + cantidad + " de " + productoSeleccionado.getNombre());
            } else {
                System.out.println("⚠️ No hay suficiente stock para realizar la venta.");
            }

        } else {
            System.out.println("⚠️ Producto no encontrado en el inventario.");
        }

    } while (opcion);

    // Mostrar recibo final
    if (totalCompra > 0) {
        recibo.append("--------------------------\n")
              .append("TOTAL: $").append(totalCompra)
              .append("\n==========================\n");
        System.out.println(recibo.toString());
    } else {
        System.out.println("No se realizó ninguna compra.");
    }
}

    @Override
    public void buildListarPorCategoria() {
        if (this.producto == null) {
            System.out.println("No hay productos en el inventario.");
            return;
        } else {
            System.out.println("dame la categoria: " );
            Scanner scanner = new Scanner(System.in);
            String categoria = scanner.nextLine();
            System.out.println("=== Productos en la categoría: " + categoria + " ===");
            System.out.println(tienda.listarPorCategoria(categoria));
        }
        
    }
    @Override
    public void buildListarInventario() {
        if (this.producto == null) {
            System.out.println("No hay productos en el inventario.");
            return;
        }else {
            System.out.println("=== Productos disponibles ===");
            System.out.println(tienda.listarInventario());
    }
        }

    @Override
    public void buildGetInventario() {
        tienda.getInventario();
    }


    public Tienda build() {
        return tienda;
    }

}

