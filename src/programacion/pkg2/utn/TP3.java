package programacion.pkg2.utn;

class Estudiante {
    private String nombre;
    private String apellido;
    private String curso;
    private double calificacion;
    
    public Estudiante(String nombre, String apellido, String curso, double calificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.calificacion = calificacion;
    }
    
    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + " " + apellido);
        System.out.println("Curso: " + curso);
        System.out.println("Calificación: " + calificacion);
    }
    
    public void subirCalificacion(double puntos) {
        calificacion += puntos;
        System.out.println("Calificación aumentada en " + puntos + " puntos.");
    }
    
    public void bajarCalificacion(double puntos) {
        calificacion -= puntos;
        System.out.println("Calificación disminuida en " + puntos + " puntos.");
    }
}

// Ejercicio 2
class Mascota {
    private String nombre;
    private String especie;
    private int edad;
    
    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }
    
    public void mostrarInfo() {
        System.out.println("Mascota: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad + " años");
    }
    
    public void cumplirAnios() {
        edad++;
        System.out.println(nombre + " ha cumplido años. Nueva edad: " + edad);
    }
}

// Ejercicio 3
class Libro {
    private String titulo;
    private String autor;
    private int añoPublicacion;
    
    public Libro(String titulo, String autor, int añoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        setAñoPublicacion(añoPublicacion); // usa el setter con validación
    }
    
    // Getters
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAñoPublicacion() { return añoPublicacion; }
    
    // Setter con validación
    public void setAñoPublicacion(int año) {
        if(año > 0 && año <= 2025) {
            añoPublicacion = año;
        } else {
            System.out.println("Año de publicación inválido: " + año);
        }
    }
    
    public void mostrarInfo() {
        System.out.println("Libro: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año de publicación: " + añoPublicacion);
    }
}

// Ejercicio 4
class Gallina {
    private int idGallina;
    private int edad;
    private int huevosPuestos;
    
    public Gallina(int idGallina, int edad) {
        this.idGallina = idGallina;
        this.edad = edad;
        this.huevosPuestos = 0;
    }
    
    public void ponerHuevo() {
        huevosPuestos++;
        System.out.println("Gallina " + idGallina + " ha puesto un huevo.");
    }
    
    public void envejecer() {
        edad++;
        System.out.println("Gallina " + idGallina + " ha envejecido. Nueva edad: " + edad);
    }
    
    public void mostrarEstado() {
        System.out.println("Gallina ID: " + idGallina);
        System.out.println("Edad: " + edad);
        System.out.println("Huevos puestos: " + huevosPuestos);
    }
}

// Ejercicio 5
class NaveEspacial {
    private String nombre;
    private int combustible;
    private final int LIMITE_COMBUSTIBLE = 100;
    
    public NaveEspacial(String nombre, int combustible) {
        this.nombre = nombre;
        this.combustible = combustible;
    }
    
    public void despegar() {
        if (combustible >= 10) {
            combustible -= 10;
            System.out.println(nombre + " ha despegado. Combustible restante: " + combustible);
        } else {
            System.out.println("No hay suficiente combustible para despegar.");
        }
    }
    
    public void avanzar(int distancia) {
        int consumo = distancia * 2; // cada unidad de distancia consume 2 de combustible
        if (combustible >= consumo) {
            combustible -= consumo;
            System.out.println(nombre + " ha avanzado " + distancia + " unidades. Combustible restante: " + combustible);
        } else {
            System.out.println("No hay suficiente combustible para avanzar " + distancia + " unidades.");
        }
    }
    
    public void recargarCombustible(int cantidad) {
        if (combustible + cantidad > LIMITE_COMBUSTIBLE) {
            System.out.println("No se puede recargar esa cantidad. Límite de combustible: " + LIMITE_COMBUSTIBLE);
        } else {
            combustible += cantidad;
            System.out.println("Combustible recargado en " + cantidad + " unidades. Total: " + combustible);
        }
    }
    
    public void mostrarEstado() {
        System.out.println("Nave Espacial: " + nombre);
        System.out.println("Combustible: " + combustible);
    }
}

public class TP3 {
    public static void main(String[] args) {
        // Ejercicio 1
        System.out.println("--- Registro de Estudiantes ---");
        Estudiante estudiante = new Estudiante("Lucía", "Gómez", "Programación", 8.5);
        estudiante.mostrarInfo();
        estudiante.subirCalificacion(1.2);
        estudiante.bajarCalificacion(0.7);
        estudiante.mostrarInfo();
        
        // Ejercicio 2
        System.out.println("\n--- Registro de Mascotas ---");
        Mascota mascota = new Mascota("Max", "Perro", 5);
        mascota.mostrarInfo();
        mascota.cumplirAnios();
        mascota.mostrarInfo();
        
        // Ejercicio 3
        System.out.println("\n--- Encapsulamiento con la Clase Libro ---");
        Libro libro = new Libro("1984", "George Orwell", 1949);
        libro.mostrarInfo();
        libro.setAñoPublicacion(-2020); // inválido
        libro.setAñoPublicacion(2020); // válido
        libro.mostrarInfo();
        
        // Ejercicio 4
        System.out.println("\n--- Gestión de Gallinas en Granja Digital ---");
        Gallina gallina1 = new Gallina(1, 2);
        Gallina gallina2 = new Gallina(2, 1);
        gallina1.envejecer();
        gallina1.ponerHuevo();
        gallina2.ponerHuevo();
        gallina2.envejecer();
        gallina1.mostrarEstado();
        gallina2.mostrarEstado();
        
        // Ejercicio 5
        System.out.println("\n--- Simulación de Nave Espacial ---");
        NaveEspacial nave = new NaveEspacial("Apolo", 50);
        nave.avanzar(20); // Intenta avanzar sin suficiente combustible
        nave.recargarCombustible(40);
        nave.avanzar(20); // Ahora debería avanzar correctamente
        nave.mostrarEstado();
    }
}
