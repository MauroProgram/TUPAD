// Clase NaveEspacial para la simulación espacial
class NaveEspacial {
    // Atributos privados
    private String nombre;
    private double combustible;
    private double combustibleMaximo;
    private double distanciaRecorrida;
    private boolean enVuelo;
    private double consumoPorKm;
    private int vuelos;
    
    // Constantes para la simulación
    private static final double COMBUSTIBLE_DESPEGUE = 10.0;
    private static final double CONSUMO_POR_KM_DEFAULT = 2.0;
    private static final double COMBUSTIBLE_MAXIMO_DEFAULT = 100.0;
    
    // Constructor principal
    public NaveEspacial(String nombre, double combustible, double combustibleMaximo) {
        this.nombre = nombre;
        this.combustibleMaximo = combustibleMaximo;
        this.combustible = Math.min(combustible, combustibleMaximo);
        this.distanciaRecorrida = 0.0;
        this.enVuelo = false;
        this.consumoPorKm = CONSUMO_POR_KM_DEFAULT;
        this.vuelos = 0;
        
        System.out.println("🚀 Nave espacial '" + nombre + "' inicializada");
        System.out.println("   Combustible: " + this.combustible + "/" + combustibleMaximo + " unidades");
    }
    
    // Constructor simplificado
    public NaveEspacial(String nombre, double combustible) {
        this(nombre, combustible, COMBUSTIBLE_MAXIMO_DEFAULT);
    }
    
    // Constructor básico
    public NaveEspacial(String nombre) {
        this(nombre, 50.0, COMBUSTIBLE_MAXIMO_DEFAULT);
    }
    
    // === MÉTODOS REQUERIDOS ===
    
    /**
     * Método para despegar la nave
     * @return true si el despegue fue exitoso, false si no
     */
    public boolean despegar() {
        if (enVuelo) {
            System.out.println("⚠️ " + nombre + " ya está en vuelo!");
            return false;
        }
        
        if (combustible < COMBUSTIBLE_DESPEGUE) {
            System.out.println("❌ DESPEGUE FALLIDO: " + nombre + " no tiene suficiente combustible");
            System.out.println("   Requerido: " + COMBUSTIBLE_DESPEGUE + " unidades");
            System.out.println("   Disponible: " + combustible + " unidades");
            return false;
        }
        
        // Despegue exitoso
        combustible -= COMBUSTIBLE_DESPEGUE;
        enVuelo = true;
        vuelos++;
        
        System.out.println("🚀 ¡DESPEGUE EXITOSO! " + nombre + " está ahora en el espacio");
        System.out.println("   Combustible consumido: " + COMBUSTIBLE_DESPEGUE + " unidades");
        System.out.println("   Combustible restante: " + combustible + " unidades");
        System.out.println("   Vuelo número: " + vuelos);
        
        return true;
    }
    
    /**
     * Método para avanzar una distancia determinada
     * @param distancia distancia a recorrer en kilómetros
     * @return true si el avance fue exitoso, false si no
     */
    public boolean avanzar(double distancia) {
        if (distancia <= 0) {
            System.out.println("❌ ERROR: La distancia debe ser positiva");
            return false;
        }
        
        if (!enVuelo) {
            System.out.println("❌ MOVIMIENTO FALLIDO: " + nombre + " debe despegar primero");
            return false;
        }
        
        double combustibleNecesario = distancia * consumoPorKm;
        
        if (combustible < combustibleNecesario) {
            System.out.println("⛽ AVANCE FALLIDO: Combustible insuficiente para " + nombre);
            System.out.println("   Distancia solicitada: " + distancia + " km");
            System.out.println("   Combustible necesario: " + combustibleNecesario + " unidades");
            System.out.println("   Combustible disponible: " + combustible + " unidades");
            
            // Calcular distancia máxima posible
            double distanciaMaxima = combustible / consumoPorKm;
            System.out.println("   Distancia máxima posible: " + String.format("%.2f", distanciaMaxima) + " km");
            
            return false;
        }
        
        // Avance exitoso
        combustible -= combustibleNecesario;
        distanciaRecorrida += distancia;
        
        System.out.println("🌌 " + nombre + " avanzó " + distancia + " km en el espacio");
        System.out.println("   Combustible consumido: " + combustibleNecesario + " unidades");
        System.out.println("   Combustible restante: " + combustible + " unidades");
        System.out.println("   Distancia total recorrida: " + distanciaRecorrida + " km");
        
        // Mensajes especiales para distancias importantes
        if (distanciaRecorrida >= 1000 && distanciaRecorrida - distancia < 1000) {
            System.out.println("   🎉 ¡Milestone: Más de 1000 km recorridos!");
        } else if (distanciaRecorrida >= 10000 && distanciaRecorrida - distancia < 10000) {
            System.out.println("   👑 ¡Épico: Más de 10,000 km recorridos!");
        }
        
        return true;
    }
    
