/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HOME
 */
public class Consulta {

    public void ejecutarConsultaUser(Connection con) {
        try {
            String SQL = "SELECT * FROM user";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {

                System.out.println(rs.getString("usuario") + ", " + rs.getString("contrasena") + "," + rs.getString("privilegio"));

            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ejecutarConsultaPE(Connection con) {
        try {
            String SQL = "SELECT * FROM providerEdge";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {

                System.out.println(rs.getString("nombrePE")+","+rs.getString("ciudad")+","+rs.getString("direccionIP"));

            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet getResultSetTabla(Connection con,String tabla){
        ResultSet rs=null;
        try {
            String SQL = "SELECT * FROM "+tabla+"";
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
}
