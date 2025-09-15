/**
 * Trabajo Práctico 4: Programación Orientada a Objetos II
 * Sistema de Gestión de Empleados
 * 
 * Este programa implementa una clase Empleado con constructores sobrecargados,
 * métodos sobrecargados, encapsulamiento y miembros estáticos.
 */

// Clase Empleado
class Empleado {
    // Atributos privados para implementar encapsulamiento
    private int id;
    private String nombre;
    private String puesto;
    private double salario;
    
    // Atributo estático para contar el total de empleados
    private static int totalEmpleados = 0;
    private static int siguienteId = 1;
    
    // Constructor sobrecargado 1: Recibe todos los atributos
    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        totalEmpleados++; // Incrementar contador total
        
        // Actualizar el siguiente ID si es necesario
        if (id >= siguienteId) {
            siguienteId = id + 1;
        }
    }
    
    // Constructor sobrecargado 2: Recibe solo nombre y puesto
    public Empleado(String nombre, String puesto) {
        this.id = siguienteId++; // Asignar ID automático
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = 50000.0; // Salario por defecto
        totalEmpleados++; // Incrementar contador total
    }
    
    // Método sobrecargado 1: Actualizar salario por porcentaje
    public void actualizarSalario(double porcentaje) {
        this.salario = this.salario + (this.salario * porcentaje / 100);
    }
    
    // Método sobrecargado 2: Actualizar salario por cantidad fija
    public void actualizarSalario(int cantidadFija) {
        this.salario = this.salario + cantidadFija;
    }
    
    // Método toString() para representación legible del objeto
    @Override
    public String toString() {
        return String.format("Empleado [ID: %d, Nombre: %s, Puesto: %s, Salario: $%.2f]",
                           this.id, this.nombre, this.puesto, this.salario);
    }
    
    // Método estático para mostrar el total de empleados
    public static int mostrarTotalEmpleados() {
        return totalEmpleados;
    }
    
    // Métodos Getters
    public int getId() {
        return this.id;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public String getPuesto() {
        return this.puesto;
    }
    
    public double getSalario() {
        return this.salario;
    }
    
    // Métodos Setters
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    public void setSalario(double salario) {
        this.salario = salario;
    }
}

// Clase de prueba principal
public class SistemaGestionEmpleados {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE EMPLEADOS ===\n");
        
        // Crear empleados usando el constructor completo
        System.out.println("1. Creando empleados con constructor completo:");
        Empleado emp1 = new Empleado(100, "Ana García", "Desarrolladora Senior", 75000.0);
        Empleado emp2 = new Empleado(101, "Carlos López", "Gerente de Proyecto", 85000.0);
        
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println("Total empleados creados: " + Empleado.mostrarTotalEmpleados());
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Crear empleados usando el constructor simplificado
        System.out.println("2. Creando empleados con constructor simplificado:");
        Empleado emp3 = new Empleado("María Rodríguez", "Analista de Sistemas");
        Empleado emp4 = new Empleado("Juan Martínez", "Diseñador UX");
        
        System.out.println(emp3);
        System.out.println(emp4);
        System.out.println("Total empleados creados: " + Empleado.mostrarTotalEmpleados());
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Aplicar métodos actualizarSalario() sobrecargados
        System.out.println("3. Actualizando salarios:");
        
        // Actualizar por porcentaje
        System.out.println("\nAntes del aumento por porcentaje:");
        System.out.println(emp1);
        emp1.actualizarSalario(15.0); // Aumento del 15%
        System.out.println("Después del aumento del 15%:");
        System.out.println(emp1);
        
        // Actualizar por cantidad fija
        System.out.println("\nAntes del aumento fijo:");
        System.out.println(emp3);
        emp3.actualizarSalario(8000); // Aumento de $8000
        System.out.println("Después del aumento de $8000:");
        System.out.println(emp3);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Mostrar información de todos los empleados
        System.out.println("4. Información completa de todos los empleados:");
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
        System.out.println(emp4);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Demostrar el uso de getters y setters
        System.out.println("5. Demostrando encapsulamiento con getters y setters:");
        System.out.println("Nombre del empleado 2: " + emp2.getNombre());
        System.out.println("Salario del empleado 4: $" + emp4.getSalario());
        
        // Modificar usando setters
        emp2.setPuesto("Director de Tecnología");
        emp4.setSalario(55000.0);
        
        System.out.println("\nDespués de usar setters:");
        System.out.println(emp2);
        System.out.println(emp4);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Mostrar total final de empleados
        System.out.println("6. Resumen final:");
        System.out.println("Total de empleados en el sistema: " + Empleado.mostrarTotalEmpleados());
        
        // Crear un empleado más para verificar el contador
        Empleado emp5 = new Empleado("Laura Fernández", "Tester QA");
        System.out.println("\nNuevo empleado creado:");
        System.out.println(emp5);
        System.out.println("Total actualizado de empleados: " + Empleado.mostrarTotalEmpleados());
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("¡Sistema de gestión de empleados ejecutado correctamente!");
        System.out.println("=".repeat(50));
    }
}