/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HOME
 */
public class Registro {

    Statement stmt;
    PreparedStatement psInsertar;

    public void registrarVLAN(Connection con, int N_vlan, String ciudad, String empresa) {
        try {

            String SQL = "insert into vlan (noRegistro,N_vlan,ciudad,empresa)" + " values(?,?,?,?)";
            stmt = con.createStatement();
            psInsertar = con.prepareStatement(SQL);
            psInsertar.setInt(1, 0);
            psInsertar.setInt(2, N_vlan);
            psInsertar.setString(3, ciudad);
            psInsertar.setString(4, empresa);
            psInsertar.executeUpdate();

            psInsertar.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registrarVRF(Connection con, String nombreVRF, int N_vlan, String ciudad, String empresa) {
        String SQL = "insert into VRF (nombreVRF,empresa,ciudad,vlan)" + " values(?,?,?,?)";
        try {
            
            stmt = con.createStatement();
            psInsertar = con.prepareStatement(SQL);
            psInsertar.setString(1, nombreVRF);
            psInsertar.setString(2, empresa);
            psInsertar.setString(3, ciudad);
            psInsertar.setInt(4, N_vlan);
            psInsertar.executeUpdate();

            psInsertar.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void registrarDireccionamiento(Connection con,String dir_red,String submask_red,String empresa, String ciudad,int vlan,String nombreVRF,String nombrePE, int enlaces) {
        String SQL = "insert into VRF (dir_red,submask_red,empresa,ciudad,vlan,nombreVRF,nombrePE,enlaces)" + " values(?,?,?,?,?,?,?,?)";
        try {
            
            stmt = con.createStatement();
            psInsertar = con.prepareStatement(SQL);
            psInsertar.setString(1, dir_red);
            psInsertar.setString(2, submask_red);
            psInsertar.setString(3, empresa);
            psInsertar.setString(4, ciudad);
            psInsertar.setInt(5, vlan);
            psInsertar.setString(6, nombreVRF);
            psInsertar.setString(7, nombrePE);
            psInsertar.setInt(8, enlaces);
            
            psInsertar.executeUpdate();

            psInsertar.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
