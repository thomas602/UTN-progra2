package programacion.pkg2.utn;

import java.util.Objects;

public class Producto {
    private String id;                     // Identificador único
    private String nombre;                 // Nombre del producto
    private double precio;                 // Precio del producto
    private int cantidad;                  // Cantidad en stock
    private CategoriaProducto categoria;   // Categoría del producto

    public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("El id no puede ser nulo o vacío.");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        if (precio < 0) throw new IllegalArgumentException("El precio no puede ser negativo.");
        if (cantidad < 0) throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        if (categoria == null) throw new IllegalArgumentException("La categoría no puede ser nula.");

        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public CategoriaProducto getCategoria() { return categoria; }

    // Setters con validaciones básicas
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        if (precio < 0) throw new IllegalArgumentException("El precio no puede ser negativo.");
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        this.cantidad = cantidad;
    }

    public void setCategoria(CategoriaProducto categoria) {
        if (categoria == null) throw new IllegalArgumentException("La categoría no puede ser nula.");
        this.categoria = categoria;
    }

    // Muestra la información del producto en consola
    public void mostrarInfo() {
        System.out.println("--------------------------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.printf("Precio: $%.2f%n", precio);
        System.out.println("Cantidad en stock: " + cantidad);
        System.out.println("Categoría: " + categoria + " (" + categoria.getDescripcion() + ")");
        System.out.println("--------------------------------------------------");
    }

    // Igualdad basada en ID (identificador único)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return id.equals(producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
