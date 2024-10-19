package actividad1_7;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Mario
 */
public class Actividad1_7 {

    public static void main(String[] args) {
        String separador = System.getProperty("file.separator");
        String ruta = separador + System.getProperty("user.home") + separador + "Documentos" + separador + "ad" + separador + "ut1_act07";
        File dir = new File(ruta);
        crearDirectorios(dir);
        mostrarTipoRutaPermisos(dir);
        mostrarPadre(dir);
        File f = new File(ruta + separador + "fich_binario.dat");
        modificarAtributos(f);
    }

    static boolean crearDirectorios(File dir) {
        if (dir.mkdirs()) {
            File doc1 = new File(dir.getAbsolutePath() + System.getProperty("file.separator") + "fich_binario.dat");
            File doc2 = new File(dir.getAbsolutePath() + System.getProperty("file.separator") + "fichero.txt");
            try {
                doc1.createNewFile();
                doc2.createNewFile();
            } catch (IOException ex) {
                return false;
            }
            File subdirectorio1 = new File(dir.getAbsolutePath() + System.getProperty("file.separator") + "dir1");
            File subdirectorio2 = new File(dir.getAbsolutePath() + System.getProperty("file.separator") + "dir2");
            if (subdirectorio1.mkdir() && subdirectorio2.mkdir()) {
            } else {
                return false;
            }
            recorrerDir(dir);
            return true;
        } else {
            return false;
        }
    }

    static void recorrerDir(File dir) {
        System.out.println("-------------------------------------------------------");
        System.out.println("Apartado 7.2. Mostrando contenido del directorio de la actividad 7.");
        System.out.println("-------------------------------------------------------");
        if (dir.isDirectory()) {
            File[] listaFiles = dir.listFiles();
            for (File f : listaFiles) {
                System.out.println(f.getName());
            }
        }
    }

    static void mostrarTipoRutaPermisos(File dir) {
        System.out.println("-------------------------------------------------------");
        System.out.println("Apartado 7.3. Mostrando si son ficheros o directorios y sus permisos");
        System.out.println("-------------------------------------------------------");
        if (dir.isDirectory()) {
            File[] listaFiles = dir.listFiles();
            for (File f : listaFiles) {
                if (f.isDirectory()) {
                    System.out.println(f.getName() + " es un directorio. Su ruta absoluta es " + f.getAbsolutePath());

                } else {
                    System.out.println(f.getName() + " es un fichero. Su ruta absoluta es " + f.getAbsolutePath());
                }
                String read;
                String write;
                String execute;
                if (f.canRead()) {
                    read = "read";
                } else {
                    read = "not read";
                }
                if (f.canWrite()) {
                    write = "write";
                } else {
                    write = "not write";
                }
                if (f.canExecute()) {
                    execute = "execute";
                } else {
                    execute = "not executable";
                }
                System.out.println("Permisos de " + f.getAbsolutePath() + ": " + read + ", " + write + ", " + execute);
                System.out.println("");
            }
        }
    }

    static void mostrarPadre(File dir) {
        System.out.println("-------------------------------------------------------");
        System.out.println("Apartado 7.4. Mostrando el directorio padre");
        System.out.println("-------------------------------------------------------");
        System.out.println("El directorio padre de " + dir.getAbsolutePath() + " es " + dir.getParent());
    }

    static void modificarAtributos(File f) {
        if (f.exists()) {
            System.out.println("-------------------------------------------------------");
            System.out.println("Apartado 7.5. Modificando los atributos de fich_binario.dat");
            System.out.println("-------------------------------------------------------");
            f.setReadOnly();
            String read;
            String write;
            String execute;
            if (f.canRead()) {
                read = "read";
            } else {
                read = "not read";
            }
            if (f.canWrite()) {
                write = "write";
            } else {
                write = "not write";
            }
            if (f.canExecute()) {
                execute = "execute";
            } else {
                execute = "not executable";
            }
            System.out.println("Permisos de " + f.getAbsolutePath() + ": " + read + ", " + write + ", " + execute);
            System.out.println("");
        }

    }

}
