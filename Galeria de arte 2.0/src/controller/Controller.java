package controller;

import java.util.ArrayList;
import model.Figura;
import model.Model;

public class Controller {
    Model m = new Model();

    public int getFallos() {
        return m.getFallos();
    }

    public int getCorrectos() {
        return m.getCorrectos();
    }

    //====================INICIAR====================
    public boolean iniciar() {
        return m.iniciar();
    }

    //====================FINALIZAR====================
    public boolean finalizar() {
        return m.finalizar();
    }

    public Figura consultarFigura(String ID) {
        return m.consultarFigura(ID);
    }

    

    public boolean eliminarFigura(String ID) {
        return m.eliminarFigura(ID);
    }

    //====================ARCHIVOS====================
    public boolean importarCSV() {
        return m.importarCSV();
    }

    public boolean exportarCSV() {
        return m.exportarCSV();
    }

    public boolean exportarHTML() {
        return m.exportarHTML();
    }

    //====================GESTION GALERIA====================
    public void añadirFigura(Figura f) {
        m.añadirFigura(f);
    }

    public Figura modAltura(String ID, float altura) {
        return m.modAltura(ID, altura);
    }

    public Figura modMaterial(String ID, String material) {
        return m.modMaterial(ID, material);
    }

    public Figura modCantidad(String ID, int cantidad) {
        return m.modCantidad(ID, cantidad);
    }

    public Figura modAño(String ID, int año) {
        return m.modAño(ID, año);
    }

    public Figura modFoto(String ID, String foto) {
        return m.modFoto(ID, foto);
    }

    public Figura modFabricante(String ID, String fabricante) {
        return m.modFabricante(ID, fabricante);
    }

    public boolean consultarID(String ID) {
        return m.consultarID(ID);
    }

    //====================LISTADOS====================
    public ArrayList listadoFigurasID() {
        return m.listadoFigurasID();
    }

    public ArrayList listadoPorAnioEID() {
        return m.listadoPorAnioEID();
    }

    public ArrayList listadoPorFabricanteYAnio() {
        return m.listadoPorFabricanteYAnio();
    }
}
