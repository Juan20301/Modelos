public class InfoProducto {
    String nombre;
    int precio;
    String categoria;

    public InfoProducto(String nombre, int precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoProducto producto = (InfoProducto) o;
        return Integer.compare(producto.precio, precio) == 0 &&
                nombre.equals(producto.nombre) &&
                categoria.equals(producto.categoria);
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        long temp = Double.doubleToLongBits(precio);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (categoria != null ? categoria.hashCode() : 0);
        return result;
    }

}
