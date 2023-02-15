package model;

import java.io.Serializable;

public class Figura implements Serializable{
    static Model m = new Model();
    private String ID;
    private float altura;
    private String material;
    private int cantidad;
    private int anio;
    private String foto;
    private String fabricante;


    public Figura(String ID, float altura, String material, int cantidad, int anio, String foto, String fabricante) {
        this.ID = ID;
        this.altura = altura;
        this.material = material;
        this.cantidad = cantidad;
        this.anio = anio;
        this.foto = foto;
        this.fabricante = fabricante;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public float getAltura() {
        return this.altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getAnio() {
        return this.anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFabricante() {
        return this.fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String toString() {
        return "{" +
            " ID = '" + getID() + "'" +
            ", Altura = '" + getAltura() + "'" +
            ", Material = '" + getMaterial() + "'" +
            ", Cantidad = '" + getCantidad() + "'" +
            ", Año = '" + getAnio() + "'" +
            ", Foto = '" + getFoto() + "'" +
            ", Fabricante = '" + getFabricante() + "'" +
            "}";
    }

    static Figura factory(String[] datos) {
        if (datos.length != 7) {
            return null;
        }

        if(datos[0].isBlank() || datos[0].isEmpty()){
            return null;
        }

        float resultado = 0;
        try{
            if(datos[1] != null){
                resultado = Float.parseFloat(datos[1]);
                if(resultado < 0 || resultado > 1.5f){
                    return null;
                }
            }
        } catch (NumberFormatException nfe){
            return null;
        }

        if(datos[2].isBlank() || datos[2].isEmpty()){
            return null;
        }

        int resultado1 = 0;
        try{
            if(datos[3] != null){
                resultado1 = Integer.parseInt(datos[3]);
                if(resultado1 < 0){
                    return null;
                }
            }
        } catch (NumberFormatException nfe){
            return null;
        }

        int resultado2 = 0;
        try{
            if(datos[4] != null){
                resultado2 = Integer.parseInt(datos[4]);
                if(resultado2 < 0 || resultado2 > 2100){
                    return null;
                }
            }
        } catch (NumberFormatException nfe){
            return null;
        }

        if(datos[5].isBlank() || datos[5].isEmpty()){
            return null;
        }

        if(datos[6].isBlank() || datos[6].isEmpty()){
            return null;
        }

        Figura f = new Figura(datos[0],
                              resultado,
                              datos[2],
                              resultado1,
                              resultado2,
                              datos[5],
                              datos[6]);

        return f;
    }

    public String comoFilaDeUnCSV() {
        String filaCSV;
        String alturaa = String.valueOf(this.altura);
      
        filaCSV = String.format("%s\t%s\t%s\t%d\t%d\t%s\t%s",this.ID, alturaa, this.material, this.cantidad, this.anio, this.foto, this.fabricante);
        
        return filaCSV;
    }

    public String comoFilaDeUnaTablaEnHTML() {
        String filaHTML;
      
        filaHTML = String.format("<tr id=\"interno\">" +
                                "<td>%s</td>" +
                                "<td>%.2f</td>" +
                                "<td>%s</td>" +
                                "<td>%d</td>" +
                                "<td>%d</td>" +
                                "<td>%s</td>" +
                                "<td>%s</td>" +
                                "</tr>"
                                ,this.ID, this.altura, this.material, this.cantidad, this.anio, this.foto, this.fabricante);
        
        return filaHTML;
    }
}
