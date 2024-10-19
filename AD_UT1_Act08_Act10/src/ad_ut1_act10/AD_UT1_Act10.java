package ad_ut1_act10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class AD_UT1_Act10 {

    public static void main(String[] args) {
        
        File origen = new File(System.getProperty("user.home")+
                "/Descargas/logo-java");
        String rutaCopia = System.getProperty("user.home")+"/Documentos/copia";
        File copia = new File(rutaCopia);
        File destino = new File(rutaCopia+"/logo-java");
        copia.mkdir();
        
        try(FileOutputStream fos = new FileOutputStream(destino);
                FileInputStream fis = new FileInputStream(origen)){
            int i;
            while((i = fis.read()) != -1){
                fos.write(i);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AD_UT1_Act10.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AD_UT1_Act10.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
    }

}
