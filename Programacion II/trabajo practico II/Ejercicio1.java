class Estudiante {
    String nombre;
    String apellido;
    String curso;
    double calificacion;

    public Estudiante(String nombre, String apellido, String curso, double calificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.calificacion = calificacion;
    }

    public void mostrarInfo() {
        System.out.println("Información del Estudiante:");
        System.out.println("Nombre: " + this.nombre + " " + this.apellido);
        System.out.println("Curso: " + this.curso);
        System.out.println("Calificación: " + this.calificacion);
    }

    public void subirCalificacion(double puntos) {
        this.calificacion += puntos;
        System.out.println("La calificación ha sido aumentada en " + puntos + " puntos.");
    }

    public void bajarCalificacion(double puntos) {
        this.calificacion -= puntos;
        System.out.println("La calificación ha sido disminuida en " + puntos + " puntos.");
    }
}

public class Ejercicio1 {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Juan", "Perez", "Programación II", 8.5);

        System.out.println("--- Estado Inicial ---");
        estudiante1.mostrarInfo();

        System.out.println("\n--- Aumentando Calificación ---");
        estudiante1.subirCalificacion(1.0);
        estudiante1.mostrarInfo();

        System.out.println("\n--- Disminuyendo Calificación ---");
        estudiante1.bajarCalificacion(0.5);
        estudiante1.mostrarInfo();
    }
}
