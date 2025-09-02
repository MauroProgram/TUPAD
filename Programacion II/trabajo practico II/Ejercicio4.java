class Gallina {
    int idGallina;
    int edad;
    int huevosPuestos;

    public Gallina(int idGallina) {
        this.idGallina = idGallina;
        this.edad = 0;
        this.huevosPuestos = 0;
    }

    public void ponerHuevo() {
        this.huevosPuestos++;
        System.out.println("Gallina " + this.idGallina + " ha puesto un huevo. Total de huevos: " + this.huevosPuestos);
    }

    public void envejecer() {
        this.edad++;
        System.out.println("Gallina " + this.idGallina + " ha envejecido. Edad actual: " + this.edad + " días.");
    }

    public void mostrarEstado() {
        System.out.println("--- Estado de la Gallina " + this.idGallina + " ---");
        System.out.println("Edad: " + this.edad + " días");
        System.out.println("Huevos puestos: " + this.huevosPuestos);
    }
}

public class Ejercicio4 {
    public static void main(String[] args) {
        Gallina gallina1 = new Gallina(1);
        Gallina gallina2 = new Gallina(2);

        System.out.println("--- Creando dos gallinas ---");
        gallina1.mostrarEstado();
        gallina2.mostrarEstado();

        System.out.println("\n--- Simulando acciones ---");
        gallina1.ponerHuevo();
        gallina1.envejecer();
        gallina2.envejecer();
        gallina1.ponerHuevo();

        System.out.println("\n--- Estado Final ---");
        gallina1.mostrarEstado();
        gallina2.mostrarEstado();
    }
}
