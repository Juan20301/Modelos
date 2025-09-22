import java.util.Scanner;

public class DirectorTienda {
    private AbstractBuilderTienda builder;
    private Scanner sc = new Scanner(System.in);

    public void setBuilderTienda(AbstractBuilderTienda builder) {
        this.builder = builder;
    }

    public Tienda getTienda() {
    int option = 0;
        do{ 
            System.out.println("\tMenu"+"\n 1. Agregar Producto a inventario"+
                                "\n 2. Realizar Compra\n 3. Buscar Producto"+
                                "\n 4. Listar Inventario\n 5. Salir\n");
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1: {
                    builder.buildAgregarProducto();
                    break;
                }
                case 2: {
                    builder.buildVenderProducto();
                    break;
                }
                case 3: {
                    builder.buildBuscarProducto();
                    break;
                }
                case 4: {
                    builder.buildListarInventario();
                    break;
                }
                case 5: {
                    break;
                }
                default: {
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
                }
            }
            
        } while(option != 5);
        return builder.build();
    }
}

