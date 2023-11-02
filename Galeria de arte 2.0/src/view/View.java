package view;

import java.util.ArrayList;
import java.util.Scanner;
import controller.Controller;
import model.Figura;

public class View {
    Controller c = new Controller();
    Scanner sc = new Scanner(System.in);

    //====================RUNMENU====================
    public void runMenu(String menu) {
        String opcion;
        boolean salir = false;

        if (!this.iniciar()) {
            System.out.println("No se ha podido cargar el archivo binario");
        }

        do {
            titulo();
            System.out.printf("%s", menu);
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    String menuArchivos = "a) Cargar archivo CSV\n" +
                                          "b) Exportar archivo CSV\n" +
                                          "c) Exportar archivo HTML\n" +
                                          "s) Salir\n" +
                                          "Introduzca opción >> ";
                    this.menuArchivos(menuArchivos);
                break;

                case "2":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    String menuGaleria = String.format("a) Añadir figura al inventario\n" +
                                                       "b) Consultar datos de una figura\n" +
                                                       "c) Modificar datos de una figura\n" +
                                                       "d) Eliminar una figura del inventario\n" +
                                                       "s) Volver al menú principal\n" +
                                                       "Introduzca opción >> ");
                    this.menuGaleria(menuGaleria);
                break;

                case "3":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    String menuListados = "a) Listado por identificador\n" +
                                          "b) Listado por año e identificador\n" +
                                          "c) Listado por fabricante y año\n" +
                                          "s) Volver al menú principal\n" +
                                          "Introduzca opción >> ";
                    this.menuListados(menuListados);
                break;

                case "4":
                    System.out.printf("Está seguro que desea salir? (S/N): ");
                    String confirmacion = sc.nextLine();
                    if (confirmacion.equals("S") || confirmacion.equals("s")) {
                        salir = true;
                        if (!c.finalizar()) {
                            System.out.println("No se ha podido guardar el archivo binario");
                        }
                        sc.close();
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                break;
            
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Opción incorrecta");
                break;
            }
        } while (!salir);
    }

    //====================INICIAR====================
    public boolean iniciar() {
        return c.iniciar();
    }

    //====================FINALIZAR====================
    public boolean finalizar() {
        return c.finalizar();
    }

