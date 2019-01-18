/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author admin
 */
public class Direccionamiento {
    private String dir_red;
    private String submask_red;
    private String empresa;
    private String ciudad;
    private int vlan;
    private String nombreVRF;
    private String nombrePE;
    private int enlaces;

    public Direccionamiento(String dir_red, String submask_red, String empresa, String ciudad, int vlan, String nombreVRF, String nombrePE, int enlaces) {
        this.dir_red = dir_red;
        this.submask_red = submask_red;
        this.empresa = empresa;
        this.ciudad = ciudad;
        this.vlan = vlan;
        this.nombreVRF = nombreVRF;
        this.nombrePE = nombrePE;
        this.enlaces = enlaces;
    }

    public String getDir_red() {
        return dir_red;
    }

    public void setDir_red(String dir_red) {
        this.dir_red = dir_red;
    }

    public String getSubmask_red() {
        return submask_red;
    }

    public void setSubmask_red(String submask_red) {
        this.submask_red = submask_red;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getVlan() {
        return vlan;
    }

    public void setVlan(int vlan) {
        this.vlan = vlan;
    }

    public String getNombreVRF() {
        return nombreVRF;
    }

    public void setNombreVRF(String nombreVRF) {
        this.nombreVRF = nombreVRF;
    }

    public String getNombrePE() {
        return nombrePE;
    }

    public void setNombrePE(String nombrePE) {
        this.nombrePE = nombrePE;
    }

    public int getEnlaces() {
        return enlaces;
    }

    public void setEnlaces(int enlaces) {
        this.enlaces = enlaces;
    }
    
    
    
}
