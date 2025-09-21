package programacion.pkg2.utn;

import java.util.List;

public class CasoPractico1Demo {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        // 1. Crear al menos cinco productos con diferentes categorías y agregarlos al inventario.
        Producto p1 = new Producto("P001", "Arroz 1kg", 1500.0, 40, CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("P002", "Smartphone", 250000.0, 10, CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("P003", "Remera básica", 3500.0, 25, CategoriaProducto.ROPA);
        Producto p4 = new Producto("P004", "Licuadora", 28000.0, 8, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("P005", "Auriculares", 12000.0, 60, CategoriaProducto.ELECTRONICA);
        Producto p6 = new Producto("P006", "Taza cerámica", 1800.0, 100, CategoriaProducto.HOGAR); // extra para el filtro de precio

        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);
        inventario.agregarProducto(p5);
        inventario.agregarProducto(p6);

        // 2. Listar todos los productos mostrando su información y categoría.
        System.out.println("\n2) Listar todos los productos:");
        inventario.listarProductos();

        // 3. Buscar un producto por ID y mostrar su información.
        System.out.println("\n3) Buscar producto por ID 'P003':");
        Producto encontrado = inventario.buscarProductoPorId("P003");
        if (encontrado != null) {
            encontrado.mostrarInfo();
        } else {
            System.out.println("Producto con ID 'P003' no encontrado.");
        }

        // 4. Filtrar y mostrar productos que pertenezcan a una categoría específica.
        System.out.println("\n4) Filtrar por categoría ELECTRONICA:");
        List<Producto> electronica = inventario.filtrarPorCategoria(CategoriaProducto.ELECTRONICA);
        if (electronica.isEmpty()) {
            System.out.println("No hay productos en la categoría indicada.");
        } else {
            electronica.forEach(Producto::mostrarInfo);
        }

        // 5. Eliminar un producto por su ID y listar los productos restantes.
        System.out.println("\n5) Eliminar producto con ID 'P004' y listar restantes:");
        inventario.eliminarProducto("P004");
        inventario.listarProductos();

        // 6. Actualizar el stock de un producto existente.
        System.out.println("\n6) Actualizar stock de 'P002' a 15 unidades:");
        inventario.actualizarStock("P002", 15);
        Producto actualizado = inventario.buscarProductoPorId("P002");
        if (actualizado != null) actualizado.mostrarInfo();

        // 7. Mostrar el total de stock disponible.
        System.out.println("\n7) Total de unidades en stock:");
        System.out.println("Total stock: " + inventario.obtenerTotalStock());

        // 8. Obtener y mostrar el producto con mayor stock.
        System.out.println("\n8) Producto con mayor stock:");
        Producto mayorStock = inventario.obtenerProductoConMayorStock();
        if (mayorStock != null) mayorStock.mostrarInfo();

        // 9. Filtrar productos con precios entre $1000 y $3000.
        System.out.println("\n9) Productos con precio entre $1000 y $3000:");
        List<Producto> rangoPrecio = inventario.filtrarProductosPorPrecio(1000, 3000);
        if (rangoPrecio.isEmpty()) {
            System.out.println("No hay productos en el rango de precio especificado.");
        } else {
            rangoPrecio.forEach(Producto::mostrarInfo);
        }

        // 10. Mostrar las categorías disponibles con sus descripciones.
        System.out.println("\n10) Categorías disponibles:");
        inventario.mostrarCategoriasDisponibles();
    }
}
