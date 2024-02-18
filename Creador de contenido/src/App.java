import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.printf("Introduce el título del canal >> ");
        String canal = sc.nextLine();

        int numVideos;
        do {
            System.out.printf("Introduce el número de videos del canal >> ");
            numVideos = Integer.parseInt(sc.nextLine());
        } while (numVideos < 0);
        
        ArrayList<Video> videos = new ArrayList<Video>();
        for (int i = 1; i <= numVideos; i++) {
            System.out.printf("Introduce el título del video %d >> ", i);
            String titulo = sc.nextLine();
            System.out.printf("Introduce el número de visualizaciones del video %d >> ", i);
            int visualizaciones = Integer.parseInt(sc.nextLine());
            System.out.printf("Introduce la duración del video %d >> ", i);
            long segundos = Long.parseLong(sc.nextLine());
            System.out.printf("Introduce la URL del video %d >> ", i);
            String URL = sc.nextLine();
            videos.add(new Video(titulo, visualizaciones, segundos, URL));
        }

        System.out.printf("\n\n\nAnalisis preliminar del canal >> %s\n", canal);
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "Título", "Visualizaciones", "Duración", "URL", "Ingresos");
        System.out.println("---------------------------------------------------------------------------------------------------------");

        for (Video classVideo : videos) {
            System.out.println(classVideo);
        }
        
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.printf("|Ingresos totales del canal >>                                                                       %.2f|\n", IngresosTotales(videos));
        System.out.printf("|Media de ingresos por video >>                                                                      %.2f|\n", MediaIngresos(videos, numVideos));
        System.out.println("---------------------------------------------------------------------------------------------------------");

        sc.close();
    }

    public static float IngresosTotales(ArrayList<Video> videos) {
        float ingresosTotales = 0;

        for (Video video : videos) {
            ingresosTotales = ingresosTotales + video.getIngresos();
        }

        return ingresosTotales;
    }

    public static float MediaIngresos(ArrayList<Video> videos, int numVideos) {
        float MediaIngresos = 0;

        MediaIngresos = IngresosTotales(videos) / numVideos;

        return MediaIngresos;
    }
}
