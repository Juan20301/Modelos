import java.util.Scanner;

public class TiendaBarrioBuilder implements AbstractBuilderTienda{
    private Tienda tienda;
    private Scanner sc;

    public TiendaBarrioBuilder() {
        this.tienda = new Tienda();
        this.sc = new Scanner(System.in);
    }

    @Override
    public void buildAgregarProducto() {
        System.out.println("Seleccione el tipo de producto: \n1. Aseo\n2. Alimento\n3. Papelería");
        int opcion = Integer.parseInt(sc.nextLine());
        System.out.println("¿El producto es Líquido o Sólido? \n1. Líquido\n2. Sólido");
        int tipo = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.print("Ingrese la cantidad inicial: ");
        int cantidad = Integer.parseInt(sc.nextLine());
        FabricaTienda fabrica = null;
        if (tipo == 1) {
            fabrica = new FabricaLiquido();
        } else if (tipo == 2) {
            fabrica = new FabricaSolido();
        }
        Producto producto = switch (opcion) {
            case 1 -> fabrica.crearAseo(nombre, precio, cantidad);
            case 2 -> fabrica.crearAlimento(nombre, precio, cantidad);
            case 3 -> fabrica.crearPapeleria(nombre, precio, cantidad);
            default -> null;
        };
        if (producto != null) {
            tienda.agregarProducto(producto);
            System.out.println("Producto registrado en el inventario");
        } else {
            System.out.println("Opción inválida. Producto no registrado.");
        } 
    }

    @Override
    public void buildVenderProducto() {
        tienda.venderProducto();
    }
    
    @Override
    public void buildBuscarProducto() {
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String nombre = sc.nextLine();
        Producto producto = tienda.buscarProducto(nombre);
        if (producto != null) {
            System.out.println("Producto encontrado: " + producto.getNombre() +
                                "\nPrecio: \t$" + producto.getPrecio() +
                                "\nCategoría: \t" + producto.getCategoria() +
                                "\nTipo: \t" + producto.getTipo() +
                                "\nStock: \t" + producto.getCantidad());
        } else {
            System.out.println("Producto no encontrado en el inventario.");
        }
        
        
    }

    @Override
    public void buildListarInventario() {
        tienda.mostrarInventario();
    }

    @Override
    public Tienda build() {
        return tienda;
    }
}
