package view;

import static com.coti.tools.Esdia.*;
import static com.coti.tools.DiaUtil.*;
import static com.coti.tools.OpMat.*;
import controller.Controller;
import model.Figura;

public class View {
    Controller c = new Controller();

    //=============RUN MENU=============
    public void runMenu(String menu){
        String opcion;
        boolean salir = false;

        if(!this.iniciar()){
            System.out.println("Error. No se puede cargar archivo binario. Puedes cargar un CSV desde el menu");
        }

        do{
            this.titulo();
            opcion = readString_ne(menu);
            switch(opcion){
                case "1":
                    clear();
                    String menuArchivos = String.format("a) Importar CSV\n" +
                                                        "b) Exportar CSV\n" +
                                                        "c) Exportar HTML\n" +
                                                        "s) Volver al menu principal\n" +
                                                        "Introduzca opcion >> ");
                    this.menuArchivos(menuArchivos);
                break;

                case "2":
                    clear();
                    String menuGaleria = String.format("a) Añadir una figura al inventario\n" +
                                                        "b) Consultar datos de una figura\n" +
                                                        "c) Modificar datos de una figura\n" +
                                                        "d) Eliminar una figura del inventario\n" +
                                                        "s) Volver al menu principal\n" +
                                                        "Introduzca opcion >> ");
                    this.menuGaleria(menuGaleria);
                break;

                case "3":
                    clear();
                    String menuListados = String.format("a) Listado por identificador\n" +
                                                        "b) Listado por año e identificador\n" +
                                                        "c) Listado por fabricante y año\n" +
                                                        "s) Volver al menu principal\n" +
                                                        "Introduzca opcion >> ");
                    this.menuListados(menuListados);
                break;

                case "4":
                    salir = yesOrNo("Desea salir? >> ");
                    clear();
                break;

                default:
                    clear();
                    System.out.println("Opcion incorrecta");
                break;
            }
        }while(!salir);
        if(!this.finalizar()){
            System.out.println("Error. No se pudo exportar archivo binario");
        } else {
            System.out.println("Archivo binario exportado correctamente");
        }
    }

    //==============INICIAR==============
    public boolean iniciar(){
        return c.iniciar();
    }

    //==============FINALIZAR==============
    public boolean finalizar(){
        return c.finalizar();
    }

    //==============ARCHIVOS==============
    public void menuArchivos(String menuArchivos){
        String opcionArchivos;
        boolean salirArchivos = false;

        do{
            this.tituloArchivos();
            opcionArchivos = readString_ne(menuArchivos).toLowerCase();
            switch(opcionArchivos){
                case "a":
                    clear();
                    this.importarCSV();
                break;

                case "b":
                    clear();
                    this.exportarCSV();
                break;

                case "c":
                    clear();
                    this.exportarHTML();
                break;

                case "s":
                    salirArchivos = yesOrNo("Desea de archivos? >> ");
                    clear();
                break;

                default:
                    clear();
                    System.out.println("Opcion incorrecta");
                break;
            }
        }while(!salirArchivos);
    }

    public void importarCSV(){
        if(c.importarCSV()){
            System.out.println("Archivo CSV importado correctamente");
            this.pulseIntro();
        } else {
            System.out.println("No se ha podido importar el archivo CSV");
            this.pulseIntro();
        }
    }

    public void exportarCSV(){
        if(!c.exportarCSV()){
            System.out.println("Error al exportar CSV");
            this.pulseIntro();
        } else {
            System.out.println("CSV exportado correctamente");
            this.pulseIntro();
        }
    }

    public void exportarHTML(){
        if(!c.exportarHTML()){
            System.out.println("Error al exportar HTML");
            this.pulseIntro();
        } else {
            System.out.println("HTML exportado correctamente");
            this.pulseIntro();
        }
    }

    //==============GESTION DE GALERIA==============
    public void menuGaleria(String menuGaleria){
        String opcionGaleria;
        boolean salirGaleria = false;

        do{
            this.tituloGestionGaleria();
            opcionGaleria = readString_ne(menuGaleria).toLowerCase();
            switch(opcionGaleria){
                case "a":
                    clear();
                    this.añadirFigura();
                break;

                case "b":
                    clear();
                    this.consultarFigura();
                break;

                case "c":
                    clear();
                    this.modificarFigura();
                break;

                case "d":
                    clear();
                    this.eliminarFigura();
                break;

                case "s":
                    salirGaleria = yesOrNo("Desea de archivos? >> ");
                    clear();
                break;

                default:
                    clear();
                    System.out.println("Opcion incorrecta");
                break;
            }
        }while(!salirGaleria);
    }

