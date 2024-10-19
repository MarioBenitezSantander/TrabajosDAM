package actividad1_5;

import java.io.File;

/**
 *
 * @author Mario
 */
public class Actividad1_5 {

    public static void main(String[] args) {
        String ruta = System.getProperty("user.dir");
        File f = new File(ruta);
        mostrarContenido(f);
    }
    
    //Método que muestra el contenido del directorio raíz del proyecto y
    //sus subdirectorios especificando si los elementos
    //son archivos o directorios
    static void mostrarContenido(File dir) {
        File[] listaFiles = dir.listFiles();
        for (File f : listaFiles) {
            if (f.isDirectory()) {
                System.out.println("Directorio -> " + f.getName());
                mostrarContenido(f);
            } else {
                System.out.println("Archivo -> " + f.getName());
            }
        }
    }

}
