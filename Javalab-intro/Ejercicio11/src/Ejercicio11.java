/*
 * author: @rubenangber
 */

import static com.coti.tools.Esdia.*;

public class Ejercicio11 {
    public static void main(String[] args) {
        Persona p1 = new Persona(readFloat("Introduce nota primer parcial >> "), readFloat("Introduce nota segundo parcial >> "), readFloat("Introduce nota examen final >> "));
        Persona p2 = new Persona(readFloat("Introduce nota primer parcial >> "), readFloat("Introduce nota segundo parcial >> "), readFloat("Introduce nota examen final >> "));
        Persona p3 = new Persona(readFloat("Introduce nota primer parcial >> "), readFloat("Introduce nota segundo parcial >> "), readFloat("Introduce nota examen final >> "));

        System.out.println("Primera persona");
        System.out.printf("Primer parcial >> %f\nSegundo parcial >> %f\nExamen final >> %f\nMedia >>> %f\n", p1.getPri_parcial(), p1.getSeg_parcial(), p1.getEx_final(), p1.media());
        System.out.println("Segunda persona");
        System.out.printf("Primer parcial >> %f\nSegundo parcial >> %f\nExamen final >> %f\nMedia >>> %f\n", p2.getPri_parcial(), p2.getSeg_parcial(), p2.getEx_final(), p2.media());
        System.out.println("Tercera persona");
        System.out.printf("Primer parcial >> %f\nSegundo parcial >> %f\nExamen final >> %f\nMedia >>> %f\n", p3.getPri_parcial(), p3.getSeg_parcial(), p3.getEx_final(), p3.media());
    }
}