    //====================ARCHIVOS====================
    public void menuArchivos(String menu) {
        String opcion;
        boolean salir = false;

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            this.tituloArchivos();
            System.out.printf("%s", menu);
            opcion = sc.nextLine();
            switch (opcion) {
                case "a":
                case "A":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    this.importarCSV();
                break;

                case "b":
                case "B":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    this.exportarCSV();
                break;

                case "c":
                case "C":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    this.exportarHTML();
                break;

                case "s":
                case "S":
                    System.out.printf("Está seguro que desea salir? (S/N): ");
                    String confirmacion = sc.nextLine();
                    if (confirmacion.equals("S") || confirmacion.equals("s")) {
                        salir = true;
                    }
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                break;
            
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Opción incorrecta");
                break;
            }
        } while (!salir);
    }

    public void importarCSV() {
        if (!c.importarCSV()) {
            System.out.println("No se ha podido importar el archivo CSV");
        } else {
            System.out.println("Archivo CSV importado correctamente");
            System.out.printf("%d figuras no se han podido importar\n", c.getFallos());
            System.out.printf("%d figuras se han importado correctamente\n", c.getCorrectos());
        }
        sc.nextLine();
    }

    public void exportarCSV() {
        if (!c.exportarCSV()) {
            System.out.println("No se ha podido exportar el archivo CSV");
        } else {
            System.out.println("Archivo CSV exportado correctamente");
        }
        sc.nextLine();
    }

    public void exportarHTML() {
        if (!c.exportarHTML()) {
            System.out.println("No se ha podido exportar el archivo HTML");
        } else {
            System.out.println("Archivo HTML exportado correctamente");
        }
        sc.nextLine();
    }

    //====================GESTION GALERIA====================
    public void menuGaleria(String menu) {
        String opcion;
        boolean salir = false;

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            this.tituloGestionGaleria();
            System.out.printf("%s", menu);
            opcion = sc.nextLine();
            switch (opcion) {
                case "a":
                case "A":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    this.anadirFigura();
                break;

                case "b":
                case "B":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    this.consultarFigura();
                break;

                case "c":
                case "C":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    this.modificarFigura();
                break;

                case "d":
                case "D":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    this.eliminarFigura();
                break;

                case "s":
                case "S":
                    System.out.printf("Está seguro que desea salir? (S/N): ");
                    String confirmacion = sc.nextLine();
                    if (confirmacion.equals("S") || confirmacion.equals("s")) {
                        salir = true;
                    }
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                break;
            
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Opción incorrecta");
                break;
            }
        } while (!salir);
    }

    public void anadirFigura() {
        String ID;
        do {
            System.out.printf("Introduzca el identificador de la figura >> ");
            ID = sc.nextLine();
            if (c.consultarID(ID)) {
                System.out.println("Ya existe una figura con ese identificador");
            }
        } while (c.consultarID(ID));

        float altura;
        do {
            System.out.printf("Introduzca la altura de la figura >> ");
            altura = sc.nextFloat();
            if (altura <= 0 || altura > 1.5f) {
                System.out.println("Valor incorrecto, introduzca otro valor");
            }
            sc.nextLine(); // Limpia el buffer
        } while (altura <= 0|| altura > 1.5f);

        System.out.printf("Introduzca el material de la figura >> ");
        String material = sc.nextLine();
        
        int cantidad;
        do {
            System.out.printf("Introduzca la cantidad de figuras >> ");
            cantidad = sc.nextInt();
            if (cantidad <= 0) {
                System.out.println("Valor incorrecto, introduzca otro valor");
            }
            sc.nextLine(); // Limpia el buffer
        } while (cantidad <= 0);

        int anio;
        do {
            System.out.printf("Introduzca el año de fabricación >> ");
            anio = sc.nextInt();
            if (anio < 0 || anio > 2100) {
                System.out.println("Valor incorrecto, introduzca otro valor");
            }
            sc.nextLine(); // Limpia el buffer
        } while (anio < 0 || anio > 2100);

        System.out.printf("Introduzca el nombre de la foto >> ");
        String foto = sc.nextLine();

        System.out.printf("Introduzca el nombre del fabricante >> ");
        String fabricante = sc.nextLine();

        Figura f = new Figura(ID, altura, material, cantidad, anio, foto, fabricante);

        c.añadirFigura(f);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(f.toStringFigura());
        System.out.printf("\n\n");
    }

    public void consultarFigura() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.printf("Introduzca el identificador de la figura que quiere buscar >> ");
        String ID = sc.nextLine();
        Figura f = c.consultarFigura(ID);
        if (f == null) {
            System.out.println("No existe ninguna figura con ese identificador");
        } else {
            System.out.println(f.toStringFigura());
        }
        sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void modificarFigura() {
        System.out.printf("Introduzca identificador >> ");
        String ID = sc.nextLine();

        Figura f = c.consultarFigura(ID);

        if(f == null) {
            System.out.println("No se encontró ninguna figura con ese ID");
            sc.nextLine();
        } else {
            System.out.println(f.toStringFigura());
            String menuModificar = String.format("a) Modificar altura\n" +
                                                        "b) Modificar material\n" +
                                                        "c) Modificar cantidad\n" +
                                                        "d) Modificar año\n" +
                                                        "e) Modificar foto\n" +
                                                        "f) Modificar fabricante\n" +
                                                        "s) Volver al menu\n" +
                                                        "Introduzca opcion >> ");
                    this.menuModificar(menuModificar, ID);
        }
    }

    public void menuModificar(String menuModificar, String ID) {
        String opcionModificar;
        boolean salir = false;

        do {
            this.tituloModificar();
            System.out.printf("%s", menuModificar);
            opcionModificar = sc.nextLine();
            switch (opcionModificar) {
                case "a":
                case "A":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    this.modAltura(ID);
                break;

                case "b":
                case "B":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    this.modMaterial(ID);
                break;

                case "c":
                case "C":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    this.modCantidad(ID);
                break;

                case "d":
                case "D":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    this.modAño(ID);
                break;

                case "e":
                case "E":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    this.modFoto(ID);
                break;

                case "f":
                case "F":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    this.modFabricante(ID);
                break;

                case "s":
                case "S":
                    System.out.printf("Está seguro que desea salir? (S/N): ");
                    String confirmacion = sc.nextLine();
                    if (confirmacion.equals("S") || confirmacion.equals("s")) {
                        salir = true;
                    }
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                break;
            
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Opción incorrecta");
                break;
            }

        } while (!salir);
    }

    public void modAltura(String ID) {
        float altura;
        do {
            System.out.printf("Introduzca un nuevo valor altura >> ");
            altura = sc.nextFloat();
            if(altura <= 0 || altura > 1.5f) {
                System.out.println("Valor incorrecto, introduzca otro valor");
            }
        } while (altura <= 0 || altura > 1.5f);
        Figura f = c.modAltura(ID, altura);

        System.out.println(f.toStringFigura());
    }

    public void modMaterial(String ID) {
        System.out.printf("Introduzca un nuevo material >> ");
        String material = sc.nextLine();
        Figura f = c.modMaterial(ID, material);

        System.out.println(f.toStringFigura());
    }

    public void modCantidad(String ID) {
        int cantidad;
        do {
            System.out.printf("Introduzca una nueva cantidad >> ");
            cantidad = sc.nextInt();
            if(cantidad <= 0) {
                System.out.println("Valor incorrecto, introduzca otro valor");
            }
        } while (cantidad <= 0);
        Figura f = c.modCantidad(ID, cantidad);

        System.out.println(f.toStringFigura());
    }

    public void modAño(String ID) {
        int año;
        do {
            System.out.printf("Introduzca un nuevo año >> ");
            año = sc.nextInt();
            if(año < 0 || año > 2100) {
                System.out.println("Valor incorrecto, introduzca otro valor");
            }
        } while (año < 0 || año > 2100);
        Figura f = c.modAño(ID, año);

        System.out.println(f.toStringFigura());
    }

    public void modFoto(String ID) {
        System.out.printf("Introduzca una nueva foto >> ");
        String foto = sc.nextLine();
        Figura f = c.modFoto(ID, foto);

        System.out.println(f.toStringFigura());
    }

    public void modFabricante(String ID) {
        System.out.printf("Introduzca un nuevo fabricante >> ");
        String fabricante = sc.nextLine();
        Figura f = c.modFabricante(ID, fabricante);

        System.out.println(f.toStringFigura());
    }

    public void eliminarFigura() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.printf("Introduzca el identificador de la figura que quiere eliminar >> ");
        String ID = sc.nextLine();
        if (!c.eliminarFigura(ID)) {
            System.out.println("No existe ninguna figura con ese identificador");
        } else {
            System.out.println("Figura eliminada");
        }
        sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //====================LISTADOS====================
    public void menuListados(String menu) {
        String opcion;
        boolean salir = false;

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            this.tituloListados();
            System.out.printf("%s", menu);
            opcion = sc.nextLine();
            switch (opcion) {
                case "a":
                case "A":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    this.listadoFigurasID();
                break;

                case "b":
                case "B":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    this.listadoPorAnioEID();
                break;

                case "c":
                case "C":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    this.listadoPorFabricanteYAnio();
                break;

                case "s":
                case "S":
                    System.out.printf("Está seguro que desea salir? (S/N): ");
                    String confirmacion = sc.nextLine();
                    if (confirmacion.equals("S") || confirmacion.equals("s")) {
                        salir = true;
                    }
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                break;
            
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Opción incorrecta");
                break;
            }
        } while (!salir);
    }

    public void listadoFigurasID() {
        ArrayList<Figura> listaOrdenada = new ArrayList<>();
        listaOrdenada = c.listadoFigurasID();

        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n", "Identificador", "Altura", "Material", "Cantidad", "Año", "Foto", "Fabricante");
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
        for (Figura figura : listaOrdenada) {
            System.out.println(figura);
            System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
        }

        sc.nextLine();
    }

    public void listadoPorAnioEID() {
        ArrayList<Figura> listaOrdenada = new ArrayList<>();
        listaOrdenada = c.listadoPorAnioEID();

        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n", "Identificador", "Altura", "Material", "Cantidad", "Año", "Foto", "Fabricante");
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
        for (Figura figura : listaOrdenada) {
            System.out.println(figura);
            System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
        }

        sc.nextLine();
    }

    public void listadoPorFabricanteYAnio() {
        ArrayList<Figura> listaOrdenada = new ArrayList<>();
        listaOrdenada = c.listadoPorFabricanteYAnio();

        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n", "Identificador", "Altura", "Material", "Cantidad", "Año", "Foto", "Fabricante");
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
        for (Figura figura : listaOrdenada) {
            System.out.println(figura);
            System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
        }

        sc.nextLine();
    }

    //====================TITULOS====================
    public void titulo() {
        System.out.printf("  _____           _                 _         \n");
        System.out.printf("/  ____|         | |               (_)        \n");
        System.out.printf("| |  __    __ _  | |   ___   _ __   _    __ _ \n");
        System.out.printf("| | |_ |  / _` | | |  / _ \\ | '__| | |  / _` |\n");
        System.out.printf("| |__| | | (_| | | | |  __/ | |    | | | (_| |\n");
        System.out.printf("\\______|  \\__,_| |_|  \\___| |_|    |_|  \\__,_|\n\n\n"); 
    }

    public void tituloArchivos() {
        System.out.printf("    _                _      _                  \n");
        System.out.printf("   /_\\    _ _   __  | |_   (_) __ __  ___   ___\n");
        System.out.printf("  / _ \\  | '_| / _| | ' \\  | | \\ V / / _ \\ (_-<\n");
        System.out.printf(" /_/ \\_\\ |_|   \\__| |_||_| |_|  \\_/  \\___/ /__/\n\n\n");   
    }

    public void tituloGestionGaleria() {
        System.out.printf("   ___              _     _                     _                         _               _        \n");
        System.out.printf("  / __|  ___   ___ | |_  (_)  ___   _ _      __| |  ___     __ _   __ _  | |  ___   _ _  (_)  __ _ \n");
        System.out.printf(" | (_ | / -_) (_-< |  _| | | / _ \\ | ' \\    / _` | / -_)   / _` | / _` | | | / -_) | '_| | | / _` |\n");
        System.out.printf("  \\___| \\___| /__/  \\__| |_| \\___/ |_||_|   \\__,_| \\___|   \\__, | \\__,_| |_| \\___| |_|   |_| \\__,_|\n");
        System.out.printf("                                                           |___/                                   \n\n\n");
    }

    public void tituloModificar() {
        System.out.printf("  __  __            _   _    __   _                        __   _                            \n");
        System.out.printf(" |  \\/  |  ___   __| | (_)  / _| (_)  __   __ _   _ _     / _| (_)  __ _   _  _   _ _   __ _ \n");
        System.out.printf(" | |\\/| | / _ \\ / _` | | | |  _| | | / _| / _` | | '_|   |  _| | | / _` | | || | | '_| / _` |\n");
        System.out.printf(" |_|  |_| \\___/ \\__,_| |_| |_|   |_| \\__| \\__,_| |_|     |_|   |_| \\__, |  \\_,_| |_|   \\__,_|\n");
        System.out.printf("                                                                   |___/                     \n\n\n");
    }

    public void tituloListados() {
        System.out.printf("  _      _        _               _            \n");
        System.out.printf(" | |    (_)  ___ | |_   __ _   __| |  ___   ___\n");
        System.out.printf(" | |__  | | (_-< |  _| / _` | / _` | / _ \\ (_-<\n");
        System.out.printf(" |____| |_| /__/  \\__| \\__,_| \\__,_| \\___/ /__/\n\n\n");
    }
}