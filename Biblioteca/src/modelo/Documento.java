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
public abstract class Documento {
    
    private String usuario;
    private String nombre;
    private String autor;
    private boolean aptoParaMenores;

    public Documento() {
    }

    public Documento(String nombre, String autor, boolean aptoParaMenores) {
        this.nombre = nombre;
        this.autor = autor;
        this.aptoParaMenores = aptoParaMenores;
    }

    public Documento(String usuario, String nombre, String autor, boolean aptoParaMenores) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.autor = autor;
        this.aptoParaMenores = aptoParaMenores;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isAptoParaMenores() {
        return aptoParaMenores;
    }

    public void setAptoParaMenores(boolean aptoParaMenores) {
        this.aptoParaMenores = aptoParaMenores;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.usuario);
        hash = 19 * hash + Objects.hashCode(this.nombre);
        hash = 19 * hash + Objects.hashCode(this.autor);
        hash = 19 * hash + (this.aptoParaMenores ? 1 : 0);
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
        final Documento other = (Documento) obj;
        if (this.aptoParaMenores != other.aptoParaMenores) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.autor, other.autor);
    }
    
    public String guardaAtributos(){
        return usuario + "," + nombre + "," + autor + "," + aptoParaMenores;
    }

    @Override
    public String toString() {
        return "Documento{" + "usuario=" + usuario + ", nombre=" + nombre + ", autor=" + autor + ", aptoParaMenores=" + aptoParaMenores + '}';
    }

    
    
    
}
