public class Video {
    public String titulo;
    public int visualizaciones;
    public long segundos;
    public String URL;
    public float ingresos;
    
    public Video(String titulo, int visualizaciones, long segundos, String URL) {
        this.titulo = titulo;
        this.visualizaciones = visualizaciones;
        this.segundos = segundos;
        this.URL = URL;
        this.ingresos = visualizaciones * 0.0017f;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getVisualizaciones() {
        return visualizaciones;
    }

    public void setVisualizaciones(int visualizaciones) {
        this.visualizaciones = visualizaciones;
    }

    public long getSegundos() {
        return segundos;
    }

    public void setSegundos(long segundos) {
        this.segundos = segundos;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public float getIngresos() {
        return ingresos;
    }

    @Override
    public String toString() {
        String retorno = String.format("|%-20s|%-20d|%-20d|%-20s|%-20.2f|", this.titulo, this.visualizaciones, this.segundos, this.URL, this.ingresos);
        return retorno;
    }
    
}
