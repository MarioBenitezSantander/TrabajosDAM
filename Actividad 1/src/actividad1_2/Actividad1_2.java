package actividad1_2;

import java.io.File;

/**
 *
 * @author Mario
 */
public class Actividad1_2 {

    public static void main(String[] args) {
        String separador = System.getProperty("file.separator");
        String ruta = System.getProperty("user.home") + separador + "Documentos" + separador + "prueba";
        File dir = new File(ruta);
        if(borrarDirectorio(dir)){
            System.out.println("Directorio borrado con éxito");
        }else{
            System.out.println("Error al borrar el directorio");
        }
        
    }

    //Método que borra el árbol de directorios completo desde prueba
    static boolean borrarDirectorio(File dir) {
        File[] listaFiles = dir.listFiles();
        for (File f : listaFiles) {
            if (f.isDirectory()) {
                borrarDirectorio(f);
            } else {
                f.delete();
            }
        }
        return dir.delete();
    }
}
