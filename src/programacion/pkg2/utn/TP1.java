package programacion.pkg2.utn;
import java.util.Scanner;

public class TP1 {
    public void Ejercicio2(){
        System.out.println("¡Hola, Java!");
    }
    
    public void Ejercicio3() {
        String nombre = "Juan";
        int edad = 20;
        double altura = 1.75;
        boolean estudiante = true;

        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Altura: " + altura);
        System.out.println("Estudiante: " + estudiante);
    }
    
    public void Ejercicio4() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Por favor, ingresa tu nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Por favor, ingresa tu edad: ");
        int edad = sc.nextInt();

        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);

        sc.close();
    }
    
    public void Ejercicio5() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el primer número entero: ");
        int num1 = sc.nextInt();

        System.out.print("Ingrese el segundo número entero: ");
        int num2 = sc.nextInt();

        int suma = num1 + num2;
        int resta = num1 - num2;
        int multiplicacion = num1 * num2;
        double division = (double) num1 / num2;

        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multiplicacion);
        System.out.println("División: " + division);

        sc.close();
    }
    
    public void Ejercicio6() {
        System.out.println("Nombre: Juan Pérez\nEdad: 30 años\nDirección: \"Calle Falsa 123\"");
    }
    
     public void Ejercicio8() {
        Scanner sc = new Scanner(System.in);

        // División con enteros
        System.out.print("Ingrese el primer número entero: ");
        int numInt1 = sc.nextInt();
        System.out.print("Ingrese el segundo número entero: ");
        int numInt2 = sc.nextInt();

        int resultadoInt = numInt1 / numInt2;
        System.out.println("Resultado de la división (int): " + resultadoInt);

        // División con double
        System.out.print("Ingrese el primer número (double): ");
        double numDouble1 = sc.nextDouble();
        System.out.print("Ingrese el segundo número (double): ");
        double numDouble2 = sc.nextDouble();

        double resultadoDouble = numDouble1 / numDouble2;
        System.out.println("Resultado de la división (double): " + resultadoDouble);

        sc.close();
    }
     
     public void Ejercicio9() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine(); // CORREGIDO
        System.out.println("Hola, " + nombre);
        scanner.close();
    }
}
