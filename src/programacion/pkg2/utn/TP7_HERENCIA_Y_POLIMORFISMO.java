package programacion.pkg2.utn;

// Ejercicio 1: Vehículos y herencia básica
class Vehiculo {
    protected String marca;
    protected String modelo;

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void mostrarInfo() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo);
    }
}

class Auto extends Vehiculo {
    private int cantidadPuertas;

    public Auto(String marca, String modelo, int cantidadPuertas) {
        super(marca, modelo);
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Puertas: " + cantidadPuertas);
    }
}

// Ejercicio 2: Figuras geométricas y métodos abstractos
abstract class Figura {
    protected String nombre;
    public Figura(String nombre) {
        this.nombre = nombre;
    }
    public abstract double calcularArea();
}

class Circulo extends Figura {
    private double radio;
    public Circulo(double radio) {
        super("Círculo");
        this.radio = radio;
    }
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}

class Rectangulo extends Figura {
    private double ancho, alto;
    public Rectangulo(double ancho, double alto) {
        super("Rectángulo");
        this.ancho = ancho;
        this.alto = alto;
    }
    @Override
    public double calcularArea() {
        return ancho * alto;
    }
}

// Ejercicio 3: Empleados y polimorfismo
abstract class Empleado {
    protected String nombre;
    public Empleado(String nombre) {
        this.nombre = nombre;
    }
    public abstract double calcularSueldo();
}

class EmpleadoPlanta extends Empleado {
    public EmpleadoPlanta(String nombre) {
        super(nombre);
    }
    @Override
    public double calcularSueldo() {
        return 100000;
    }
}

class EmpleadoTemporal extends Empleado {
    public EmpleadoTemporal(String nombre) {
        super(nombre);
    }
    @Override
    public double calcularSueldo() {
        return 70000;
    }
}

// Ejercicio 4: Animales y comportamiento sobrescrito
class Animal {
    protected String nombre;
    public Animal(String nombre) {
        this.nombre = nombre;
    }
    public void hacerSonido() {
        System.out.println("Sonido genérico");
    }
    public void describirAnimal() {
        System.out.println("Animal: " + nombre);
    }
}

class Perro extends Animal {
    public Perro(String nombre) {
        super(nombre);
    }
    @Override
    public void hacerSonido() {
        System.out.println("Guau guau");
    }
}

class Gato extends Animal {
    public Gato(String nombre) {
        super(nombre);
    }
    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }
}

class Vaca extends Animal {
    public Vaca(String nombre) {
        super(nombre);
    }
    @Override
    public void hacerSonido() {
        System.out.println("Muu");
    }
}

// Ejercicio 5: Sistema de pagos con polimorfismo y genéricos
interface Pagable {
    void pagar();
}

class TarjetaCredito implements Pagable {
    public void pagar() {
        System.out.println("Pago realizado con tarjeta de crédito.");
    }
}

class Transferencia implements Pagable {
    public void pagar() {
        System.out.println("Pago realizado por transferencia.");
    }
}

class Efectivo implements Pagable {
    public void pagar() {
        System.out.println("Pago realizado en efectivo.");
    }
}

public class TP4HerenciaPoli {
    public static void main(String[] args) {
        // Ejercicio 1
        System.out.println("--- Ejercicio 1 ---");
        Auto auto = new Auto("Toyota", "Corolla", 4);
        auto.mostrarInfo();

        // Ejercicio 2
        System.out.println("\n--- Ejercicio 2 ---");
        Figura[] figuras = {
            new Circulo(3),
            new Rectangulo(4, 5)
        };
        for (Figura f : figuras) {
            System.out.println(f.nombre + " área: " + f.calcularArea());
        }

        // Ejercicio 3
        System.out.println("\n--- Ejercicio 3 ---");
        Empleado[] empleados = {
            new EmpleadoPlanta("Ana"),
            new EmpleadoTemporal("Luis"),
            new EmpleadoPlanta("Eva")
        };
        for (Empleado e : empleados) {
            System.out.print(e.nombre + " sueldo: " + e.calcularSueldo());
            if (e instanceof EmpleadoPlanta) {
                System.out.println(" (Planta)");
            } else if (e instanceof EmpleadoTemporal) {
                System.out.println(" (Temporal)");
            } else {
                System.out.println();
            }
        }

        // Ejercicio 4
        System.out.println("\n--- Ejercicio 4 ---");
        Animal[] animales = {
            new Perro("Firulais"),
            new Gato("Michi"),
            new Vaca("Lola")
        };
        for (Animal a : animales) {
            a.describirAnimal();
            a.hacerSonido();
        }

        // Ejercicio 5
        System.out.println("\n--- Ejercicio 5 ---");
        Pagable[] medios = {
            new TarjetaCredito(),
            new Transferencia(),
            new Efectivo()
        };
        for (Pagable medio : medios) {
            procesarPago(medio);
        }
    }

    public static void procesarPago(Pagable medio) {
        medio.pagar();
    }
}
