package controller;

import model.Model;
import model.Figura;

public class Controller {
    Model m = new Model();

    //==============INICIAR============== 
    public boolean iniciar(){
        return m.iniciar();
    }

    //==============FINALIZAR==============
    public boolean finalizar(){
        return m.finalizar();
    }

    //============ARCHIVOS=============
    public boolean importarCSV(){
        return m.importarCSV();
    }

    public boolean exportarCSV(){
        return m.exportarCSV();
    }

    public boolean exportarHTML(){
        return m.exportarHTML();
    }
    
    //==============GESTION DE GALERIA==============
    public void añadirFigura(Figura f){
        m.añadirFigura(f);
    }

    public boolean consultarID(String ID){
        return m.consultarID(ID);
    }

    public Figura consultarFigura(String ID){
        return m.consultarFigura(ID);
    }

    //============MODIFICAR===============
    public Figura modAltura(String ID, float altura){
        return m.modAltura(ID, altura);
    }

    public Figura modMaterial(String ID, String material){
        return m.modMaterial(ID, material);
    }

    public Figura modCantidad(String ID, int cantidad){
        return m.modCantidad(ID, cantidad);
    }

    public Figura modAño(String ID, int año){
        return m.modAño(ID, año);
    }

    public Figura modFoto(String ID, String foto){
        return m.modFoto(ID, foto);
    }

    public Figura modFabricante(String ID, String fabricante){
        return m.modFabricante(ID, fabricante);
    }

    //============ELIMINAR===============
    public String eliminarFigura(String ID){
        return m.eliminarFigura(ID);
    }

    //============LISTADOS=============
    public String[][] listadoPorID(){
        return m.listadoPorID();
    }

    public String[][] listadoPorAnioEID(){
        return m.listadoPorAnioEID();
    }

    public String[][] listadoPorFabricanteYAnio(){
        return m.listadoPorID();
    }
}
