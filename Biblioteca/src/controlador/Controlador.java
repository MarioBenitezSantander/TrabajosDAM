/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import excepciones.*;
import java.awt.Frame;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

/**
 *
 * @author Mario
 */
public class Controlador {

    private static VistaLogin vl;
    private static VistaMenuAdmin vma;
    private static VistaLibrosAdmin vla;
    private static VistaRevistasAdmin vra;
    private static VistaArticulosAdmin vaa;
    private static VistaMenuUsuario vmu;
    private static VistaLibrosUsuario vlu;
    private static VistaRevistasUsuario vru;
    private static VistaArticulosUsuario vau;
    private static VistaRegistrarse vr;
    private static VistaCrearLibro vcl;
    private static VistaCrearRevista vcr;
    private static VistaCrearArticulo vca;

    public static void iniciar() {
        Datos.cargarDatos();
        cargarVistaLogin();
    }

    public static void cargarVistaLogin() {
        vl = new VistaLogin();
        vl.setTitle("Biblioteca de Alejandria");
        vl.setExtendedState(Frame.MAXIMIZED_BOTH);
        vl.setVisible(true);
    }

    public static void login(String usuario, char[] contrasenna) {
        String contrasennaString = "";
        for (int i = 0; i < contrasenna.length; i++) {
            contrasennaString += contrasenna[i];
        }
        if (Datos.loginCorrecto(usuario, contrasennaString)) {
            if (usuario.equals("admin")) {
                cargarVistaMenuAdmin();
                vl.setVisible(false);
            } else {
                cargarVistaMenuUsuario();
                vl.setVisible(false);
            }
            Datos.setUsuario(usuario);
        } else {
            JOptionPane.showMessageDialog(null, "Datos de inicio de sesion incorrectos","ERROR", 0);
        }
    }

    public static void cargarVistaMenuAdmin() {
        vma = new VistaMenuAdmin();
        vma.setTitle("Biblioteca de Alejandria");
        vma.setExtendedState(Frame.MAXIMIZED_BOTH);
        vma.setVisible(true);
    }

    public static void cargarVistaMenuUsuario() {
        vmu = new VistaMenuUsuario();
        vmu.setTitle("Biblioteca de Alejandria");
        vmu.setExtendedState(Frame.MAXIMIZED_BOTH);
        vmu.setVisible(true);
    }

