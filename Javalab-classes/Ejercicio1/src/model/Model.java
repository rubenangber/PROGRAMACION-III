package model;

public class Model {
    private int num1;
    private int num2;
    private int suma;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public void leerNum(int num1, int num2) {
        setNum1(num1);
        setNum2(num2);
    }

    public void calcularSuma() {
        this.suma = this.num1 + this.num2;
    }

    public int getSuma() {
        return this.suma;
    }
}
