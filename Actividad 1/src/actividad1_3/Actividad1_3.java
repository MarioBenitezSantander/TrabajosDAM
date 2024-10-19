package actividad1_3;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Mario
 */
public class Actividad1_3 {

    public static void main(String[] args) {
        String separador = System.getProperty("file.separator");
        //Creación de directorios ad y ut1_act03 dentro de Documentos
        String ruta = System.getProperty("user.home") + separador + "Documentos" + separador + "ad" + separador + "ut1_act03";
        File dir = new File(ruta);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //Creación del fichero datos.txt
        String rutaFichero = ruta + separador + "datos.txt";
        File f = new File(rutaFichero);
        crearFichero(f);
    }

    //Método que crea el fichero si no existe y muestra su contenido si existe
    static void crearFichero(File f) {
        if (f.exists()) {
            System.out.println("El fichero ya existe y su tamaño es: " + f.getTotalSpace());
        } else {
            try {
                f.createNewFile();
                System.out.println("Fichero creado con éxito");

            } catch (IOException ex) {
                System.out.println("Error al crear el fichero");
            }
        }
    }

}
