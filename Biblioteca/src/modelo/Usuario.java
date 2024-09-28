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
public class Usuario {
    
    private String nombre;
    private String contrasenna;
    private int edad;

    public Usuario() {
    }

    public Usuario(String nombre, String contrasenna, int edad) {
        this.nombre = nombre;
        this.contrasenna = contrasenna;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.contrasenna);
        hash = 37 * hash + this.edad;
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
        final Usuario other = (Usuario) obj;
        if (this.edad != other.edad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.contrasenna, other.contrasenna);
    }
    
    public String guardaAtributos(){
        return nombre + "," + contrasenna + "," + edad;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", contrasenna=" + contrasenna + ", edad=" + edad + '}';
    }
    
    
    
}
