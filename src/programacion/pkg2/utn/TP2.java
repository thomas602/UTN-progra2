package programacion.pkg2.utn;
import java.util.Scanner;

public class TP2 {
    // Ejercicio 1: Verificación de Año Bisiesto
    public void Ejercicio1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un año: ");
        int año = sc.nextInt();

        boolean esBisiesto = (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);

        if (esBisiesto) {
            System.out.println("El año " + año + " es bisiesto.");
        } else {
            System.out.println("El año " + año + " no es bisiesto.");
        }
        sc.close();
    }

    // Ejercicio 2: Determinar el mayor de tres números
    public void Ejercicio2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        int num1 = sc.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int num2 = sc.nextInt();
        System.out.print("Ingrese el tercer número: ");
        int num3 = sc.nextInt();

        int mayor = num1;
        if (num2 > mayor) mayor = num2;
        if (num3 > mayor) mayor = num3;

        System.out.println("El mayor es: " + mayor);
        sc.close();
    }

    // Ejercicio 3: Clasificación de Edad
    public void Ejercicio3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su edad: ");
        int edad = sc.nextInt();

        String etapa;
        if (edad < 12) {
            etapa = "Niño";
        } else if (edad <= 17) {
            etapa = "Adolescente";
        } else if (edad <= 59) {
            etapa = "Adulto";
        } else {
            etapa = "Adulto mayor";
        }

        System.out.println("Eres un " + etapa + ".");
        sc.close();
    }

    // Ejercicio 4: Calculadora de Descuento según categoría
    public void Ejercicio4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();
        System.out.print("Ingrese la categoría del producto (A, B o C): ");
        char categoria = sc.next().toUpperCase().charAt(0);

        double descuento = 0;
        switch (categoria) {
            case 'A':
                descuento = 0.10;
                break;
            case 'B':
                descuento = 0.15;
                break;
            case 'C':
                descuento = 0.20;
                break;
            default:
                System.out.println("Categoría inválida.");
                sc.close();
                return;
        }

        double montoDescuento = precio * descuento;
        double precioFinal = precio - montoDescuento;

        System.out.println("Descuento aplicado: " + (int)(descuento * 100) + "%");
        System.out.println("Precio final: " + precioFinal);
        sc.close();
    }

    // Ejercicio 5: Suma de Números Pares (while)
    public void Ejercicio5() {
        Scanner sc = new Scanner(System.in);
        int suma = 0;
        int num;
        do {
            System.out.print("Ingrese un número (0 para terminar): ");
            num = sc.nextInt();
            if (num != 0 && num % 2 == 0) {
                suma += num;
            }
        } while (num != 0);

        System.out.println("La suma de los números pares es: " + suma);
        sc.close();
    }

    // Ejercicio 8: Cálculo del Precio Final con impuesto y descuento
    public double calcularPrecioFinal(double precioBase, double impuesto, double descuento) {
        double precioFinal = precioBase + (precioBase * impuesto) - (precioBase * descuento);
        return precioFinal;
    }

    public void Ejercicio8() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el precio base del producto: ");
        double precioBase = sc.nextDouble();
        System.out.print("Ingrese el impuesto en porcentaje (Ejemplo: 10 para 10%): ");
        double impuestoPorc = sc.nextDouble();
        System.out.print("Ingrese el descuento en porcentaje (Ejemplo: 5 para 5%): ");
        double descuentoPorc = sc.nextDouble();

        double impuesto = impuestoPorc / 100;
        double descuento = descuentoPorc / 100;
        double precioFinal = calcularPrecioFinal(precioBase, impuesto, descuento);

        System.out.println("El precio final del producto es: " + precioFinal);
        sc.close();
    }

    // Ejercicio 9: Composición de funciones para calcular costo de envío y total de compra
    public double calcularCostoEnvio(double peso, String zona) {
        if (zona.equalsIgnoreCase("Nacional")) {
            return peso * 5.0;
        } else if (zona.equalsIgnoreCase("Internacional")) {
            return peso * 10.0;
        } else {
            return -1; // Valor inválido
        }
    }

    public double calcularTotalCompra(double precioProducto, double costoEnvio) {
        return precioProducto + costoEnvio;
    }

    public void Ejercicio9() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el precio del producto: ");
        double precioProducto = sc.nextDouble();
        System.out.print("Ingrese el peso del paquete en kg: ");
        double peso = sc.nextDouble();
        sc.nextLine(); // Limpiar buffer
        System.out.print("Ingrese la zona de envío (Nacional/Internacional): ");
        String zona = sc.nextLine();

        double costoEnvio = calcularCostoEnvio(peso, zona);
        if (costoEnvio == -1) {
            System.out.println("Zona de envío inválida.");
        } else {
            double total = calcularTotalCompra(precioProducto, costoEnvio);
            System.out.println("El costo de envío es: " + costoEnvio);
            System.out.println("El total a pagar es: " + total);
        }
        sc.close();
    }

    // Ejercicio 10: Actualización de stock a partir de venta y recepción de productos
    public int actualizarStock(int stockActual, int cantidadVendida, int cantidadRecibida) {
        return stockActual - cantidadVendida + cantidadRecibida;
    }

    public void Ejercicio10() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el stock actual del producto: ");
        int stockActual = sc.nextInt();
        System.out.print("Ingrese la cantidad vendida: ");
        int cantidadVendida = sc.nextInt();
        System.out.print("Ingrese la cantidad recibida: ");
        int cantidadRecibida = sc.nextInt();

        int nuevoStock = actualizarStock(stockActual, cantidadVendida, cantidadRecibida);
        System.out.println("El nuevo stock del producto es: " + nuevoStock);
        sc.close();
    }

    // Ejercicio 11: Cálculo de descuento especial usando variable global
    private static final double DESCUENTO_ESPECIAL = 0.10; // variable global

    public void calcularDescuentoEspecial(double precio) {
        double descuentoAplicado = precio * DESCUENTO_ESPECIAL;
        double precioFinal = precio - descuentoAplicado;
        System.out.println("El descuento especial aplicado es: " + descuentoAplicado);
        System.out.println("El precio final con descuento es: " + precioFinal);
    }

    public void Ejercicio11() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();

        calcularDescuentoEspecial(precio);
        sc.close();
    }

    // Ejercicio 12: Modificación de un array de precios y visualización de resultados
    public void Ejercicio12() {
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};
        System.out.println("Precios originales:");
        for (double precio : precios) {
            System.out.println("Precio: $" + precio);
        }

        // Modificar el precio del tercer producto (índice 2)
        precios[2] = 129.99;

        System.out.println("Precios modificados:");
        for (double precio : precios) {
            System.out.println("Precio: $" + precio);
        }
    }

    // Ejercicio 13: Impresión recursiva de arrays antes y después de modificar un elemento
    public void imprimirArrayRecursivo(double[] arr, int index) {
        if (index >= arr.length) return;
        System.out.println("Precio: $" + arr[index]);
        imprimirArrayRecursivo(arr, index + 1);
    }

    public void Ejercicio13() {
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};
        System.out.println("Precios originales:");
        imprimirArrayRecursivo(precios, 0);

        // Modificar el precio del tercer producto (índice 2)
        precios[2] = 129.99;

        System.out.println("Precios modificados:");
        imprimirArrayRecursivo(precios, 0);
    }
}