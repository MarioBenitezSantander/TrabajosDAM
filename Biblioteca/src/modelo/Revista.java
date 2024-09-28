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
public class Revista extends Documento {
    
    private String editorial;
    private int numRevista;

    public Revista() {
    }

    public Revista(String editorial, int numRevista, String nombre, String autor, boolean aptoParaMenores) {
        super(nombre, autor, aptoParaMenores);
        this.editorial = editorial;
        this.numRevista = numRevista;
    }

    public Revista(String editorial, int numRevista, String usuario, String nombre, String autor, boolean aptoParaMenores) {
        super(usuario, nombre, autor, aptoParaMenores);
        this.editorial = editorial;
        this.numRevista = numRevista;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumRevista() {
        return numRevista;
    }

    public void setNumRevista(int numRevista) {
        this.numRevista = numRevista;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.editorial);
        hash = 71 * hash + this.numRevista;
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
        final Revista other = (Revista) obj;
        if (this.numRevista != other.numRevista) {
            return false;
        }
        return Objects.equals(this.editorial, other.editorial);
    }
    
    @Override
    public String guardaAtributos(){
        return "Revista," + super.guardaAtributos() + "," + editorial + "," + numRevista;
    }

    @Override
    public String toString() {
        return "Revista{" + "editorial=" + editorial + ", numRevista=" + numRevista + '}';
    }
    
    
    
}
