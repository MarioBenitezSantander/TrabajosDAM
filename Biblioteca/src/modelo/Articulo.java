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
public class Articulo extends Documento {
    
    private String fecha;

    public Articulo() {
    }

    public Articulo(String fecha, String nombre, String autor, boolean aptoParaMenores) {
        super(nombre, autor, aptoParaMenores);
        this.fecha = fecha;
    }

    public Articulo(String fecha, String usuario, String nombre, String autor, boolean aptoParaMenores) {
        super(usuario, nombre, autor, aptoParaMenores);
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.fecha);
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
        final Articulo other = (Articulo) obj;
        return Objects.equals(this.fecha, other.fecha);
    }
    
    @Override
    public String guardaAtributos(){
        return "Articulo," + super.guardaAtributos() + "," + fecha;
    }

    @Override
    public String toString() {
        return "Articulo{" + "fecha=" + fecha + '}';
    }
    
    
    
}
