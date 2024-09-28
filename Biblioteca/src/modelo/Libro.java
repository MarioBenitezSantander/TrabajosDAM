/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author Mario
 */
public class Libro extends Documento {
    
    private String editorial;
    private int edicion;
    private int numPaginas;

    public Libro() {
    }

    public Libro(String editorial, int edicion, int numPaginas, String nombre, String autor, boolean aptoParaMenores) {
        super(nombre, autor, aptoParaMenores);
        this.editorial = editorial;
        this.edicion = edicion;
        this.numPaginas = numPaginas;
    }

    public Libro(String editorial, int edicion, int numPaginas, String usuario, String nombre, String autor, boolean aptoParaMenores) {
        super(usuario, nombre, autor, aptoParaMenores);
        this.editorial = editorial;
        this.edicion = edicion;
        this.numPaginas = numPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.editorial);
        hash = 79 * hash + this.edicion;
        hash = 79 * hash + this.numPaginas;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        if (this.edicion != other.edicion) {
            return false;
        }
        if (this.numPaginas != other.numPaginas) {
            return false;
        }
        return Objects.equals(this.editorial, other.editorial);
    }
    
    @Override
    public String guardaAtributos(){
        return "Libro," + super.guardaAtributos() + "," + editorial + "," + edicion + "," + numPaginas;
    }

    @Override
    public String toString() {
        return "Libro{" + "editorial=" + editorial + ", edicion=" + edicion + ", numPaginas=" + numPaginas + '}';
    }
    
    
    
}
