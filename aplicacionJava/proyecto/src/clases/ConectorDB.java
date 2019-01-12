/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HOME
 */
public class ConectorDB {

    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "1234";
    private static final String url = "jdbc:mysql://172.16.0.14:3306/respaldo";

    public ConectorDB() {
        conn = null;
        try {
            Class.forName(driver).newInstance();
            conn =(Connection) DriverManager.getConnection(url, user, password);

            if (conn != null) {
                System.out.println("CONEXION ESTABLECIDA");
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Falla en la conexión con el servidor, inténtelo más tarde");
            System.out.println("Falla en la conexión con el servidor, inténtelo más tarde" + e);
            JOptionPane.showMessageDialog(null, "Falla en la conexión con el servidor, inténtelo más tarde");
        } catch (InstantiationException ex) {
            Logger.getLogger(ConectorDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ConectorDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Connection getConnection() {
        return conn;
    }

    public void desconectar() {
        try {
            conn.close();
            conn = null;
            if (conn == null) {
                System.out.println("CONEXION TERMINADA");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConectorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    

}
