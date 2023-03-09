package view;

import controller.Controller;
import static com.coti.tools.Esdia.*;

public class View {
    Controller c = new Controller();

    public void runMenu(String menu) {
        int opcion;
        boolean salir = false;

        do {
            opcion = readInt(menu);
            switch (opcion) {
                case 1:
                    this.leerNum();
                break;

                case 2:
                    this.calcularSuma();
                break;

                case 3:
                    this.getSuma();
                break;

                case 4:
                    salir = yesOrNo("Desea salir >> ");
                break;
            }
        } while (!salir);
    }

    public void leerNum() {
        c.leerNum(readInt("Introduce primer numero >> "), readInt("Introduce segundo numero >> "));
    }

    public void calcularSuma() {
        c.calcularSuma();
    }

    public void getSuma() {
        System.out.printf("La suma es >> %d\n", c.getSuma());
    }
}
