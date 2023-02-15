package galeria;

import view.View;
import static com.coti.tools.DiaUtil.*;

public class Galeria {

    
    public static void main(String[] args) {
        View v = new View();
        
        clear();
        v.runMenu("1) Archivos\n" +
                  "2) Gestion de la galeria\n" +
                  "3) Listados\n" +
                  "4) Salir\n" +
                  "Introduzca opcion >> ");

        showFinalTime();
    }
    
}