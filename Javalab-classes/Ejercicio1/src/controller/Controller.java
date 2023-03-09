package controller;

import model.Model;

public class Controller {
    Model m = new Model();

    public void leerNum(int num1, int num2) {
        m.leerNum(num1, num2);
    }

    public void calcularSuma() {
        m.calcularSuma();
    }

    public int getSuma() {
        return m.getSuma();
    }
}
