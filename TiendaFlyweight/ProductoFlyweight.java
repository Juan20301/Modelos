
class ProductoFlyweight {
    private String nombre;
    private double precio;
    private int cantidad;

    public ProductoFlyweight(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }
    public int getCantidad() {
        return cantidad;
    }
    public double getPrecio() {
        return precio;
    }
    public void reducirCantidad(int cantidadComprada) {
        if (cantidadComprada <= cantidad) {
            cantidad -= cantidadComprada;
        } else {
            System.out.println(" No hay suficiente stock de " + nombre);
        }
    }

    public void mostrarInfo(ProductoContexto extrinseco) {
        System.out.print("Producto: " + nombre + " | ");
        System.out.print("Precio: $" + precio + " | ");
        System.out.print("Cantidad disponible: " + cantidad + " | ");
        System.out.print("Descuento: " + extrinseco.getDescuento() + " | ");

        if (extrinseco.getTipo().equalsIgnoreCase("Comida")) {
            System.out.println("Fecha de caducidad: " + extrinseco.getFechaCaducidad());
        } else if (extrinseco.getTipo().equalsIgnoreCase("Ropa")) {
            System.out.println("Talla: " + extrinseco.getTalla());
        }
        System.out.println("-------------------------");
    }
}