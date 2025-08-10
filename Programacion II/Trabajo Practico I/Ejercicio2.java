/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio2;
/*
Escribe un programa que solicite al usuario ingresar su nombre y edad, y luego
los muestre en pantalla. Usa Scanner para capturar los datos.
*/
import java.util.Scanner;
public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        
        
        System.out.print("Ingrese su nombre: ");
        String nombre = input.nextLine();
        
        
        System.out.print("Ingrese su edad: ");
        int edad = input.nextInt();
        
        // Mostrar los datos
        System.out.println("\n--- Datos ingresados ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        
        input.close(); 
    }
} 
 
        

    

