/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import excepciones.DocExisteException;
import excepciones.UsuarioExisteException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class Datos {

    private static ArrayList<Usuario> listaUsuarios;
    private static ArrayList<Documento> listaDocs;
    private static ArrayList<Documento> listaDocsReservados;
    private static String usuario;

    private static Iterator<Documento> it;

    public static void cargarDatos() {
        cargarUsuarios();
        cargarDocumentos();
        cargarDocumentosReservados();
    }

    private static void cargarUsuarios() {
        listaUsuarios = new ArrayList<>();
        try {
            FileReader myObj = new FileReader("datos\\Usuarios.txt");
            Scanner fileReader = new Scanner(myObj);
            while (fileReader.hasNextLine()) {
                String[] listaAtributos = fileReader.nextLine().split(",");
                listaUsuarios.add(new Usuario(listaAtributos[0], listaAtributos[1], Integer.parseInt(listaAtributos[2])));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el fichero Usuarios.txt", "ERROR FATAL", JOptionPane.ERROR_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "No se han podido interpretar algunos datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void cargarDocumentos() {
        listaDocs = new ArrayList<>();
        try {
            FileReader myObj = new FileReader("datos\\Documentos.txt");
            Scanner fileReader = new Scanner(myObj);
            while (fileReader.hasNextLine()) {
                String[] listaAtributos = fileReader.nextLine().split(",");
                if (listaAtributos[0].equals("Libro")) {
                    listaDocs.add(new Libro(listaAtributos[5], Integer.parseInt(listaAtributos[6]), Integer.parseInt(listaAtributos[7]), listaAtributos[1], listaAtributos[2], listaAtributos[3], Boolean.parseBoolean(listaAtributos[4])));
                }
                if (listaAtributos[0].equals("Revista")) {
                    listaDocs.add(new Revista(listaAtributos[5], Integer.parseInt(listaAtributos[6]), listaAtributos[1], listaAtributos[2], listaAtributos[3], Boolean.parseBoolean(listaAtributos[4])));
                }
                if (listaAtributos[0].equals("Articulo")) {
                    listaDocs.add(new Articulo(listaAtributos[5], listaAtributos[1], listaAtributos[2], listaAtributos[3], Boolean.parseBoolean(listaAtributos[4])));
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el fichero Documentos.txt", "ERROR FATAL", JOptionPane.ERROR_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "No se han podido interpretar algunos datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void cargarDocumentosReservados() {
        listaDocsReservados = new ArrayList<>();
        try {
            FileReader myObj = new FileReader("datos\\DocumentosReservados.txt");
            Scanner fileReader = new Scanner(myObj);
            while (fileReader.hasNextLine()) {
                String[] listaAtributos = fileReader.nextLine().split(",");
                if (listaAtributos[0].equals("Libro")) {
                    listaDocsReservados.add(new Libro(listaAtributos[5], Integer.parseInt(listaAtributos[6]), Integer.parseInt(listaAtributos[7]), listaAtributos[1], listaAtributos[2], listaAtributos[3], Boolean.parseBoolean(listaAtributos[4])));
                }
                if (listaAtributos[0].equals("Revista")) {
                    listaDocsReservados.add(new Revista(listaAtributos[5], Integer.parseInt(listaAtributos[6]), listaAtributos[1], listaAtributos[2], listaAtributos[3], Boolean.parseBoolean(listaAtributos[4])));
                }
                if (listaAtributos[0].equals("Articulo")) {
                    listaDocsReservados.add(new Articulo(listaAtributos[5], listaAtributos[1], listaAtributos[2], listaAtributos[3], Boolean.parseBoolean(listaAtributos[4])));
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el fichero DocumentosReservados.txt", "ERROR FATAL", JOptionPane.ERROR_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "No se han podido interpretar algunos datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean loginCorrecto(String usuario, String contrasenna) {
        boolean correcto = false;
        int i = 0;
        do {
            if (listaUsuarios.get(i).getNombre().equals(usuario) && listaUsuarios.get(i).getContrasenna().equals(contrasenna)) {
                correcto = true;
            }
            i++;
        } while (!correcto && i < listaUsuarios.size());
        return correcto;
    }

    public static String[] mostrarDoc(Documento doc) {
        String[] atributos = doc.guardaAtributos().split(",");
        return atributos;
    }

    public static void eliminarDoc(String nombre) {
        int i = 0;
        boolean docEncontrado = false;
        do {
            if (listaDocs.get(i).getNombre().equals(nombre)) {
                listaDocs.remove(i);
                docEncontrado = true;
            }
            i++;
        } while (!docEncontrado && i < listaDocs.size());
    }

    public static boolean tieneDocReservado(String nombre) {
        int i = 0;
        if (listaDocsReservados.isEmpty()) {
            return false;
        }
        do {
            if (listaDocsReservados.get(i).getUsuario().equals(usuario)) {
                return true;
            }
            i++;
        } while (i < listaDocsReservados.size());
        return false;
    }

    public static boolean edadApropiada(Documento doc) {
        int i = 0;
        do {
            if (listaUsuarios.get(i).getNombre().equals(usuario) && listaUsuarios.get(i).getEdad() >= 18) {
                return true;
            }
            if (listaUsuarios.get(i).getNombre().equals(usuario) && listaUsuarios.get(i).getEdad() < 18) {
                if (doc.isAptoParaMenores()) {
                    return true;
                } else {
                    return false;
                }
            }
            i++;
        } while (i < listaUsuarios.size());
        return false;
    }

    public static boolean reservarDoc(String doc) {
        int i = 0;
        boolean docEncontrado = false;
        do {
            if (listaDocs.get(i).getNombre().equals(doc)) {
                docEncontrado = true;
            }
            i++;
        } while (!docEncontrado && i < listaDocs.size());

        if (!tieneDocReservado(doc) && edadApropiada(listaDocs.get(i - 1))) {
            listaDocs.get(i - 1).setUsuario(usuario);
            listaDocsReservados.add(listaDocs.get(i - 1));
            eliminarDoc(doc);
            JOptionPane.showMessageDialog(null, "Documento reservado con exito", "Reservar documento", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else if (tieneDocReservado(doc)) {
            JOptionPane.showMessageDialog(null, "Ya tienes un documento reservado. Devuélvelo antes de reservar otro", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Ese documento no es apto para menores", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static void devolverDoc() {
        int i = 0;
        boolean docEncontrado = false;
        if (!listaDocsReservados.isEmpty()) {
            do {
                if (listaDocsReservados.get(i).getUsuario().equals(usuario)) {
                    listaDocs.add(listaDocsReservados.get(i));
                    JOptionPane.showMessageDialog(null, "El documento '" + listaDocsReservados.get(i).getNombre() + "' ha sido devuelto con exito", "Devolver documento", JOptionPane.INFORMATION_MESSAGE);
                    listaDocsReservados.remove(i);
                    docEncontrado = true;
                }
                i++;
            } while (!docEncontrado && i < listaDocsReservados.size());
            if (!docEncontrado) {
                JOptionPane.showMessageDialog(null, "No tienes ningun documento reservado", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No tienes ningun documento reservado", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

    }

    public static void guardarDocs(String ruta, ArrayList<Documento> lista) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(ruta);
            for (int i = 0; i < lista.size(); i++) {
                fw.append(lista.get(i).guardaAtributos() + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fw != null) {
                try {
                    fw.flush();
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

    }

    public static void registrarse(String usuario, String contrasenna, int edad) throws UsuarioExisteException {
        boolean usuarioEncontrado = false;
        int i = 0;
        do {
            if (usuario.equals(listaUsuarios.get(i).getNombre())) {
                usuarioEncontrado = true;
            }
            i++;
        } while (!usuarioEncontrado && i < listaUsuarios.size());
        if (!usuarioEncontrado) {
            listaUsuarios.add(new Usuario(usuario, contrasenna, edad));
            guardarUsuarios();
        } else {
            throw new UsuarioExisteException();
        }

    }

    private static void guardarUsuarios() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("datos\\Usuarios.txt");
            for (int i = 0; i < listaUsuarios.size(); i++) {
                fw.append(listaUsuarios.get(i).guardaAtributos() + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido guardar el usuario", "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (fw != null) {
                try {
                    fw.flush();
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private static boolean docExiste(String nombre) {
        int i = 0;
        do {
            if (listaDocs.get(i).getNombre().equals(nombre)) {
                return true;
            }
            i++;
        } while (i < listaDocs.size());
        i = 0;
        if (!listaDocsReservados.isEmpty()) {
            do {
                if (listaDocsReservados.get(i).getNombre().equals(nombre)) {
                    return true;
                }
                i++;
            } while (i < listaDocsReservados.size());
        }

        return false;
    }

    public static void crearNuevoLibro(String editorial, int edicion, int numPaginas, String nombre, String autor, boolean aptoParaMenores) throws DocExisteException {
        if (!docExiste(nombre)) {
            listaDocs.add(new Libro(editorial, edicion, numPaginas, nombre, autor, aptoParaMenores));
        } else {
            throw new DocExisteException();
        }
    }

    public static void crearNuevaRevista(String editorial, int numRevista, String nombre, String autor, boolean aptoParaMenores) throws DocExisteException {
        if (!docExiste(nombre)) {
            listaDocs.add(new Revista(editorial, numRevista, nombre, autor, aptoParaMenores));
        } else {
            throw new DocExisteException();
        }
    }

    public static void crearNuevoArticulo(String fecha, String nombre, String autor, boolean aptoParaMenores) throws DocExisteException {
        if (!docExiste(nombre)) {
            listaDocs.add(new Articulo(fecha, nombre, autor, aptoParaMenores));
        } else {
            throw new DocExisteException();
        }
    }

    public static Iterator<Documento> getIt() {
        it = listaDocs.iterator();
        return it;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        Datos.usuario = usuario;
    }

    public static ArrayList<Documento> getListaDocs() {
        return listaDocs;
    }

    public static ArrayList<Documento> getListaDocsReservados() {
        return listaDocsReservados;
    }

}
