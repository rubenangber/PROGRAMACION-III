package model;

import java.io.Serializable;

public class Figura implements Serializable {
    private String ID;
    private float altura;
    private String material;
    private int cantidad;
    private int anio;
    private String foto;
    private String fabricante;

    //====================CONSTRUCTOR====================
    public Figura(String ID, float altura, String material, int cantidad, int anio, String foto, String fabricante) {
        this.ID = ID;
        this.altura = altura;
        this.material = material;
        this.cantidad = cantidad;
        this.anio = anio;
        this.foto = foto;
        this.fabricante = fabricante;
    }

    //====================GETTERS & SETTERS====================
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        String cadena = String.format("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |", ID, altura, material, cantidad, anio, foto, fabricante);
        
        return cadena;
    }

    public String toStringFigura() {
        return "\tFIGURA\n" + "\tID >> " + ID + 
                     "\n\t" + "Altura >> " + altura + 
                     "\n\t" + "Material >> " + material + 
                     "\n\t" + "Cantidad >> " + cantidad + 
                     "\n\t" + "Año >> " + anio + 
                     "\n\t" + "Foto >> " + foto + 
                     "\n\t" + "Fabricante >>" + fabricante;
    }
}
