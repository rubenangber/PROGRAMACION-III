package galeria;

import view.View;

public class Galeria {
    public static void main(String[] args) throws InterruptedException {
        long tiempoInicio = System.currentTimeMillis();

        // View
        View v = new View();
        v.runMenu("1) Archivos\n" +
                  "2) Gestión de la galería\n" +
                  "3) Listados\n" +
                  "4) Salir\n" +
                  "Introduzca opción >> ");

        // Cáclulo de tiempo
        long tiempoFin = System.currentTimeMillis();
        long tiempo = tiempoFin - tiempoInicio;

        long minutos = (tiempo / 60000) % 60;
        long segundos = (tiempo / 1000) % 60;
        long milisegundos = tiempo % 1000;
        String tiempoFormateado = String.format("%02d:%02d:%03d", minutos, segundos, milisegundos);

        String userName = System.getProperty("user.name");
        showFinalTime(userName, tiempoFormateado);
    }

    public static void showFinalTime(String userName, String tiempoFormateado) {
        // Limpiar pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        // Mostrar estadísticas
        String fila = "+----------------------------------------+";
        System.out.println(fila);
        System.out.printf("| %-20s : %-15s |\n", "User", userName);
        System.out.println(fila);
        System.out.printf("| %-20s : %-15s |\n", "Task finished at", tiempoFormateado);
        System.out.println(fila);
    }
}
