package ad_ut1_act08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class AD_UT1_Act08 {

    public static void main(String[] args) {
        
        File f = crearFichero();
        escribirFichero(f);
        leerFichero(f);
        
    }
    
    static File crearFichero(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe el nombre del fichero: ");
        String nombreFichero = sc.nextLine();
        File f = new File(System.getProperty("user.dir")+
                "/src/ad_ut1_act08/"+nombreFichero);
        return f;
    }
    
    static void escribirFichero(File f){
        try(FileOutputStream fos = new FileOutputStream(f,true)) {
            for(int i=0;i<2;i++){
                Scanner sc = new Scanner(System.in);
                System.out.print("Marca: ");
                fos.write((sc.nextLine()+" ").getBytes());
                System.out.print("Modelo: ");
                fos.write((sc.nextLine()+" ").getBytes());
                System.out.print("Año: ");
                fos.write((sc.nextLine()+" ").getBytes());
                System.out.print("Color: ");
                fos.write((sc.nextLine()+" ").getBytes());
                System.out.print("Pintura Metalizada(Si/No): ");
                fos.write(sc.nextLine().getBytes());
                fos.write((char)13);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AD_UT1_Act08.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AD_UT1_Act08.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    
    static void leerFichero(File f){
        try(FileInputStream fis = new FileInputStream(f);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr)){
            String linea;
            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AD_UT1_Act08.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AD_UT1_Act08.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

}
