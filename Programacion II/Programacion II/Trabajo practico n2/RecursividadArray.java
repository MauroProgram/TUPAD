public class RecursividadArray {
    
    // Función recursiva para mostrar los precios
    public static void mostrarPrecios(double[] precios, int indice) {
        // Caso base: cuando el índice llega al final del array
        if (indice == precios.length) {
            return;
        }
        
        // Imprimir el precio actual
        System.out.println("Precio: $" + precios[indice]);
        
        // Llamada recursiva al siguiente índice
        mostrarPrecios(precios, indice + 1);
    }

    public static void main(String[] args) {
        // a. Declarar e inicializar el array
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};
        
        // b. Mostrar precios originales con recursión
        System.out.println("Precios originales:");
        mostrarPrecios(precios, 0);
        
        // c. Modificar el precio de un producto específico (índice 2)
        precios[2] = 129.99;
        
        // d. Mostrar precios modificados con recursión
        System.out.println("\nPrecios modificados:");
        mostrarPrecios(precios, 0);
    }
}
