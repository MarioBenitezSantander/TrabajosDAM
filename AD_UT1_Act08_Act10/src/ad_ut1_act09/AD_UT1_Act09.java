package ad_ut1_act09;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class AD_UT1_Act09 {

    public static void main(String[] args) {

        File f = crearFichero();
        escribirFichero(f);
        leerFichero(f);

    }

    static File crearFichero() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe el nombre del fichero: ");
        String nombreFichero = sc.nextLine();
        File f = new File(System.getProperty("user.dir")
                + "/src/ad_ut1_act09/" + nombreFichero);
        return f;
    }

    static void escribirFichero(File f) {
        for (int i = 0; i < 2; i++) {
            Scanner sc = new Scanner(System.in);
            Vehiculo vehiculo = new Vehiculo();
            System.out.print("Marca: ");
            vehiculo.setMarca(sc.nextLine());
            System.out.print("Modelo: ");
            vehiculo.setModelo(sc.nextLine());
            System.out.print("Año: ");
            vehiculo.setAnno(sc.nextLine());
            System.out.print("Color: ");
            vehiculo.setColor(sc.nextLine());
            System.out.print("Pintura Metalizada(Si/No): ");
            String pm = sc.nextLine();
            if (pm.equalsIgnoreCase("si")) {
                vehiculo.setPinturaMetalizada(true);
            } else {
                vehiculo.setPinturaMetalizada(false);
            }

            if (f.length() > 0) {
                try (MyObjectOutputStream oos = new MyObjectOutputStream(
                        new FileOutputStream(f, true))) {
                    oos.writeObject(vehiculo);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AD_UT1_Act09.class.getName()).
                            log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AD_UT1_Act09.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            } else {
                try (ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream(f, true))) {
                    oos.writeObject(vehiculo);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AD_UT1_Act09.class.getName()).
                            log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AD_UT1_Act09.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    static void leerFichero(File f) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(f))) {
            while (true) {
                System.out.println(ois.readObject().toString());
            }
        } catch (EOFException ex) {
            System.out.println("FIN DEL FICHERO");
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(AD_UT1_Act09.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

}
