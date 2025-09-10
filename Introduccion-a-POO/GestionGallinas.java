import java.util.Random;

// Clase Gallina para la granja digital
class Gallina {
    // Atributos privados
    private String idGallina;
    private int edad;
    private int huevosPuestos;
    private boolean activa; // Para determinar si la gallina puede poner huevos
    private static int totalGallinas = 0; // Contador estático de gallinas
    
    // Constructor
    public Gallina(String idGallina, int edad) {
        this.idGallina = idGallina;
        this.edad = edad >= 0 ? edad : 0;
        this.huevosPuestos = 0;
        this.activa = edad >= 5 && edad <= 60; // Gallinas activas entre 5 y 60 meses
        totalGallinas++;
        
        System.out.println("🐔 Nueva gallina registrada: " + idGallina);
    }
    
    // Constructor alternativo (sin edad inicial)
    public Gallina(String idGallina) {
        this(idGallina, 0);
    }
    
    // === MÉTODOS REQUERIDOS ===
    
    /**
     * Método para que la gallina ponga un huevo
     */
    public void ponerHuevo() {
        if (!activa) {
            if (edad < 5) {
                System.out.println("🐣 " + idGallina + " es muy joven para poner huevos (edad: " + edad + " meses)");
            } else {
                System.out.println("😴 " + idGallina + " ya no puede poner huevos (muy mayor: " + edad + " meses)");
            }
            return;
        }
        
        // Simulación realista: probabilidad de poner huevo basada en la edad
        Random random = new Random();
        int probabilidad = calcularProbabilidadHuevo();
        
        if (random.nextInt(100) < probabilidad) {
            huevosPuestos++;
            System.out.println("🥚 ¡" + idGallina + " puso un huevo! Total: " + huevosPuestos + " huevos");
            
            // Mensajes especiales para hitos
            if (huevosPuestos == 1) {
                System.out.println("   🎉 ¡Su primer huevo!");
            } else if (huevosPuestos % 10 == 0) {
                System.out.println("   🌟 ¡Milestone: " + huevosPuestos + " huevos!");
            } else if (huevosPuestos % 50 == 0) {
                System.out.println("   👑 ¡Gallina súper productiva: " + huevosPuestos + " huevos!");
            }
        } else {
            System.out.println("🚫 " + idGallina + " no puso huevo hoy");
        }
    }
    
    /**
     * Método para que la gallina envejezca
     */
    public void envejecer() {
        edad++;
        System.out.println("📅 " + idGallina + " cumplió " + edad + " meses");
        
        // Actualizar estado activo
        boolean anteriormenteActiva = activa;
        activa = edad >= 5 && edad <= 60;
        
        // Mensajes según cambios de estado
        if (!anteriormenteActiva && activa) {
            System.out.println("   🎂 ¡" + idGallina + " ya puede empezar a poner huevos!");
        } else if (anteriormenteActiva && !activa && edad > 60) {
            System.out.println("   🌅 " + idGallina + " se retiró de la producción (jubilada)");
        }
        
        // Mensajes especiales por edad
        if (edad == 12) {
            System.out.println("   🎈 ¡" + idGallina + " cumplió su primer año!");
        } else if (edad == 24) {
            System.out.println("   🎊 ¡" + idGallina + " cumplió 2 años!");
        } else if (edad >= 36 && edad % 12 == 0) {
            System.out.println("   🎁 ¡" + idGallina + " cumplió " + (edad/12) + " años!");
        }
    }
    
    /**
     * Método para mostrar el estado actual de la gallina
     */
    public void mostrarEstado() {
        System.out.println("=== ESTADO DE LA GALLINA ===");
        System.out.println("ID: " + idGallina);
        System.out.println("Edad: " + edad + " meses (" + String.format("%.1f", edad/12.0) + " años)");
        System.out.println("Huevos puestos: " + huevosPuestos);
        System.out.println("Estado: " + getEstadoDescriptivo());
        System.out.println("Productividad promedio: " + calcularProductividadPromedio() + " huevos/mes");
        System.out.println("Clasificación: " + getClasificacionProductividad());
        System.out.println("===========================");
    }
    
    // === MÉTODOS AUXILIARES ===
    
    /**
     * Calcula la probabilidad de poner huevo según la edad
     */
    private int calcularProbabilidadHuevo() {
        if (edad < 5 || edad > 60) return 0;
        if (edad >= 12 && edad <= 36) return 85; // Edad óptima
        if (edad >= 8 && edad <= 48) return 70;  // Edad buena
        return 50; // Edad menos productiva pero aún activa
    }
    
    /**
     * Obtiene descripción del estado actual
     */
    private String getEstadoDescriptivo() {
        if (edad < 5) return "Pollita joven (no productiva)";
        if (edad <= 12) return "Gallina joven (productiva)";
        if (edad <= 36) return "Gallina adulta (muy productiva)";
        if (edad <= 60) return "Gallina madura (productiva)";
        return "Gallina jubilada (no productiva)";
    }
    
    /**
     * Calcula productividad promedio por mes
     */
    private double calcularProductividadPromedio() {
        if (edad == 0) return 0.0;
        return (double) huevosPuestos / edad;
    }
    
    /**
     * Clasifica la productividad de la gallina
     */
    private String getClasificacionProductividad() {
        double promedio = calcularProductividadPromedio();
        if (promedio >= 0.8) return "⭐⭐⭐ Excepcional";
        if (promedio >= 0.6) return "⭐⭐ Muy buena";
        if (promedio >= 0.4) return "⭐ Promedio";
        if (promedio > 0) return "📈 En desarrollo";
        return "🐣 Sin producción";
    }
    
