import java.time.Year;

class Libro {
    private String titulo;
    private String autor;
    private int añoPublicacion;

    public Libro(String titulo, String autor, int añoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.setAñoPublicacion(añoPublicacion); // Usar setter para validación inicial
    }

    // Getters
    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getAñoPublicacion() {
        return this.añoPublicacion;
    }

    // Setter con validación
    public void setAñoPublicacion(int año) {
        if (año > Year.now().getValue()) {
            System.out.println("Error: El año de publicación (" + año + ") no puede ser un año futuro.");
        } else {
            this.añoPublicacion = año;
        }
    }

    public void mostrarInfo() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Año de Publicación: " + getAñoPublicacion());
    }
}

public class Ejercicio3 {
    public static void main(String[] args) {
        Libro libro1 = new Libro("El Principito", "Antoine de Saint-Exupéry", 1943);

        System.out.println("--- Información Inicial del Libro ---");
        libro1.mostrarInfo();

        System.out.println("\n--- Intentando actualizar a un año inválido (2077) ---");
        libro1.setAñoPublicacion(2077);
        System.out.println("Información después del intento de actualización inválida:");
        libro1.mostrarInfo(); // El año no debe cambiar

        System.out.println("\n--- Actualizando a un año válido (1950) ---");
        libro1.setAñoPublicacion(1950);
        System.out.println("Información final del libro:");
        libro1.mostrarInfo(); // El año debe haber cambiado
    }
}
