/*
 * author: @rubenangber
 */

package main;

import view.View;
import static com.coti.tools.DiaUtil.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        View v = new View();

        v.runMenu("1.- Leer números\n" +
                   "2.- Calcular la suma\n" +
                   "3.- Mostrar el resultado\n" +
                   "4.- Salir\n" +
                   "Seleccione una opcion >> ");

        showFinalTime();
    }
}