    public void añadirFigura(){
        String ID;
        do {
            ID = readString_ne("Introduzca identificador >> ");
            if(c.consultarID(ID)){
                System.out.println("Ya existe una figura con ese ID, introduzca otro valor");
            }
        } while(c.consultarID(ID));

        float altura;
        do {
            altura = readFloat("Introduzca altura >> ");
            if (altura < 0 || altura > 1.5f) {
                System.out.println("Valor incorrecto, introduzca otro valor");
            }
        } while (altura < 0 || altura > 1.5f);

        String material = readString_ne("Introduzca material >> ");

        int cantidad;
        do {
            cantidad = readInt("Introduzca cantidad >> ");
            if (cantidad <= 0) {
                System.out.println("Valor incorrecto, introduzca otro valor");
            }
        } while (cantidad <= 0);

        int anio;
        do {
            anio = readInt("Introduzca año >> ");
            if (anio < 0 || anio > 2100) {
                System.out.println("Valor incorrecto, introduzca otro valor");
            }
        } while (anio < 0 || anio > 2100);

        String foto = readString_ne("Introduzca foto >> ");
        String fabricante = readString_ne("Introduzca fabricante >> ");

        Figura f = new Figura(ID, altura, material, cantidad, anio, foto, fabricante);

        c.añadirFigura(f);

        clear();
        System.out.println(f);
        System.out.printf("\n\n");
    }

    public void consultarFigura(){
        String ID = readString_ne("Introduzca identificador >> ");

        Figura f = c.consultarFigura(ID);

        if(f == null){
            System.out.println("No se encontró ninguna figura con ese ID");
            this.pulseIntro();
        } else {
            System.out.println(f);
            this.pulseIntro();
        }
    }

