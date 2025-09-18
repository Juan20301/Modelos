import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Tienda {

    private final Map<InfoProducto, Integer> inventario = new HashMap<>();
    public void setInventario(String inventario) {
        
    }

    public void agregarProducto(InfoProducto producto, int cantidad) {
        if (producto == null || cantidad <= 0) return;
        inventario.merge(producto, cantidad, Integer::sum);
        
    }

    public int getCantidad(InfoProducto producto) {
        if (producto == null) return 0;
            return inventario.getOrDefault(producto, 0);
    }

    public boolean quitarProducto(InfoProducto producto, int cantidad) {
        if (producto == null || cantidad <= 0) return false;
        int existente = getCantidad(producto);
        if (existente < cantidad) return false;
        if (existente == cantidad) {
            inventario.remove(producto);
        } else {
            inventario.put(producto, existente - cantidad);
        }
        return true;
    }

    public Map<InfoProducto, Integer> getInventario() {
        return Collections.unmodifiableMap(inventario);
    }

    public Map<InfoProducto,Integer> getProductosPorCategoria(String categoria) {
        Map<InfoProducto,Integer> result = new HashMap<>();
        for (Map.Entry<InfoProducto,Integer> e : inventario.entrySet()) {
            if (e.getKey().getCategoria().equals(categoria)) {
                result.put(e.getKey(), e.getValue());
            }
        }
        return Collections.unmodifiableMap(result);
    }

    public String listarPorCategoria(String categoria) {
        Map<InfoProducto,Integer> map = getProductosPorCategoria(categoria);
        if (map.isEmpty()) return "No hay productos en la categoría: " + categoria;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<InfoProducto,Integer> e : map.entrySet()) {
            sb.append(e.getKey().getNombre())
              .append(" -> cantidad: ")
              .append(e.getValue())
              .append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String listarInventario() {
        if (inventario.isEmpty()) return "Inventario vacío";
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<InfoProducto, Integer> e : inventario.entrySet()) {
            sb.append(e.getKey().getNombre())
              .append(" -> cantidad: ")
              .append(e.getValue())
              .append(System.lineSeparator());
        }
        return sb.toString();
    }


}
