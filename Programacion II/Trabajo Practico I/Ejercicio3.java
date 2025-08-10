/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio3;

/*
Escribe un programa que solicite dos números enteros y realice las siguientes
operaciones:
a. Suma
b. Resta
c. Multiplicación
d. División
Muestra los resultados en la consola.
*/
import java.util.Scanner; // Esto va al inicio, fuera de la clase

public class Ejercicio3 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        // Solicitar los números
        System.out.print("Ingrese el primer número entero: ");
        int num1 = input.nextInt();

        System.out.print("Ingrese el segundo número entero: ");
        int num2 = input.nextInt();

        // Operaciones
        int suma = num1 + num2;
        int resta = num1 - num2;
        int multiplicacion = num1 * num2;
        
        // Para la división, verificamos que el divisor no sea 0
        if (num2 != 0) {
            double division = (double) num1 / num2; // Casting para división con decimales
            System.out.println("\nDivisión: " + division);
        } else {
            System.out.println("\nNo se puede dividir entre 0.");
        }

        // Mostrar resultados
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multiplicacion);

        input.close();
    }
}


      
       
    

