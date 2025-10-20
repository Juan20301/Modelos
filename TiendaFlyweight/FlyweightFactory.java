import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class FlyweightFactory {
    private static final Map<String, ProductoFlyweight> productos = new HashMap<>();

    public static ProductoFlyweight getProducto(String nombre, double precio, int cantidad) {
        String key = nombre.toLowerCase();
        if (!productos.containsKey(key)) {
            productos.put(key, new ProductoFlyweight(nombre, precio, cantidad));
            System.out.println("Creando nuevo flyweight para: " + nombre);
        } else {
            System.out.println("Reutilizando flyweight existente para: " + nombre);
        }
        return productos.get(key);
    }

    public static Collection<ProductoFlyweight> getInventario() {
        return productos.values();
    }

    public static ProductoFlyweight buscarProducto(String nombre) {
        return productos.get(nombre.toLowerCase());
    }

}