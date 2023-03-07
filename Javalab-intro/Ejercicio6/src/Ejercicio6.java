/*
 * author: @rubenangber
 */

import static com.coti.tools.Esdia.*;

public class Ejercicio6 {
    public static void main(String[] args) {
        int gol;
        float suma = 0;

        for(int i = 0; i < 10; i++) {
            gol = readInt("Goles partido >> ");
            suma = suma + gol;
        }

        float media = suma / 10;

        System.out.printf("La media de los goles en los 10 partidos ha sido %f\n", media);
    }    
}
