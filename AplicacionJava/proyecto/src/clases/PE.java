/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author HOME
 */
public class PE {
    String nombre;
    String ciudad;
    String direccionIP;

    public PE(String nombre, String ciudad, String direccionIP) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccionIP = direccionIP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccionIP() {
        return direccionIP;
    }

    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    @Override
    public String toString() {
        return "PE{" + "nombre=" + nombre + ", ciudad=" + ciudad + ", direccionIP=" + direccionIP + '}';
    }
    
}
