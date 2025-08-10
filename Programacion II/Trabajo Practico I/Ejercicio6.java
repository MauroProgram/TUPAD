package com.mycompany.ejercicio6;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        double a = input.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double b = input.nextDouble();

        if (b != 0) {
            // División con double (mantiene decimales)
            double divisionDouble = a / b;
            System.out.println("División decimal (double): " + divisionDouble);

            // Comparación con división entera usando los mismos valores truncados a int
            int x = (int) a;
            int y = (int) b;

            if (y != 0) {
                int divisionEntera = x / y; // descarta decimales
                System.out.println("División entera (int) con (" + x + " / " + y + "): " + divisionEntera);
            } else {
                System.out.println("No se puede mostrar comparación entera porque el divisor quedó 0 tras el casteo.");
            }
        } else {
            System.out.println("No se puede dividir entre 0.");
        }

        input.close();
    }
}
