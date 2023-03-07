/*
 * author: @rubenangber
 */

 import static com.coti.tools.Esdia.*;

public class Ejercicio4 {
    public static void main(String[] args) {
        String nombre = readString("Introduzca nombre >> ");
        String ape1 = readString("Introduzca primer apellido >> ");
        String ape2 = readString("Introduzca segundo apellido >> ");

        System.out.printf("Nombre >> %s compuesto por %d letras\n", nombre, nombre.length());
        System.out.printf("Primer apellido >> %s compuesto por %d letras\n", ape1, ape1.length());
        System.out.printf("Segundo apellido >> %s compuesto por %d letras\n", ape2, ape2.length());
    }
}
