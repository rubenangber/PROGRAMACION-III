/*
 * author: @rubenangber
 */

import static com.coti.tools.Esdia.*;

public class Ejercicio10 {
    public static void main(String[] args) {
        Fruta f1 = new Fruta(readInt("Introduce cantidad de peras >> "), readFloat("Introduce el precio de las peras >> "));
        Fruta f2 = new Fruta(readInt("Introduce cantidad de manzanas >> "), readFloat("Introduce el precio de las manzanas >> "));

        float precioSinIVAP = f1.precioSinIVA();
        float precioIVAP = f1.precioIVA();
        float precioConIVAP = f1.precioConIVA();

        float precioSinIVAM = f2.precioSinIVA();
        float precioIVAM = f2.precioIVA();
        float precioConIVAM = f2.precioConIVA();

        System.out.printf("\tCantidad\tPrecio\tPrecioSinIVA\tPrecioIVA\tPrecioConIVA\n");
        System.out.printf("Pera\t%d\t\t%.2f\t%.2f\t\t%.2f\t\t%.2f\n", f1.getCantidad(), f1.getPrecio(), precioSinIVAP, precioIVAP, precioConIVAP);
        System.out.printf("Manzana\t%d\t\t%.2f\t%.2f\t\t%.2f\t\t%.2f\n", f2.getCantidad(), f2.getPrecio(), precioSinIVAM, precioIVAM, precioConIVAM);
    }
}