    /**
     * Método para recargar combustible
     * @param cantidad cantidad de combustible a agregar
     * @return true si la recarga fue exitosa, false si no
     */
    public boolean recargarCombustible(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("❌ ERROR: La cantidad de combustible debe ser positiva");
            return false;
        }
        
        if (enVuelo) {
            System.out.println("⚠️ RECARGA EN VUELO: " + nombre + " está recargando en una estación espacial");
        }
        
        double combustibleAnterior = combustible;
        double espacioDisponible = combustibleMaximo - combustible;
        
        if (cantidad > espacioDisponible) {
            System.out.println("⚠️ RECARGA PARCIAL: No se puede recargar toda la cantidad solicitada");
            System.out.println("   Cantidad solicitada: " + cantidad + " unidades");
            System.out.println("   Espacio disponible: " + espacioDisponible + " unidades");
            
            combustible = combustibleMaximo;
            System.out.println("   Tanque llenado al máximo: " + combustible + "/" + combustibleMaximo);
            
            return espacioDisponible > 0; // True si se recargó algo
        }
        
        // Recarga exitosa completa
        combustible += cantidad;
        
        System.out.println("⛽ RECARGA EXITOSA: " + nombre + " recargó combustible");
        System.out.println("   Cantidad agregada: " + cantidad + " unidades");
        System.out.println("   Anterior: " + combustibleAnterior + " → Actual: " + combustible);
        System.out.println("   Capacidad: " + combustible + "/" + combustibleMaximo + " (" + 
                           String.format("%.1f", (combustible/combustibleMaximo)*100) + "%)");
        
        return true;
    }
    
    /**
     * Método para mostrar el estado actual de la nave
     */
    public void mostrarEstado() {
        System.out.println("=== ESTADO DE LA NAVE ESPACIAL ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Estado: " + (enVuelo ? "🚀 En vuelo" : "🏠 En base"));
        System.out.println("Combustible: " + combustible + "/" + combustibleMaximo + " unidades");
        
        // Barra visual de combustible
        int barras = (int) ((combustible / combustibleMaximo) * 20);
        System.out.print("Nivel: [");
        for (int i = 0; i < 20; i++) {
            if (i < barras) {
                System.out.print("█");
            } else {
                System.out.print("░");
            }
        }
        System.out.println("] " + String.format("%.1f", (combustible/combustibleMaximo)*100) + "%");
        
        System.out.println("Distancia total recorrida: " + distanciaRecorrida + " km");
        System.out.println("Número de vuelos: " + vuelos);
        System.out.println("Consumo por km: " + consumoPorKm + " unidades");
        
        // Cálculos adicionales
        if (combustible > 0) {
            double autonomia = combustible / consumoPorKm;
            System.out.println("Autonomía actual: " + String.format("%.2f", autonomia) + " km");
        }
        
        if (distanciaRecorrida > 0) {
            double eficiencia = distanciaRecorrida / (vuelos * COMBUSTIBLE_DESPEGUE + 
                               (distanciaRecorrida * consumoPorKm));
            System.out.println("Eficiencia: " + String.format("%.2f", eficiencia) + " km/unidad");
        }
        
        System.out.println("=================================");
    }
    
    // === MÉTODOS ADICIONALES ===
    
    /**
     * Método para aterrizar la nave
     */
    public boolean aterrizar() {
        if (!enVuelo) {
            System.out.println("⚠️ " + nombre + " ya está en tierra");
            return false;
        }
        
        enVuelo = false;
        System.out.println("🛬 " + nombre + " aterrizó exitosamente");
        System.out.println("   Combustible restante: " + combustible + " unidades");
        return true;
    }
    
    /**
     * Método para realizar una misión completa
     */
    public void mision(double distanciaMision, String nombreMision) {
        System.out.println("\n🎯 INICIANDO MISIÓN: " + nombreMision);
        System.out.println("Distancia objetivo: " + distanciaMision + " km");
        
        if (despegar()) {
            if (avanzar(distanciaMision)) {
                System.out.println("✅ Misión '" + nombreMision + "' completada exitosamente");
            } else {
                System.out.println("❌ Misión '" + nombreMision + "' fallida por falta de combustible");
            }
            aterrizar();
        } else {
            System.out.println("❌ Misión '" + nombreMision + "' cancelada - no se pudo despegar");
        }
    }
    
    // === GETTERS ===
    public String getNombre() { return nombre; }
    public double getCombustible() { return combustible; }
    public double getCombustibleMaximo() { return combustibleMaximo; }
    public double getDistanciaRecorrida() { return distanciaRecorrida; }
    public boolean isEnVuelo() { return enVuelo; }
    public int getVuelos() { return vuelos; }
    
    // === SETTERS CON VALIDACIÓN ===
    public void setConsumoPorKm(double consumoPorKm) {
        if (consumoPorKm > 0) {
            this.consumoPorKm = consumoPorKm;
            System.out.println("⚙️ Consumo por km actualizado a: " + consumoPorKm);
        }
    }
    
    @Override
    public String toString() {
        return nombre + " (" + String.format("%.1f", combustible) + "/" + combustibleMaximo + 
               " combustible, " + distanciaRecorrida + " km recorridos)";
    }
}

