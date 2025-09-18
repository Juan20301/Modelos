import java.util.Scanner;

public class Director {
    private AbstractTienda builder;

    public void setBuilder(AbstractTienda builder) {
        this.builder = builder;
    }
    
    public Tienda getTienda() {
        int option = 0;
        do { 
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Agregar Producto a inventario");
            System.out.println("2. Realizar Compra");
            System.out.println("3. Listar inventario por Categoría");
            System.out.println("4. Listar Inventario Completo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            option = Integer.parseInt(new Scanner(System.in).nextLine());

            switch (option) {
                case 1 -> {
                    builder.buildAgregarProducto();
                }
                case 2 -> {
                    builder.buildRealizarVenta();
                }
                case 3 -> {
                    builder.buildListarPorCategoria();
                }
                case 4 -> {
                    builder.buildListarInventario();
                }
                case 5 -> System.out.println("Saliendo");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
            
        } while(option != 5);
        return builder.build();
    }
}
