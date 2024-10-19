package actividad1_2;
import java.io.File;
/**
 *
 * @author Mario
 */
public class Actividad1_2 {

    public static void main(String[] args) {
        String separador = System.getProperty("file.separator");
        String ruta = System.getProperty("user.home")+separador+"Documentos"+separador+"prueba";
        File dir = new File(ruta);
        if(borrarDirectorio(dir)){
            System.out.println("Directorio borrado con exito");
        }else{
            System.out.println("No se ha podido borrar el directorio");
        }
    }
    
    static boolean borrarDirectorio(File dir){              
        if(dir.exists()){
            File[] files = dir.listFiles();
            if(files != null){
                for(File file: files){
                    if(file.isDirectory()){
                        borrarDirectorio(file);
                    }else{
                        file.delete();
                    }
                }
            }
        }
        return dir.delete();
    }

}