// Clase principal para demostrar la simulación
public class SimulacionNaveEspacial {
    public static void main(String[] args) {
        System.out.println("=== 🚀 SIMULACIÓN DE NAVE ESPACIAL 🚀 ===\n");
        
        // 1. Crear nave con 50 unidades de combustible (según la tarea)
        System.out.println("1. CREANDO NAVE ESPACIAL:");
        System.out.println("------------------------");
        NaveEspacial nave = new NaveEspacial("Apollo-X", 50.0);
        nave.mostrarEstado();
        
        // 2. Intentar avanzar sin despegar primero
        System.out.println("\n2. INTENTO DE AVANZAR SIN DESPEGAR:");
        System.out.println("----------------------------------");
        nave.avanzar(100); // Esto debería fallar
        
        // 3. Despegar
        System.out.println("\n3. DESPEGANDO:");
        System.out.println("--------------");
        nave.despegar();
        nave.mostrarEstado();
        
        // 4. Intentar avanzar una distancia que requiera más combustible del disponible
        System.out.println("\n4. INTENTO DE AVANZAR SIN SUFICIENTE COMBUSTIBLE:");
        System.out.println("------------------------------------------------");
        nave.avanzar(50); // Esto podría fallar dependiendo del consumo
        
        // 5. Recargar combustible
        System.out.println("\n5. RECARGANDO COMBUSTIBLE:");
        System.out.println("-------------------------");
        nave.recargarCombustible(30);
        nave.mostrarEstado();
        
        // 6. Avanzar correctamente después de recargar
        System.out.println("\n6. AVANZANDO DESPUÉS DE RECARGAR:");
        System.out.println("---------------------------------");
        nave.avanzar(25); // Esto debería funcionar
        nave.mostrarEstado();
        
        // 7. Intentar sobrecargar el tanque
        System.out.println("\n7. INTENTO DE SOBRECARGA:");
        System.out.println("------------------------");
        nave.recargarCombustible(100); // Esto debería dar advertencia
        
        // 8. Simulación adicional completa
        System.out.println("\n8. SIMULACIÓN COMPLETA:");
        System.out.println("======================");
        
        // Aterrizar primera nave
        nave.aterrizar();
        
        // Crear nueva nave para demostración completa
        NaveEspacial nave2 = new NaveEspacial("Enterprise", 75.0, 120.0);
        
        // Misión 1: Exploración cercana
        nave2.mision(30, "Exploración Lunar");
        
        // Recargar para misión más larga
        nave2.recargarCombustible(40);
        
        // Misión 2: Viaje largo
        nave2.mision(80, "Exploración Marciana");
        
        // 9. Comparación de naves
        System.out.println("\n9. ESTADO FINAL DE TODAS LAS NAVES:");
        System.out.println("===================================");
        
        NaveEspacial[] flota = {nave, nave2};
        double totalDistancia = 0;
        double totalCombustibleUsado = 0;
        
        for (int i = 0; i < flota.length; i++) {
            System.out.println("NAVE " + (i + 1) + ":");
            flota[i].mostrarEstado();
            totalDistancia += flota[i].getDistanciaRecorrida();
            totalCombustibleUsado += (flota[i].getCombustibleMaximo() - flota[i].getCombustible());
            System.out.println();
        }
        
        // 10. Estadísticas finales
        System.out.println("📊 ESTADÍSTICAS DE LA FLOTA:");
        System.out.println("============================");
        System.out.println("Naves en la flota: " + flota.length);
        System.out.println("Distancia total recorrida: " + totalDistancia + " km");
        System.out.println("Combustible total consumido: " + totalCombustibleUsado + " unidades");
        System.out.println("Promedio de distancia por nave: " + (totalDistancia / flota.length) + " km");
        
        for (NaveEspacial n : flota) {
            System.out.println("• " + n.toString());
        }
        
        System.out.println("\n=== 🎉 FIN DE LA SIMULACIÓN ESPACIAL 🎉 ===");
    }
}