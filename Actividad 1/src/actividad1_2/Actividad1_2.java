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
        borrarDirectorio(dir);
    }
    
    static void borrarDirectorio(File dir){              
        if(dir.isDirectory()){
            if(!dir.delete()){
                
            }
        }else{
            dir.delete();
            
        }

    }

}
