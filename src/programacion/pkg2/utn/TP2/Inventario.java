package programacion.pkg2.utn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Inventario {
    private final ArrayList<Producto> productos = new ArrayList<>();

    // Agrega un producto si no existe otro con el mismo ID
    public void agregarProducto(Producto p) {
        if (p == null) throw new IllegalArgumentException("El producto no puede ser nulo.");
        if (buscarProductoPorId(p.getId()) != null) {
            System.out.println("Ya existe un producto con el ID: " + p.getId() + ". No se agregará.");
            return;
        }
        productos.add(p);
        System.out.println("Producto agregado: " + p.getNombre() + " (ID: " + p.getId() + ")");
    }

    // Lista todos los productos (llama a mostrarInfo de cada producto)
    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }
        System.out.println("Listado de productos en inventario:");
        productos.forEach(Producto::mostrarInfo);
    }

    // Busca un producto por ID (retorna el Producto o null si no existe)
    public Producto buscarProductoPorId(String id) {
        if (id == null) return null;
        for (Producto p : productos) {
            if (id.equals(p.getId())) {
                return p;
            }
        }
        return null;
    }

    // Elimina un producto por ID (retorna true si lo elimina)
    public boolean eliminarProducto(String id) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            productos.remove(p);
            System.out.println("Producto eliminado: " + p.getNombre() + " (ID: " + p.getId() + ")");
            return true;
        }
        System.out.println("No se encontró producto con ID: " + id);
        return false;
    }

    // Actualiza el stock de un producto por ID (retorna true si actualiza)
    public boolean actualizarStock(String id, int nuevaCantidad) {
        if (nuevaCantidad < 0) {
            System.out.println("La cantidad no puede ser negativa.");
            return false;
        }
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            p.setCantidad(nuevaCantidad);
            System.out.println("Stock actualizado para ID " + id + ": " + nuevaCantidad + " unidades.");
            return true;
        }
        System.out.println("No se encontró producto con ID: " + id);
        return false;
    }

    // Filtra productos por categoría
    public List<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        if (categoria == null) return List.of();
        return productos.stream()
                .filter(p -> p.getCategoria() == categoria)
                .collect(Collectors.toList());
    }

    // Obtiene el total de unidades en stock (suma de cantidades)
    public int obtenerTotalStock() {
        return productos.stream().mapToInt(Producto::getCantidad).sum();
    }

    // Obtiene el producto con mayor stock (o null si no hay productos)
    public Producto obtenerProductoConMayorStock() {
        return productos.stream()
                .max(Comparator.comparingInt(Producto::getCantidad))
                .orElse(null);
    }

    // Filtra productos por rango de precio [min, max]
    public List<Producto> filtrarProductosPorPrecio(double min, double max) {
        double desde = Math.min(min, max);
        double hasta = Math.max(min, max);
        return productos.stream()
                .filter(p -> p.getPrecio() >= desde && p.getPrecio() <= hasta)
                .collect(Collectors.toList());
    }

    // Muestra las categorías disponibles con sus descripciones
    public void mostrarCategoriasDisponibles() {
        System.out.println("Categorías disponibles:");
        for (CategoriaProducto c : CategoriaProducto.values()) {
            System.out.println("- " + c.name() + ": " + c.getDescripcion());
        }
    }
}
