package programacion.pkg2.utn;

public class TPEmpleado {
    public static void main(String[] args) {
        // Crear empleados usando ambos constructores
        Empleado emp1 = new Empleado(1, "Ana López", "Gerente", 120000);
        Empleado emp2 = new Empleado("Carlos Díaz", "Analista");
        Empleado emp3 = new Empleado("María Torres", "Desarrollador");

        // Actualizar salarios usando métodos sobrecargados
        emp1.actualizarSalario(10.0); // Aumenta 10% a emp1
        emp2.actualizarSalario(5000); // Aumenta $5000 a emp2
        emp3.actualizarSalario(7.5); // Aumenta 7.5% a emp3

        // Imprimir información de cada empleado
        System.out.println(emp1.toString());
        System.out.println(emp2.toString());
        System.out.println(emp3.toString());

        // Mostrar total de empleados creados
        System.out.println("Total de empleados creados: " + Empleado.mostrarTotalEmpleados());
    }
}
