package programacion.pkg2.utn;

public class Empleado {
    private int id;
    private String nombre;
    private String puesto;
    private double salario;
    private static int totalEmpleados = 0;
    private static int ultimoId = 0;

    // Constructor con todos los parámetros
    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        totalEmpleados++;
        if (id > ultimoId) ultimoId = id;
    }

    // Constructor sobrecargado: solo nombre y puesto, id y salario por defecto
    public Empleado(String nombre, String puesto) {
        this.id = ++ultimoId;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = 50000; // salario por defecto
        totalEmpleados++;
    }

    // Método sobrecargado: actualizar salario por porcentaje
    public void actualizarSalario(double porcentajeAumento) {
        this.salario += this.salario * porcentajeAumento / 100.0;
        System.out.println("Salario actualizado por porcentaje para " + nombre + ": " + salario);
    }

    // Método sobrecargado: actualizar salario por cantidad fija
    public void actualizarSalario(int cantidadAumento) {
        this.salario += cantidadAumento;
        System.out.println("Salario actualizado por cantidad para " + nombre + ": " + salario);
    }

    // Método toString()
    @Override
    public String toString() {
        return "Empleado [ID: " + id + ", Nombre: " + nombre + ", Puesto: " + puesto + ", Salario: $" + salario + "]";
    }

    // Método estático para mostrar total de empleados
    public static int mostrarTotalEmpleados() {
        return totalEmpleados;
    }
}
