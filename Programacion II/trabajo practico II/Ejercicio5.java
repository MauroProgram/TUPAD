class NaveEspacial {
    String nombre;
    int combustible;
    final int MAX_COMBUSTIBLE = 100;

    public NaveEspacial(String nombre, int combustibleInicial) {
        this.nombre = nombre;
        this.combustible = Math.min(combustibleInicial, MAX_COMBUSTIBLE);
    }

    public void despegar() {
        if (combustible >= 20) {
            combustible -= 20;
            System.out.println("La nave " + nombre + " ha despegado. ¡Rumbo al infinito!");
        } else {
            System.out.println("¡Fallo en el despegue! Combustible insuficiente.");
        }
    }

    public void avanzar(int distancia) {
        int combustibleNecesario = distancia / 2;
        if (this.combustible >= combustibleNecesario) {
            this.combustible -= combustibleNecesario;
            System.out.println("La nave " + this.nombre + " ha avanzado " + distancia + " años luz.");
        } else {
            System.out.println("No se puede avanzar. Combustible insuficiente para " + distancia + " años luz.");
        }
    }

    public void recargarCombustible(int cantidad) {
        int combustiblePrevio = this.combustible;
        this.combustible = Math.min(this.combustible + cantidad, MAX_COMBUSTIBLE);
        int recargado = this.combustible - combustiblePrevio;
        if (recargado < cantidad) {
            System.out.println("Recarga parcial. El tanque está lleno. Se añadieron " + recargado + " unidades.");
        } else {
            System.out.println("Recarga completa. Se añadieron " + cantidad + " unidades de combustible.");
        }
    }

    public void mostrarEstado() {
        System.out.println("--- Estado de la Nave '" + this.nombre + "' ---");
        System.out.println("Combustible actual: " + this.combustible + "/" + MAX_COMBUSTIBLE);
    }
}

public class Ejercicio5 {
    public static void main(String[] args) {
        NaveEspacial halconMilenario = new NaveEspacial("Halcón Milenario", 50);

        System.out.println("--- Estado Inicial ---");
        halconMilenario.mostrarEstado();

        System.out.println("\n--- Intentando avanzar sin recargar (120 años luz) ---");
        halconMilenario.avanzar(120); // Necesita 60, tiene 50 -> Falla
        halconMilenario.mostrarEstado();

        System.out.println("\n--- Recargando combustible (30 unidades) ---");
        halconMilenario.recargarCombustible(30); // 50 + 30 = 80
        halconMilenario.mostrarEstado();

        System.out.println("\n--- Avanzando correctamente (100 años luz) ---");
        halconMilenario.avanzar(100); // Necesita 50, tiene 80 -> OK
        halconMilenario.mostrarEstado();
    }
}
