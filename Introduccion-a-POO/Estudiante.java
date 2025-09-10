// Clase Estudiante
class Estudiante {
    // Atributos privados
    private String nombre;
    private String apellido;
    private String curso;
    private double calificacion;
    
    // Constructor
    public Estudiante(String nombre, String apellido, String curso, double calificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.calificacion = calificacion;
    }
    
    // Método para mostrar información del estudiante
    public void mostrarInfo() {
        System.out.println("=== INFORMACIÓN DEL ESTUDIANTE ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Curso: " + curso);
        System.out.println("Calificación: " + calificacion);
        System.out.println("================================");
    }
    
    // Método para subir calificación
    public void subirCalificacion(double puntos) {
        if (puntos > 0) {
            calificacion += puntos;
            System.out.println("Calificación aumentada en " + puntos + " puntos.");
            System.out.println("Nueva calificación: " + calificacion);
        } else {
            System.out.println("Error: Los puntos deben ser positivos.");
        }
    }
    
    // Método para bajar calificación
    public void bajarCalificacion(double puntos) {
        if (puntos > 0) {
            calificacion -= puntos;
            if (calificacion < 0) {
                calificacion = 0; // No permitir calificaciones negativas
            }
            System.out.println("Calificación disminuida en " + puntos + " puntos.");
            System.out.println("Nueva calificación: " + calificacion);
        } else {
            System.out.println("Error: Los puntos deben ser positivos.");
        }
    }
    
    // Métodos getter (opcional, para acceder a los atributos si es necesario)
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getCurso() { return curso; }
    public double getCalificacion() { return calificacion; }
    
    // Métodos setter (opcional, para modificar los atributos si es necesario)
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setCurso(String curso) { this.curso = curso; }
    public void setCalificacion(double calificacion) { this.calificacion = calificacion; }
}