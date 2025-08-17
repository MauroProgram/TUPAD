import java.util.Scanner;

public class DescuentoEspecial {

    // Variable global (constante para el descuento especial del 10%)
    static double DESCUENTO_ESPECIAL = 0.10;

    // Método que calcula el descuento usando la variable global
    public static void calcularDescuentoEspecial(double precio) {
        // Variable local dentro del método
        double descuentoAplicado = precio * DESCUENTO_ESPECIAL;
        double precioFinal = precio - descuentoAplicado;

        System.out.println("El descuento especial aplicado es: " + descuentoAplicado);
        System.out.println("El precio final con descuento es: " + precioFinal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();

        calcularDescuentoEspecial(precio);

        sc.close();
    }
}
