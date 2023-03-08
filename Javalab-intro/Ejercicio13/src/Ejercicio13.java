/*
 * author: @rubenangber
 */

import java.util.Scanner;

public class Ejercicio13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce un nombre: ");
        String nombre = sc.nextLine();
        
        System.out.println("IZQUIERDA");
        System.out.printf("%-20s\n",nombre);
        System.out.println("DERECHA");
        System.out.printf("%20s\n",nombre);

        sc.close();
    }
}