    // === MÉTODOS ADICIONALES PARA SIMULACIÓN ===
    
    /**
     * Simula múltiples días de actividad
     */
    public void simularDias(int dias) {
        System.out.println("\n--- Simulando " + dias + " días para " + idGallina + " ---");
        for (int dia = 1; dia <= dias; dia++) {
            System.out.println("Día " + dia + ":");
            ponerHuevo();
            if (dia % 30 == 0) { // Envejecer cada 30 días (aproximadamente un mes)
                envejecer();
            }
        }
    }
    
    /**
     * Simula múltiples meses de envejecimiento
     */
    public void simularMeses(int meses) {
        System.out.println("\n--- Simulando " + meses + " meses para " + idGallina + " ---");
        for (int mes = 1; mes <= meses; mes++) {
            envejecer();
            // Simular algunos días de puesta en el mes
            for (int intentos = 0; intentos < 20; intentos++) {
                ponerHuevo();
            }
        }
    }
    
    // === GETTERS ===
    public String getIdGallina() { return idGallina; }
    public int getEdad() { return edad; }
    public int getHuevosPuestos() { return huevosPuestos; }
    public boolean isActiva() { return activa; }
    public static int getTotalGallinas() { return totalGallinas; }
    
    // === MÉTODO toString ===
    @Override
    public String toString() {
        return idGallina + " (" + edad + " meses, " + huevosPuestos + " huevos)";
    }
}

// Clase principal para demostrar la gestión de gallinas
public class GestionGallinas {
    public static void main(String[] args) {
        System.out.println("=== 🐔 SISTEMA DE GESTIÓN DE GRANJA DIGITAL 🐔 ===\n");
        
        // 1. Crear dos gallinas
        System.out.println("1. CREANDO GALLINAS:");
        System.out.println("-------------------");
        Gallina gallina1 = new Gallina("Pepita", 8);
        Gallina gallina2 = new Gallina("Carmela", 3);
        
        System.out.println("Total de gallinas en la granja: " + Gallina.getTotalGallinas());
        
        // 2. Mostrar estado inicial
        System.out.println("\n2. ESTADO INICIAL:");
        System.out.println("------------------");
        gallina1.mostrarEstado();
        System.out.println();
        gallina2.mostrarEstado();
        
        // 3. Simular acciones básicas
        System.out.println("\n3. SIMULACIÓN BÁSICA:");
        System.out.println("--------------------");
        
        System.out.println("Intentos de poner huevos:");
        gallina1.ponerHuevo(); // Pepita puede poner (8 meses)
        gallina2.ponerHuevo(); // Carmela no puede (3 meses)
        
        System.out.println("\nEnvejecimiento:");
        gallina1.envejecer(); // Pepita: 8 -> 9 meses
        gallina2.envejecer(); // Carmela: 3 -> 4 meses
        gallina2.envejecer(); // Carmela: 4 -> 5 meses (¡puede empezar a poner!)
        
        System.out.println("\nNuevos intentos después de envejecer:");
        gallina1.ponerHuevo();
        gallina2.ponerHuevo(); // Ahora Carmela puede intentar
        
        // 4. Simulación extendida
        System.out.println("\n4. SIMULACIÓN EXTENDIDA:");
        System.out.println("------------------------");
        
        // Simular varios días para ambas gallinas
        gallina1.simularDias(10);
        gallina2.simularDias(15);
        
        // 5. Crear gallina mayor y simular
        System.out.println("\n5. GALLINA VETERANA:");
        System.out.println("--------------------");
        Gallina gallinaVieja = new Gallina("Doña Clotilde", 58);
        gallinaVieja.mostrarEstado();
        gallinaVieja.ponerHuevo();
        gallinaVieja.envejecer(); // Se vuelve muy vieja
        gallinaVieja.ponerHuevo(); // Ya no puede
        
        // 6. Simulación de meses
        System.out.println("\n6. SIMULACIÓN DE VARIOS MESES:");
        System.out.println("------------------------------");
        Gallina gallinaNueva = new Gallina("Isabella", 2);
        gallinaNueva.simularMeses(6); // Simular 6 meses de crecimiento
        
        // 7. Estado final de todas las gallinas
        System.out.println("\n7. ESTADO FINAL DE LA GRANJA:");
        System.out.println("=============================");
        
        Gallina[] granja = {gallina1, gallina2, gallinaVieja, gallinaNueva};
        
        System.out.println("Resumen de la granja:");
        int totalHuevos = 0;
        int gallinasActivas = 0;
        
        for (int i = 0; i < granja.length; i++) {
            Gallina g = granja[i];
            System.out.println("• " + g.toString() + " - " + (g.isActiva() ? "ACTIVA" : "INACTIVA"));
            totalHuevos += g.getHuevosPuestos();
            if (g.isActiva()) gallinasActivas++;
        }
        
        System.out.println("\n📊 ESTADÍSTICAS DE LA GRANJA:");
        System.out.println("Total de gallinas: " + Gallina.getTotalGallinas());
        System.out.println("Gallinas activas: " + gallinasActivas);
        System.out.println("Total de huevos producidos: " + totalHuevos + " 🥚");
        System.out.println("Promedio de huevos por gallina: " + (totalHuevos / (double)Gallina.getTotalGallinas()));
        
        // 8. Estado detallado final
        System.out.println("\n8. ESTADO DETALLADO FINAL:");
        System.out.println("==========================");
        for (Gallina gallina : granja) {
            gallina.mostrarEstado();
            System.out.println();
        }
        
        System.out.println("=== 🎉 FIN DE LA SIMULACIÓN DE GRANJA DIGITAL 🎉 ===");
    }
}