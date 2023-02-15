package model;

import com.coti.tools.OpMat;
import com.coti.tools.Rutas;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Model {
    private final String nombreCarpeta = "datos_figuras";
    private final String archivoBinFiguras = "figuras.bin";
    private final String archivoFiguras = "figuras.csv";
    private final String HTMLFiguras = "figuras.html";
    private final String CSSFiguras = "estilos.css";

    private ArrayList<Figura> figuras = new ArrayList<>();

    public String getNombreCarpeta(){
        return nombreCarpeta;
    }

    public String getArchivoBinFiguras(){
        return archivoBinFiguras;
    }

    public String getArchivoFiguras(){
        return archivoFiguras;
    }

    public String getHTMLFiguras(){
        return HTMLFiguras;
    }

    public String getCSSFiguras(){
        return CSSFiguras;
    }

    public void setListaFiguras(String[][] tmp){
        for (String[] datos : tmp) {
            Figura f = Figura.factory(datos);
            if (f != null) {
                this.figuras.add(f);
            }
        }
    }

    //==============INICIAR==============
    public boolean iniciar(){
        Path path = Rutas.pathToFileInFolderOnDesktop(nombreCarpeta, archivoBinFiguras);
        File fichero = path.toFile();

        if(!fichero.exists()){
            return false;
        } else {
            try {
                FileInputStream fis = new FileInputStream(fichero);
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);
                figuras = (ArrayList<Figura>) ois.readObject();
                ois.close();
                bis.close();
                fis.close();
            } catch (IOException | ClassNotFoundException e) {
                return false;
            }
        }

        return true;
    }

    //==============FINALIZAR==============
    public boolean finalizar(){
        Path path = Rutas.pathToFileInFolderOnDesktop(nombreCarpeta, archivoBinFiguras);
        File fichero = path.toFile();

        try {
            FileOutputStream fos = new FileOutputStream(fichero);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(figuras);
            oos.close();
            bos.close();
            fos.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    //============ARCHIVOS============
    public boolean importarCSV(){ 
        figuras.clear();
        Path path = Rutas.pathToFileInFolderOnDesktop(nombreCarpeta, archivoFiguras);
        File fichero = path.toFile();

        if(!fichero.exists()){
            return false;
        } else {
                try {
                    String[][] matriz = OpMat.importFromDisk(fichero, "\t");
                    this.setListaFiguras(matriz);
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
        }

        return true;
    }

    public boolean exportarCSV(){
        File f = Rutas.fileToFileInFolderOnDesktop(nombreCarpeta, archivoFiguras);
        
        try {
            PrintWriter pw = new PrintWriter(f.toString());
            for (Figura fe : figuras) {
                pw.printf("%s\n", fe.comoFilaDeUnCSV());           
            }
            
            pw.close();
        } catch (FileNotFoundException ex) {
            return false;
        }
        return true;
    }

    public boolean exportarCSS(){
        File f = Rutas.fileToFileInFolderOnDesktop(nombreCarpeta, CSSFiguras);

        try{
            PrintWriter pw = new PrintWriter(f.toString());
            pw.printf("body {\ncolor: black;\nfont-family: 'Times New Roman', Times, serif;\nbackground: linear-gradient(to right, rgba(255, 0, 0, 0.025), rgba(255, 242, 0, 0.09));\ntext-align: center;\n}\n"
            + "#texto {\nfont-family: 'Courier New', Courier, monospace;\nfont-size: 30px;\nfont-weight: bold;\nbackground-color: rgba(128, 128, 128, 0.29);\n}\n"
            + "table {\nbackground-color: rgba(255, 255, 255, 0.5);\nmargin-left:auto;\nmargin-right:auto;\n}\n"
            + "h1 {\nfont-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;\nfont-size: 70px;\nfont-weight: bold;\ntext-decoration: underline;\n}\n"
            + "#interno {\nfont-size: 20px;\n}\n"
            );
            pw.close();
        } catch (FileNotFoundException ex) {
            return false;
        }
        return true;
    }

    public boolean exportarHTML(){
        if(!this.exportarCSS()){
            return false;
        } else {
            File f = Rutas.fileToFileInFolderOnDesktop(nombreCarpeta, HTMLFiguras);
            
            try {
                PrintWriter pw = new PrintWriter(f.toString());
                pw.printf("<!DOCTYPE html>\n"
                        + "<html lang=\"es\">\n"
                        + "<head>\n"
                        + "<title>GALERIA DE ARTE</title>\n"
                        + "<link rel=\"icon\" href=\"https://images.emojiterra.com/google/android-oreo/512px/1f5bc.png\">\n"
                        + "<link rel=\"stylesheet\" href=\"estilos.css\">\n"
                        + "<meta charset=\"UTF-8\">\n"
                        + "<h1><center>FIGURAS</center></h1>\n"
                        + "</head>\n"
                        + "<body>\n");
                pw.printf("<table border=1>\n");

                pw.printf("<tr id=\"texto\"><td>IDENTIFICADOR</td>"
                        + "<td>ALTURA</td>"
                        + "<td>MATERIAL</td>"
                        + "<td>CANTIDAD</td>"
                        + "<td>AÑO</td>"
                        + "<td>FOTO</td>"
                        + "<td>FABRICANTE</td></tr>\n");

                for (Figura fe : figuras) {
                    pw.printf("%s\n", fe.comoFilaDeUnaTablaEnHTML());           
                }
                
                pw.printf("</table>\n</body>\n</html>\n");
                pw.close();
            } catch (FileNotFoundException ex) {
                return false;
            }
        }
        return true;
    }

    //==============GESTION DE GALERIA==============
    public void añadirFigura(Figura f){
        figuras.add(f);
    }

    public boolean consultarID(String ID){
        for(Figura f : figuras){
            if(f.getID().equals(ID)){
                return true;
            }
        }
        return false;
    }

    public Figura consultarFigura(String ID){
        for(Figura f : figuras){
            if(f.getID().equals(ID)){
                return f;
            }
        }
        return null;
    }

    //============MODIFICAR===============
    public Figura modAltura(String ID, float altura){
        for(Figura f : figuras){
            if(f.getID().equals(ID)){
                f.setAltura(altura);
                return f;
            }
        }
        return null;
    }

    public Figura modMaterial(String ID, String material){
        for(Figura f : figuras){
            if(f.getID().equals(ID)){
                f.setMaterial(material);
                return f;
            }
        }
        return null;
    }

    public Figura modCantidad(String ID, int cantidad){
        for(Figura f : figuras){
            if(f.getID().equals(ID)){
                f.setCantidad(cantidad);
                return f;
            }
        }
        return null;
    }

    public Figura modAño(String ID, int año){
        for(Figura f : figuras){
            if(f.getID().equals(ID)){
                f.setAnio(año);
                return f;
            }
        }
        return null;
    }

    public Figura modFoto(String ID, String foto){
        for(Figura f : figuras){
            if(f.getID().equals(ID)){
                f.setFoto(foto);
                return f;
            }
        }
        return null;
    }

    public Figura modFabricante(String ID, String fabricante){
        for(Figura f : figuras){
            if(f.getID().equals(ID)){
                f.setFabricante(fabricante);
                return f;
            }
        }
        return null;
    }

    //=============ELIMINAR================
    public String eliminarFigura(String ID){
        for(Figura f : figuras){
            if(f.getID().equals(ID)){
                figuras.remove(f);
                return "Figura eliminada exitosamente";
            }
        }
        return "ERROR. Figura no eliminada";
    }

    //=============LISTADOS============
    public String[][] listadoPorID(){
        String [][] tabla = new String [figuras.size()][7];
        List<Figura> figurasID = figuras;
        figurasID.sort(Comparator.comparing(Figura::getID));
        int i = 0;

        for(Figura f : figurasID){
            tabla[i][0] = f.getID();
            tabla[i][1] = String.valueOf(f.getAltura());
            tabla[i][2] = f.getMaterial();
            tabla[i][3] = String.valueOf(f.getCantidad());
            tabla[i][4] = String.valueOf(f.getAnio());
            tabla[i][5] = f.getFoto();
            tabla[i][6] = f.getFabricante();
            i++;
        }

        return tabla;
    }

    public String[][] listadoPorAnioEID(){
        String [][] tabla = new String [figuras.size()][7];
        List<Figura> figurasAnioEID = figuras;
        figurasAnioEID.sort(Comparator.comparing(Figura::getAnio).thenComparing(Figura::getID));
        int i = 0;

        for(Figura f : figurasAnioEID){
            tabla[i][0] = f.getID();
            tabla[i][1] = String.valueOf(f.getAltura());
            tabla[i][2] = f.getMaterial();
            tabla[i][3] = String.valueOf(f.getCantidad());
            tabla[i][4] = String.valueOf(f.getAnio());
            tabla[i][5] = f.getFoto();
            tabla[i][6] = f.getFabricante();
            i++;
        }

        return tabla;
    }

    public String[][] listadoPorFabricanteYAnio(){
        String [][] tabla = new String [figuras.size()][6];
        List<Figura> figurasFabricanteYAnio = figuras;
        figurasFabricanteYAnio.sort(Comparator.comparing(Figura::getFabricante).thenComparing(Figura::getAnio));
        int i = 0;

        for(Figura f : figuras){
            tabla[i][0] = f.getID();
            tabla[i][1] = String.valueOf(f.getAltura());
            tabla[i][2] = f.getMaterial();
            tabla[i][3] = String.valueOf(f.getCantidad());
            tabla[i][4] = String.valueOf(f.getAnio());
            tabla[i][5] = f.getFoto();
            tabla[i][6] = f.getFabricante();
            i++;
        }

        return tabla;
    }
}
