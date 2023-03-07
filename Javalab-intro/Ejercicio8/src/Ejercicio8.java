/*
 * author: @rubenangber
 */

import static com.coti.tools.Esdia.*;

public class Ejercicio8 {
    public static void main(String[] args) {
        float pesoT = readFloat("Introduzca peso de Tom >> ");
        float alturaT = readFloat("Introduzca altura de Tom >> ");
        float pesoD = readFloat("Introduzca peso de Dick >> ");
        float alturaD = readFloat("Introduzca altura de Dick >> ");
        float pesoH = readFloat("Introduzca peso de Harry >> ");
        float alturaH = readFloat("Introduzca altura de Harry >> "); 
    
        if(pesoT > pesoD && pesoT > pesoH) {
            System.out.println("Tom es el que mas pesa");
        } else if(pesoD > pesoT && pesoD > pesoH) {
            System.out.println("Dick es el que mas pesa");
        } else if(pesoH > pesoT && pesoH > pesoD) {
            System.out.println("Harry es el que mas pesa");
        }

        if(alturaT > alturaD && alturaT > alturaH) {
            System.out.println("Tom es el mas alto");
        } else if(alturaD > alturaT && alturaD > alturaH) {
            System.out.println("Dick es el mas alto");
        } else if(alturaH > alturaT && alturaH > alturaD) {
            System.out.println("Harry es el mas alto");
        }
    }
}
