/*
 * author: @rubenangber
 */

import static com.coti.tools.Esdia.*;

public class Ejercicio7 {
    public static void main(String[] args) {
        int edadE = readInt("Introduce edad de Eany >> ");
        float alturaE = readFloat("Introduce altura de Eany >> ");
        int edadMe = readInt("Introduce edad de Meany >> ");
        float alturaMe = readFloat("Introduce altura de Meany >> ");
        int edadMo = readInt("Introduce edad de Moe >> ");
        float alturaMo = readFloat("Introduce altura de Moe >> ");
    
        System.out.printf("\tEany\tMeany\tMoe\n");
        System.out.printf("Edad\t%d\t%d\t%d\n", edadE, edadMe, edadMo);
        System.out.printf("Altura\t%.2f\t%.2f\t%.2f\n", alturaE, alturaMe, alturaMo);
    }
}
