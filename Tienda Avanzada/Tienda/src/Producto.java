abstract class Producto {
    protected String nombre;
    protected double precio;
    protected int cantidad;
    protected Descuento descuento;
    protected String datoAdicional;


    public Producto(String nombre, double precio, int cantidad, Descuento descuento) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public void otroDato(){
        System.out.println("Otro dato del producto");
        System.out.println("Dato adicional: " + datoAdicional);
    }


    public double calcularPrecio() {
        return descuento.aplicar(precio * cantidad);
    }

    public void addCantidad(int more) {
        this.cantidad += more;
    }

}
