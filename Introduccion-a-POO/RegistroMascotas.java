// Clase Mascota
class Mascota {
    // Atributos privados
    private String nombre;
    private String especie;
    private int edad;
    
    // Constructor
    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad >= 0 ? edad : 0; // Validación para evitar edades negativas
    }
    
    // Método para mostrar información de la mascota
    public void mostrarInfo() {
        System.out.println("=== INFORMACIÓN DE LA MASCOTA ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad + " años");
        
        // Agregar información adicional según la edad
        if (edad == 0) {
            System.out.println("Estado: Recién nacido/a");
        } else if (edad <= 1) {
            System.out.println("Estado: Cachorro/a o muy joven");
        } else if (edad <= 7) {
            System.out.println("Estado: Adulto/a");
        } else {
            System.out.println("Estado: Veterano/a");
        }
        
        System.out.println("=================================");
    }
    
    // Método para simular cumpleaños
    public void cumplirAnios() {
        edad++;
        System.out.println("🎉 ¡Feliz cumpleaños " + nombre + "!");
        System.out.println("Ahora tiene " + edad + " años.");
        
        // Mensajes especiales según la edad
        if (edad == 1) {
            System.out.println("¡Ya no es un bebé!");
        } else if (edad == 5) {
            System.out.println("¡Está en la flor de la vida!");
        } else if (edad == 10) {
            System.out.println("¡Una década de vida!");
        } else if (edad > 15) {
            System.out.println("¡Qué sabiduría debe tener!");
        }
    }
    
    // Método para simular múltiples cumpleaños
    public void cumplirAnios(int anios) {
        if (anios > 0) {
            System.out.println("--- Simulando el paso de " + anios + " años ---");
            for (int i = 0; i < anios; i++) {
                cumplirAnios();
                if (i < anios - 1) {
                    System.out.println(); // Línea en blanco entre cumpleaños
                }
            }
        } else {
            System.out.println("Error: El número de años debe ser positivo.");
        }
    }
    
    // Métodos getter
    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public int getEdad() { return edad; }
    
    // Métodos setter
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEspecie(String especie) { this.especie = especie; }
    public void setEdad(int edad) { 
        this.edad = edad >= 0 ? edad : 0; 
    }
    
    // Método para obtener información como String
    public String toString() {
        return nombre + " (" + especie + ", " + edad + " años)";
    }
}

// Clase principal para demostrar la funcionalidad
public class RegistroMascotas {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE REGISTRO DE MASCOTAS ===\n");
        
        // Crear una mascota
        Mascota mascota1 = new Mascota("Buddy", "Perro", 2);
        
        // Mostrar información inicial
        System.out.println("1. INFORMACIÓN INICIAL:");
        mascota1.mostrarInfo();
        
        // Simular un cumpleaños
        System.out.println("\n2. SIMULANDO UN CUMPLEAÑOS:");
        mascota1.cumplirAnios();
        
        // Mostrar información después del cumpleaños
        System.out.println("\nInformación después del cumpleaños:");
        mascota1.mostrarInfo();
        
        // Simular el paso de varios años
        System.out.println("\n3. SIMULANDO EL PASO DE 3 AÑOS:");
        mascota1.cumplirAnios(3);
        
        // Mostrar información final
        System.out.println("\nInformación después de 3 años:");
        mascota1.mostrarInfo();
        
        // Crear más mascotas para demostrar variedad
        System.out.println("\n=== EJEMPLO CON MÚLTIPLES MASCOTAS ===\n");
        
        Mascota mascota2 = new Mascota("Whiskers", "Gato", 0);
        Mascota mascota3 = new Mascota("Goldie", "Pez", 1);
        Mascota mascota4 = new Mascota("Coco", "Loro", 5);
        
        Mascota[] mascotas = {mascota1, mascota2, mascota3, mascota4};
        
        // Mostrar información de todas las mascotas
        System.out.println("REGISTRO COMPLETO DE MASCOTAS:");
        System.out.println("===============================");
        for (int i = 0; i < mascotas.length; i++) {
            System.out.println((i + 1) + ". " + mascotas[i].toString());
        }
        
        System.out.println("\nDETALLE DE CADA MASCOTA:");
        for (Mascota mascota : mascotas) {
            mascota.mostrarInfo();
            System.out.println();
        }
        
        // Simular el paso del tiempo para todas las mascotas
        System.out.println("=== SIMULANDO UN AÑO PARA TODAS LAS MASCOTAS ===\n");
        
        for (int i = 0; i < mascotas.length; i++) {
            System.out.println("Cumpleaños de " + mascotas[i].getNombre() + ":");
            mascotas[i].cumplirAnios();
            System.out.println();
        }
        
        // Mostrar estado final
        System.out.println("ESTADO FINAL DESPUÉS DE UN AÑO:");
        System.out.println("================================");
        for (Mascota mascota : mascotas) {
            System.out.println("• " + mascota.toString());
        }
        
        // Ejemplo de validación
        System.out.println("\n=== PRUEBA DE VALIDACIÓN ===");
        Mascota mascotaTest = new Mascota("Test", "Hamster", -2);
        mascotaTest.mostrarInfo(); // La edad debería ser 0
        
        mascotaTest.cumplirAnios(-1); // Esto debería mostrar error
    }
}