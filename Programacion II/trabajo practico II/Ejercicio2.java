class Mascota {
    String nombre;
    String especie;
    int edad;

    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public void mostrarInfo() {
        System.out.println("Información de la Mascota:");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Especie: " + this.especie);
        System.out.println("Edad: " + this.edad + " años");
    }

    public void cumplirAnios() {
        this.edad++;
        System.out.println("¡Feliz cumpleaños, " + this.nombre + "! Ahora tiene " + this.edad + " años.");
    }
}

public class Ejercicio2 {
    public static void main(String[] args) {
        Mascota mascota1 = new Mascota("Fido", "Perro", 3);

        System.out.println("--- Estado Inicial ---");
        mascota1.mostrarInfo();

        System.out.println("\n--- Simulación de Cumpleaños ---");
        mascota1.cumplirAnios();

        System.out.println("\n--- Estado Final ---");
        mascota1.mostrarInfo();
    }
}
