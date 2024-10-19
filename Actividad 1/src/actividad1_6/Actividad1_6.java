package actividad1_6;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class Actividad1_6 {

    public static void main(String[] args) {
        String ruta = JOptionPane.showInputDialog("Escribe una ruta");
        File dir = new File(ruta);
        JOptionPane.showMessageDialog(null, mostrarContenido(dir));
    }
    
    static String mostrarContenido(File dir){
        String lista = "";
        if(dir.isDirectory()){
            File[] listaFiles = dir.listFiles();
            for(File f:listaFiles){
                if(f.isDirectory()){
                    lista += "Directorio->"+f.getName()+"\n";
                }else{
                    lista += "Archivo->"+f.getName()+"\n";
                }
            }
        }
        return lista;
    }

}