    //============MODIFICAR===============
    public void modificarFigura(){
        String ID = readString_ne("Introduzca identificador >> ");

        Figura f = c.consultarFigura(ID);

        if(f == null){
            System.out.println("No se encontró ninguna figura con ese ID");
            this.pulseIntro();
        } else {
            System.out.println(f);
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
        boolean salirModificar = false;

        do{
            this.tituloModificar();
            opcionModificar = readString_ne(menuModificar);
            switch (opcionModificar) {
                case "a":
                    clear();
                    this.modAltura(ID);
                break;

                case "b":
                    clear();
                    this.modMaterial(ID);
                break;

                case "c":
                    clear();
                    this.modCantidad(ID);
                break;

                case "d":
                    clear();
                    this.modAño(ID);
                break;

                case "e":
                    clear();
                    this.modFoto(ID);
                break;

                case "f":
                    clear();
                    this.modFabricante(ID);
                break;

                case "s":
                    salirModificar = yesOrNo("Quieres salir? >> ");
                    clear();
                break;
            
                default:
                    System.out.println("Opcion incorrecta");
                break;
            }

        }while(!salirModificar);

    }

    public void modAltura(String ID){
        float altura;
        do{
            altura = readFloat("Introduzca un nuevo valor altura >> ");
            if(altura <= 0 || altura > 1.5f){
                System.out.println("Valor incorrecto, introduzca otro valor");
            }
        } while(altura <= 0 || altura > 1.5f);
        Figura f = c.modAltura(ID, altura);

        System.out.println(f);
    }

    public void modMaterial(String ID){
        String material = readString_ne("Introduzca un nuevo material >> ");
        Figura f = c.modMaterial(ID, material);

        System.out.println(f);
    }

    public void modCantidad(String ID){
        int cantidad;
        do{
            cantidad = readInt("Introduzca una nueva cantidad >> ");
            if(cantidad <= 0){
                System.out.println("Valor incorrecto, introduzca otro valor");
            }
        }while(cantidad <= 0);
        Figura f = c.modCantidad(ID, cantidad);

        System.out.println(f);
    }

    public void modAño(String ID){
        int año;
        do{
            año = readInt("Introduzca un nuevo año >> ");
            if(año < 0 || año > 2100){
                System.out.println("Valor incorrecto, introduzca otro valor");
            }
        } while(año < 0 || año > 2100);
        Figura f = c.modAño(ID, año);

        System.out.println(f);
    }

    public void modFoto(String ID){
        String foto = readString_ne("Introduzca una nueva foto >> ");
        Figura f = c.modFoto(ID, foto);

        System.out.println(f);
    }

    public void modFabricante(String ID){
        String fabricante = readString_ne("Introduzca un nuevo fabricante >> ");
        Figura f = c.modFabricante(ID, fabricante);

        System.out.println(f);
    }

    //============ELIMINAR===============
    public void eliminarFigura(){
        String ID = readString_ne("Introduzca identificador >> ");

        Figura f = c.consultarFigura(ID);

        if(f == null){
            System.out.println("No se encontró ninguna figura con ese ID");
            this.pulseIntro();
        } else {
            System.out.println(f);
            System.out.printf("\n");
            boolean confirmar = yesOrNo("Quieres eliminar la figura? >> ");
            if(confirmar){
                String mens = c.eliminarFigura(ID);
                System.out.println(mens);
                this.pulseIntro();
            clear();
            } else {
                System.out.println("Figura no eliminada");
                this.pulseIntro();
            }
        }
    }

    //==============LISTADOS==============
    public void menuListados(String menuListados){
        String opcionListados;
        boolean salirListados = false;

        do{
            this.tituloListados();
            opcionListados = readString_ne(menuListados).toLowerCase();
            switch(opcionListados){
                case "a":
                    clear();
                    this.listadoPorID();
                break;

                case "b":
                    clear();
                    this.listadoPorAnioEID();
                break;

                case "c":
                    clear();
                    this.listadoPorFabricanteYAnio();
                break;

                case "s":
                    salirListados = yesOrNo("Desea de archivos? >> ");
                    clear();
                break;

                default:
                    clear();
                    System.out.println("Opcion incorrecta");
                break;
            }
        }while(!salirListados);
    }

    public void listadoPorID(){
        String [][] tabla = c.listadoPorID();

        try{
            underline2("Figuras ordenadas por identificador");
            printToScreen3(tabla);
            this.pulseIntro();
        }catch (Exception e){
            System.out.println("Error");
            this.pulseIntro();
        }
    }

    public void listadoPorAnioEID(){
        String [][] tabla = c.listadoPorAnioEID();

        try{
            underline2("Figuras ordenadas por año e identificador");
            printToScreen3(tabla);
            this.pulseIntro();
        }catch (Exception e){
            System.out.println("Error");
            this.pulseIntro();
        }
    }

    public void listadoPorFabricanteYAnio(){
        String [][] tabla = c.listadoPorFabricanteYAnio();

        try{
            underline2("Figuras ordenadas por fabricante y año");
            printToScreen3(tabla);
            this.pulseIntro();
        }catch (Exception e){
            System.out.println("Error");
            this.pulseIntro();
        }
    } 

    //===========GALERIA==========
    public void titulo(){
        System.out.printf("  _____           _                 _         \n");
        System.out.printf("/  ____|         | |               (_)        \n");
        System.out.printf("| |  __    __ _  | |   ___   _ __   _    __ _ \n");
        System.out.printf("| | |_ |  / _` | | |  / _ \\ | '__| | |  / _` |\n");
        System.out.printf("| |__| | | (_| | | | |  __/ | |    | | | (_| |\n");
        System.out.printf("\\______|  \\__,_| |_|  \\___| |_|    |_|  \\__,_|\n\n\n"); 
    }

    public void tituloArchivos(){
        System.out.printf("    _                _      _                  \n");
        System.out.printf("   /_\\    _ _   __  | |_   (_) __ __  ___   ___\n");
        System.out.printf("  / _ \\  | '_| / _| | ' \\  | | \\ V / / _ \\ (_-<\n");
        System.out.printf(" /_/ \\_\\ |_|   \\__| |_||_| |_|  \\_/  \\___/ /__/\n\n\n");   
    }

    public void tituloGestionGaleria(){
        System.out.printf("   ___              _     _                     _                         _               _        \n");
        System.out.printf("  / __|  ___   ___ | |_  (_)  ___   _ _      __| |  ___     __ _   __ _  | |  ___   _ _  (_)  __ _ \n");
        System.out.printf(" | (_ | / -_) (_-< |  _| | | / _ \\ | ' \\    / _` | / -_)   / _` | / _` | | | / -_) | '_| | | / _` |\n");
        System.out.printf("  \\___| \\___| /__/  \\__| |_| \\___/ |_||_|   \\__,_| \\___|   \\__, | \\__,_| |_| \\___| |_|   |_| \\__,_|\n");
        System.out.printf("                                                           |___/                                   \n\n\n");
    }

    public void tituloModificar(){
        System.out.printf("  __  __            _   _    __   _                        __   _                            \n");
        System.out.printf(" |  \\/  |  ___   __| | (_)  / _| (_)  __   __ _   _ _     / _| (_)  __ _   _  _   _ _   __ _ \n");
        System.out.printf(" | |\\/| | / _ \\ / _` | | | |  _| | | / _| / _` | | '_|   |  _| | | / _` | | || | | '_| / _` |\n");
        System.out.printf(" |_|  |_| \\___/ \\__,_| |_| |_|   |_| \\__| \\__,_| |_|     |_|   |_| \\__, |  \\_,_| |_|   \\__,_|\n");
        System.out.printf("                                                                   |___/                     \n\n\n");
    }

    public void tituloListados(){
        System.out.printf("  _      _        _               _            \n");
        System.out.printf(" | |    (_)  ___ | |_   __ _   __| |  ___   ___\n");
        System.out.printf(" | |__  | | (_-< |  _| / _` | / _` | / _ \\ (_-<\n");
        System.out.printf(" |____| |_| /__/  \\__| \\__,_| \\__,_| \\___/ /__/\n\n\n");
    }

    public void pulseIntro(){
        String intro = readString("\nPulse INTRO para continuar >> ");
        clear();
    }
}
