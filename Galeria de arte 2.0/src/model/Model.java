package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Model {
    ArrayList<Figura> listaFiguras = new ArrayList<>();
    String archivoBinario = "figuras.bin";
    String archivoCSV = "figuras.csv";
    String archivoHTML = "figuras.html";
    String separador = ",";
    int fallo = 0;
    int correcto = 0;

    public int getFallos() {
        return fallo;
    }

    public int getCorrectos() {
        return correcto;
    }

    //====================INICIAR====================
    public boolean iniciar() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivoBinario))) {
            while (true) {
                Figura f = (Figura)in.readObject();
                listaFiguras.add(f);
            }
        } catch (EOFException e) {
            return true;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    

    //====================FINALIZAR====================
    public boolean finalizar() {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivoBinario))) {
            for (Figura figura : listaFiguras) {
                salida.writeObject(figura);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    //====================ARCHIVOS====================
    public boolean importarCSV() {
        listaFiguras.clear();
        try {
            File archivo = new File(archivoCSV);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);
                if (datos.length == 7) {

                    if(datos[0].isBlank() || datos[0].isEmpty()) {
                        fallo++;
                        continue;
                    }
            
                    float resultado = 0;
                    try{
                        if(datos[1] != null) {
                            resultado = Float.parseFloat(datos[1]);
                            if(resultado < 0 || resultado > 1.5f) {
                                fallo++;
                                continue;
                            }
                        }
                    } catch (NumberFormatException nfe) {
                        fallo++;
                        continue;
                    }
            
                    if(datos[2].isBlank() || datos[2].isEmpty()) {
                        fallo++;
                        continue;
                    }
            
                    int resultado1 = 0;
                    try{
                        if(datos[3] != null) {
                            resultado1 = Integer.parseInt(datos[3]);
                            if(resultado1 < 0) {
                                fallo++;
                                continue;
                            }
                        }
                    } catch (NumberFormatException nfe) {
                        fallo++;
                        continue;
                    }
            
                    int resultado2 = 0;
                    try{
                        if(datos[4] != null) {
                            resultado2 = Integer.parseInt(datos[4]);
                            if(resultado2 < 0 || resultado2 > 2100) {
                                fallo++;
                                continue;
                            }
                        }
                    } catch (NumberFormatException nfe) {
                        fallo++;
                        continue;
                    }
            
                    if(datos[5].isBlank() || datos[5].isEmpty()) {
                        fallo++;
                        continue;
                    }
            
                    if(datos[6].isBlank() || datos[6].isEmpty()) {
                        fallo++;
                        continue;
                    }
                    
                    correcto++;
                    Figura f = new Figura(datos[0],
                                          resultado,
                                          datos[2],
                                          resultado1,
                                          resultado2,
                                          datos[5],
                                          datos[6]);
            

                    listaFiguras.add(f);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean exportarCSV() {
        try {
            File archivo = new File(archivoCSV);
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Figura f : listaFiguras) {
                String linea = String.join(separador, f.getID(), String.valueOf(f.getAltura()), f.getMaterial(), String.valueOf(f.getCantidad()), String.valueOf(f.getAnio()), f.getFoto(), f.getFabricante());
                linea += "\n";
                bw.write(linea);
            }

            bw.close();
            fw.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean exportarHTML() {
        try {
            File archivo = new File(archivoHTML);
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("<!DOCTYPE html>\n");
            bw.write("<html lang=\"es\">\n");
            bw.write("<head>\n");
            bw.write("<meta charset=\"UTF-8\">\n");
            bw.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
            bw.write("<title>Figuras</title>\n");
            bw.write("</head>\n");
            bw.write("<body>\n");
            bw.write("<table border=\"1\">\n");
            bw.write("<tr>\n");
            bw.write("<th>ID</th>\n");
            bw.write("<th>Altura</th>\n");
            bw.write("<th>Material</th>\n");
            bw.write("<th>Cantidad</th>\n");
            bw.write("<th>Año</th>\n");
            bw.write("<th>Foto</th>\n");
            bw.write("<th>Fabricante</th>\n");
            bw.write("</tr>\n");

            for (Figura f : listaFiguras) {
                bw.write("<tr>\n");
                bw.write("<td>" + f.getID() + "</td>\n");
                bw.write("<td>" + f.getAltura() + "</td>\n");
                bw.write("<td>" + f.getMaterial() + "</td>\n");
                bw.write("<td>" + f.getCantidad() + "</td>\n");
                bw.write("<td>" + f.getAnio() + "</td>\n");
                bw.write("<td>" + f.getFoto() + "</td>\n");
                bw.write("<td>" + f.getFabricante() + "</td>\n");
                bw.write("</tr>\n");
            }

            bw.write("</table>\n");
            bw.write("</body>\n");
            bw.write("</html>\n");

            bw.close();
            fw.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //====================GESTION GALERIA====================
    public void añadirFigura(Figura f) {
        listaFiguras.add(f);
    }

    public Figura consultarFigura(String ID) {
        if (consultarID(ID)) {
            for (Figura figura : listaFiguras) {
                if (figura.getID().equals(ID)) {
                    return figura;
                }
            }
        }
        return null;
    }

    public Figura modAltura(String ID, float altura) {
        for(Figura f : listaFiguras) {
            if(f.getID().equals(ID)) {
                f.setAltura(altura);
                return f;
            }
        }
        return null;
    }

    public Figura modMaterial(String ID, String material) {
        for(Figura f : listaFiguras) {
            if(f.getID().equals(ID)) {
                f.setMaterial(material);
                return f;
            }
        }
        return null;
    }

    public Figura modCantidad(String ID, int cantidad) {
        for(Figura f : listaFiguras) {
            if(f.getID().equals(ID)) {
                f.setCantidad(cantidad);
                return f;
            }
        }
        return null;
    }

    public Figura modAño(String ID, int año) {
        for(Figura f : listaFiguras) {
            if(f.getID().equals(ID)) {
                f.setAnio(año);
                return f;
            }
        }
        return null;
    }

    public Figura modFoto(String ID, String foto) {
        for(Figura f : listaFiguras) {
            if(f.getID().equals(ID)) {
                f.setFoto(foto);
                return f;
            }
        }
        return null;
    }

    public Figura modFabricante(String ID, String fabricante) {
        for(Figura f : listaFiguras) {
            if(f.getID().equals(ID)) {
                f.setFabricante(fabricante);
                return f;
            }
        }
        return null;
    }

    public boolean eliminarFigura(String ID) {
        if (consultarID(ID)) {
            for (Figura figura : listaFiguras) {
                if (figura.getID().equals(ID)) {
                    listaFiguras.remove(figura);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean consultarID(String ID) {
        for (Figura figura : listaFiguras) {
            if (figura.getID().equals(ID)) {
                return true;
            }
        }
        return false;
    }

    //====================LISTADOS====================
    public ArrayList<Figura> listadoFigurasID() {
        Comparator<Figura> comparador = Comparator.comparing(Figura::getID);

        Collections.sort(listaFiguras, comparador);

        return listaFiguras;
    }

    public ArrayList<Figura> listadoPorAnioEID() {
        Comparator<Figura> comparador = Comparator.comparing(Figura::getAnio).thenComparing(Figura::getID);

        Collections.sort(listaFiguras, comparador);

        return listaFiguras;
    }

    public ArrayList<Figura> listadoPorFabricanteYAnio() {
        Comparator<Figura> comparador = Comparator.comparing(Figura::getFabricante).thenComparing(Figura::getAnio);

        Collections.sort(listaFiguras, comparador);

        return listaFiguras;
    }
}
