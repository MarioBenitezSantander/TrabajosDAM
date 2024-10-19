package ad_ut1_act09;

import java.io.Serializable;

/**
 *
 * @author Mario
 */
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String marca;
    private String modelo;
    private String anno;
    private String color;
    private boolean pinturaMetalizada;

    public Vehiculo(String marca, String modelo, String anno, String color, boolean pinturaMetalizada) {
        this.marca = marca;
        this.modelo = modelo;
        this.anno = anno;
        this.color = color;
        this.pinturaMetalizada = pinturaMetalizada;
    }

    public Vehiculo() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isPinturaMetalizada() {
        return pinturaMetalizada;
    }

    public void setPinturaMetalizada(boolean pinturaMetalizada) {
        this.pinturaMetalizada = pinturaMetalizada;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", anno=" + anno + ", color=" + color + ", pinturaMetalizada=" + pinturaMetalizada + '}';
    }
    
    
    
}
