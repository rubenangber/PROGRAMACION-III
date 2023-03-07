/*
 * author: @rubenangber
 */

 import static com.coti.tools.Esdia.*;

public class Ejercicio5 {
    public static void main(String[] args) {
        int b_year = readInt("Introduzca año de nacimiento >> ");
        int a_year = readInt("Introduzca año actual >> ");

        int edad = a_year - b_year;

        System.out.printf("La edad del usuario es >> %d años", edad);
        //System.out.printf("La edad del usuario es >> %d años", a_year - b_year);
    }
}
