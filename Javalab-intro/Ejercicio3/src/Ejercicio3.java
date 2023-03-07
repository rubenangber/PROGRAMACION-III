/*
 * author: @rubenangber
 */

import static com.coti.tools.Esdia.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        int num1 = readInt("Introduzca el primer numero >> ");
        int num2 = readInt("Introduzca el segundo numero >> ");
        int suma1 = SumaDosNumerosInt(num1, num2);

        System.out.printf("La suma de %d y %d es >> %d\n\n", num1, num2, suma1);

        int num3 = readInt("Introduzca el tercer numero >> ");
        int suma2 = SumaDosNumerosVar(num1, num2, num3);

        System.out.printf("La suma de %d  %d y %d es >> %d\n\n", num1, num2, num3, suma2);
    }
    
    static int SumaDosNumerosInt(int num1, int num2) {
        int suma = num1 + num2;
        return suma;
    }

    static int SumaDosNumerosVar(int num1, int num2, int num3) {
        int suma = num1 + num2 + num3;
        return suma;
    }
}