    public static void verDocs(Vista vista, String tipoDoc) {
        Iterator<Documento> it = Datos.getIt();
        while (it.hasNext()) {
            String[] atributos = Datos.mostrarDoc(it.next());
            if (atributos[0].equals(tipoDoc)) {
                String[] datos = new String[atributos.length - 2];
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = atributos[i + 2];
                }
                vista.llenarTablaDocs(datos);
            }
        }
    }

    public static void abrirVistaLibrosAdmin() {
        vla = new VistaLibrosAdmin();
        vla.instanciarModelo();
        verDocs(vla, "Libro");
        vla.setTitle("Biblioteca de Alejandria");
        vla.setExtendedState(Frame.MAXIMIZED_BOTH);
        vla.setVisible(true);
        vma.setVisible(false);
    }

    public static void abrirVistaRevistasAdmin() {
        vra = new VistaRevistasAdmin();
        vra.instanciarModelo();
        verDocs(vra, "Revista");
        vra.setTitle("Biblioteca de Alejandria");
        vra.setExtendedState(Frame.MAXIMIZED_BOTH);
        vra.setVisible(true);
        vma.setVisible(false);
    }

    public static void abrirVistaArticulosAdmin() {
        vaa = new VistaArticulosAdmin();
        vaa.instanciarModelo();
        verDocs(vaa, "Articulo");
        vaa.setTitle("Biblioteca de Alejandria");
        vaa.setExtendedState(Frame.MAXIMIZED_BOTH);
        vaa.setVisible(true);
        vma.setVisible(false);
    }

    public static void abrirVistaLibrosUsuario() {
        vlu = new VistaLibrosUsuario();
        vlu.instanciarModelo();
        verDocs(vlu, "Libro");
        vlu.setTitle("Biblioteca de Alejandria");
        vlu.setExtendedState(Frame.MAXIMIZED_BOTH);
        vlu.setVisible(true);
        vmu.setVisible(false);
    }

    public static void abrirVistaRevistasUsuario() {
        vru = new VistaRevistasUsuario();
        vru.instanciarModelo();
        verDocs(vru, "Revista");
        vru.setTitle("Biblioteca de Alejandria");
        vru.setExtendedState(Frame.MAXIMIZED_BOTH);
        vru.setVisible(true);
        vmu.setVisible(false);
    }

    public static void abrirVistaArticulosUsuario() {
        vau = new VistaArticulosUsuario();
        vau.instanciarModelo();
        verDocs(vau, "Articulo");
        vau.setTitle("Biblioteca de Alejandria");
        vau.setExtendedState(Frame.MAXIMIZED_BOTH);
        vau.setVisible(true);
        vmu.setVisible(false);
    }

    public static void cerrarSesion(JFrame vista) {
        cargarVistaLogin();
        vista.setVisible(false);
    }

    public static void eliminarDoc(Object nombre) {
            String nombreString = (String) nombre;
            Datos.eliminarDoc(nombreString); 
    }

    public static boolean reservarDoc(Object nombre) {
        String nombreString = (String) nombre;
        return Datos.reservarDoc(nombreString);
    }

    public static void devolverDoc() {
        Datos.devolverDoc();
    }

    public static void guardarDocs() {
        Datos.guardarDocs("datos\\Documentos.txt", Datos.getListaDocs());
        Datos.guardarDocs("datos\\DocumentosReservados.txt", Datos.getListaDocsReservados());
    }
    
    private static boolean contrasennasCoinciden(char[] contrasenna1, char[] contrasenna2){
        boolean coinciden = true;
        if (contrasenna1.length == contrasenna2.length) {           
            int i = 0;
            do {
                if (contrasenna1[i] != contrasenna2[i]) {
                    coinciden = false;
                }
                i++;
            } while (coinciden && i < contrasenna1.length);            
        }else{
            return false;
        }
        return coinciden;
    }

    public static void registrarse(String usuario, char[] contrasenna1, char[] contrasenna2, int edad) throws UsuarioExisteException, ContrasennasNoCoincidenException {
        if(contrasennasCoinciden(contrasenna1, contrasenna2)){
            String contrasenna = "";
            for(int i=0;i<contrasenna1.length;i++){
                contrasenna += contrasenna1[i];
            }
            Datos.registrarse(usuario, contrasenna, edad);
        }else{
            throw new ContrasennasNoCoincidenException();
        }
    }
    
    public static void abrirVistaRegistrarse(){
        vr = new VistaRegistrarse();
        vr.setTitle("Biblioteca de Alejandría");
        vr.setExtendedState(Frame.MAXIMIZED_BOTH);
        vr.setVisible(true);
        vl.setVisible(false);
    }
    
    public static void abrirVistaCrearLibro(){
        vcl = new VistaCrearLibro();
        vcl.setTitle("Biblioteca de Alejandría");
        vcl.setExtendedState(Frame.MAXIMIZED_BOTH);
        vcl.setVisible(true);
        vma.setVisible(false);
    }
    
    public static void abrirVistaCrearRevista(){
        vcr = new VistaCrearRevista();
        vcr.setTitle("Biblioteca de Alejandría");
        vcr.setExtendedState(Frame.MAXIMIZED_BOTH);
        vcr.setVisible(true);
        vma.setVisible(false);
    }
    
    public static void abrirVistaCrearArticulo(){
        vca = new VistaCrearArticulo();
        vca.setTitle("Biblioteca de Alejandría");
        vca.setExtendedState(Frame.MAXIMIZED_BOTH);
        vca.setVisible(true);
        vma.setVisible(false);
    }
    
    public static void crearNuevoLibro(String editorial, int edicion, int numPaginas, String nombre, String autor, boolean aptoParaMenores) throws DocExisteException{
        Datos.crearNuevoLibro(editorial, edicion, numPaginas, nombre, autor, aptoParaMenores);
    }
    
    public static void crearNuevaRevista(String editorial, int numRevista, String nombre, String autor, boolean aptoParaMenores) throws DocExisteException{
        Datos.crearNuevaRevista(editorial, numRevista, nombre, autor, aptoParaMenores);
    }
    
    public static void crearNuevoArticulo(String fecha, String nombre, String autor, boolean aptoParaMenores) throws DocExisteException{
        Datos.crearNuevoArticulo(fecha, nombre, autor, aptoParaMenores);
    }

}
