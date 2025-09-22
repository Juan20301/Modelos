
public abstract class ProductoBase implements Producto {
    protected String nombre;
    protected double precio;
    protected String categoria;
    protected String tipo;
    protected int cantidad;

    public ProductoBase(String nombre, double precio, String categoria, String tipo, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public String getNombre() { 
        return nombre; 
    }
    public double getPrecio() { 
        return precio; 
    }
    public String getCategoria() { 
        return categoria; 
    }
    public String getTipo() { 
        return tipo; 
    }
    public int getCantidad() { 
        return cantidad; 
    }

    public void reducirCantidad(int q) {
        if (q <= cantidad) {
            cantidad -= q;
        } else {
            System.out.println("No hay suficiente stock.");
        }
    }
}

