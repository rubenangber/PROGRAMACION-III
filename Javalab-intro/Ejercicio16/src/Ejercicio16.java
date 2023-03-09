/*
 * author: @rubenangber
 */

import java.io.Console;

public class Ejercicio16 {
    public static void main(String[] args) {
        Console c = System.console();
        if (c == null) {
            System.out.println("ERROR. No se ha podido crear consola");
            return;
        }
        String user, contras;
        char contra[];
        int cont = 0;

        do {
            if (cont == 1) {
                System.out.println("Pista 1");
            } else if (cont == 2) {
                System.out.println("Pista 2");
            } else if (cont == 3) {
                System.out.println("Pista 3");
            }
            user = c.readLine("Introduzca el usuario: ");
            contra = c.readPassword("Introduzca la contraseña: ");
            contras = String.valueOf(contra);
            cont++;
        } while ((!user.equals("rubenangber") || !contras.equals("2905")) && cont < 4);

        if (cont < 4) {
            System.out.printf("%s\t%s\n", user, contras);
        } else {
            System.out.println("Has superado el numero maximo de intentos");
        }
    }
}
