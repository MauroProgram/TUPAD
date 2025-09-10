import java.time.Year;

// Clase Libro con encapsulamiento
class Libro {
    // Atributos privados (encapsulados)
    private String titulo;
    private String autor;
    private int añoPublicacion;
    
    // Constructor
    public Libro(String titulo, String autor, int añoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        // Usar el setter para aplicar validación desde el constructor
        setAñoPublicacion(añoPublicacion);
    }
    
    // === MÉTODOS GETTER (para acceder a los atributos privados) ===
    
    /**
     * Obtiene el título del libro
     * @return titulo del libro
     */
    public String getTitulo() {
        return titulo;
    }
    
    /**
     * Obtiene el autor del libro
     * @return autor del libro
     */
    public String getAutor() {
        return autor;
    }
    
    /**
     * Obtiene el año de publicación del libro
     * @return año de publicación
     */
    public int getAñoPublicacion() {
        return añoPublicacion;
    }
    
    // === MÉTODO SETTER CON VALIDACIÓN ===
    
    /**
     * Establece el año de publicación con validación
     * @param añoPublicacion año a establecer
     * @return true si se estableció correctamente, false si no
     */
    public boolean setAñoPublicacion(int añoPublicacion) {
        // Obtener el año actual
        int añoActual = Year.now().getValue();
        
        // Validaciones
        if (añoPublicacion < 1) {
            System.out.println("❌ ERROR: El año de publicación no puede ser menor a 1.");
            System.out.println("   Valor rechazado: " + añoPublicacion);
            return false;
        }
        
        if (añoPublicacion > añoActual) {
            System.out.println("❌ ERROR: El año de publicación no puede ser mayor al año actual (" + añoActual + ").");
            System.out.println("   Valor rechazado: " + añoPublicacion);
            return false;
        }
        
        // Si pasa todas las validaciones
        this.añoPublicacion = añoPublicacion;
        System.out.println("✅ Año de publicación actualizado correctamente a: " + añoPublicacion);
        return true;
    }
    
    // === MÉTODOS ADICIONALES ===
    
    /**
     * Muestra toda la información del libro
     */
    public void mostrarInfo() {
        System.out.println("=== INFORMACIÓN DEL LIBRO ===");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año de Publicación: " + añoPublicacion);
        System.out.println("Antigüedad: " + calcularAntiguedad() + " años");
        System.out.println("============================");
    }
    
    /**
     * Calcula la antigüedad del libro
     * @return años desde la publicación
     */
    public int calcularAntiguedad() {
        return Year.now().getValue() - añoPublicacion;
    }
    
    /**
     * Representación en String del libro
     */
    @Override
    public String toString() {
        return "\"" + titulo + "\" por " + autor + " (" + añoPublicacion + ")";
    }
    
    // Setters adicionales (sin validación especial, pero manteniendo encapsulamiento)
    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.trim().isEmpty()) {
            this.titulo = titulo;
            System.out.println("✅ Título actualizado a: " + titulo);
        } else {
            System.out.println("❌ ERROR: El título no puede estar vacío.");
        }
    }
    
    public void setAutor(String autor) {
        if (autor != null && !autor.trim().isEmpty()) {
            this.autor = autor;
            System.out.println("✅ Autor actualizado a: " + autor);
        } else {
            System.out.println("❌ ERROR: El autor no puede estar vacío.");
        }
    }
}

// Clase principal para demostrar el encapsulamiento
public class EncapsulamientoLibro {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DE ENCAPSULAMIENTO CON CLASE LIBRO ===\n");
        
        // 1. Crear un libro
        System.out.println("1. CREANDO UN LIBRO:");
        System.out.println("---------------------");
        Libro libro = new Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967);
        libro.mostrarInfo();
        
        // 2. Demostrar que no podemos acceder directamente a los atributos privados
        System.out.println("\n2. ACCESO A ATRIBUTOS PRIVADOS:");
        System.out.println("--------------------------------");
        System.out.println("Los atributos son privados, solo podemos acceder mediante getters:");
        System.out.println("• Título: " + libro.getTitulo());
        System.out.println("• Autor: " + libro.getAutor());
        System.out.println("• Año: " + libro.getAñoPublicacion());
        
        // 3. Intentar modificar con valores inválidos
        System.out.println("\n3. INTENTOS DE MODIFICACIÓN CON VALORES INVÁLIDOS:");
        System.out.println("---------------------------------------------------");
        
        System.out.println("\nIntentando establecer año = -500:");
        libro.setAñoPublicacion(-500);
        
        System.out.println("\nIntentando establecer año = 2030:");
        libro.setAñoPublicacion(2030);
        
        System.out.println("\nIntentando establecer año = 0:");
        libro.setAñoPublicacion(0);
        
        // Verificar que el año no cambió
        System.out.println("\nAño actual del libro después de intentos fallidos: " + libro.getAñoPublicacion());
        
        // 4. Modificar con valores válidos
        System.out.println("\n4. MODIFICACIÓN CON VALORES VÁLIDOS:");
        System.out.println("------------------------------------");
        
        System.out.println("\nIntentando establecer año = 1970:");
        boolean exito = libro.setAñoPublicacion(1970);
        System.out.println("¿Operación exitosa? " + exito);
        
        System.out.println("\nIntentando establecer año = 2020:");
        libro.setAñoPublicacion(2020);
        
        // 5. Mostrar información final
        System.out.println("\n5. INFORMACIÓN FINAL DEL LIBRO:");
        System.out.println("-------------------------------");
        libro.mostrarInfo();
        
        // 6. Demostrar otros setters con validación
        System.out.println("\n6. PRUEBAS ADICIONALES DE VALIDACIÓN:");
        System.out.println("-------------------------------------");
        
        System.out.println("\nIntentando cambiar título a cadena vacía:");
        libro.setTitulo("");
        
        System.out.println("\nCambiando título a valor válido:");
        libro.setTitulo("El Amor en los Tiempos del Cólera");
        
        System.out.println("\nIntentando cambiar autor a null:");
        libro.setAutor(null);
        
        // 7. Crear múltiples libros para demostrar encapsulamiento
        System.out.println("\n7. EJEMPLO CON MÚLTIPLES LIBROS:");
        System.out.println("--------------------------------");
        
        Libro libro1 = new Libro("1984", "George Orwell", 1949);
        Libro libro2 = new Libro("Don Quijote", "Miguel de Cervantes", 1605);
        Libro libro3 = new Libro("El Principito", "Antoine de Saint-Exupéry", 1943);
        
        Libro[] biblioteca = {libro1, libro2, libro3};
        
        System.out.println("\nBiblioteca actual:");
        for (int i = 0; i < biblioteca.length; i++) {
            System.out.println((i + 1) + ". " + biblioteca[i].toString());
        }
        
        // 8. Información final completa
        System.out.println("\n8. ESTADO FINAL:");
        System.out.println("----------------");
        libro.mostrarInfo();
        
        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
        System.out.println("El encapsulamiento protegió la integridad de los datos ✅");
    }
}