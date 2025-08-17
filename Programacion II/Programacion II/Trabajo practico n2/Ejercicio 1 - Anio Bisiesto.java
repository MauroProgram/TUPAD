//Ejercicio 1 - Verificación de Año Bisiesto
import java.util.Scanner;

public class VerificacionBisiesto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Solicitar al usuario que ingrese un año
        System.out.print("Ingrese un año: ");
        int anio = sc.nextInt();
        // Verificar si el año es bisiesto
        // Un año es bisiesto si es divisible por 4, excepto los años que son divisibles por 100
        // a menos que también sean divisibles por 400.
        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
            System.out.println("El año " + anio + " es bisiesto.");
        } else {
            System.out.println("El año " + anio + " no es bisiesto.");
        }

        sc.close();
    }
}
