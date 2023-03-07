/*
 * author: @rubenangber
 */

import static com.coti.tools.Esdia.*;

public class Ejercicio9 {
    public static void main(String[] args) {
        Persona p1 = new Persona("Tom", readFloat("Introduce peso de Tom >> "), readFloat("Introduce altura de Tom >> "));
        Persona p2 = new Persona("Dick", readFloat("Introduce peso de Dick >> "), readFloat("Introduce altura de Dick >> "));
        Persona p3 = new Persona("Harry", readFloat("Introduce peso de Harry >> "), readFloat("Introduce altura de Harry >> "));

        mayorPeso(p1, p2, p3);
        mayorAltura(p1, p2, p3);
    }

    static void mayorPeso(Persona p1, Persona p2, Persona p3) {
        if(p1.getPeso() > p2.getPeso() && p1.getPeso() > p3.getPeso()) {
            System.out.println("Tom es el que mas pesa");
        } else if(p2.getPeso() > p1.getPeso() && p2.getPeso() > p3.getPeso()) {
            System.out.println("Dick es el que mas pesa");
        } else if(p3.getPeso() > p1.getPeso() && p3.getPeso() > p2.getPeso()) {
            System.out.println("Harry es el que mas pesa");
        }
    }

    static void mayorAltura(Persona p1, Persona p2, Persona p3) {
        if(p1.getAltura() > p2.getAltura() && p1.getAltura() > p3.getAltura()) {
            System.out.println("Tom es el mas alto");
        } else if(p2.getAltura() > p1.getAltura() && p2.getAltura() > p3.getAltura()) {
            System.out.println("Dick es el mas alto");
        } else if(p3.getAltura() > p1.getAltura() && p3.getAltura() > p2.getAltura()) {
            System.out.println("Harry es el mas alto");
        }
    }
}
