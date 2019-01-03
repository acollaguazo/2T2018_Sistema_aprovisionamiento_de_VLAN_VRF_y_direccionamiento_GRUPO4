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

/**
 *
 * @author HOME
 */
public class Conectar {

    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "1234";
    private static final String url = "jdbc:mysql://172.16.0.14:3306/respaldo";

    public Conectar() {
        conn = null;
        try {
            Class.forName(driver).newInstance();
            conn =(Connection) DriverManager.getConnection(url, user, password);

            if (conn != null) {
                System.out.println("CONEXION ESTABLECIDA");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERROR AL CONECTAR" + e);
        } catch (InstantiationException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Connection getConnection() {
        return conn;
    }

    public void desconectar() {
        conn = null;
        if (conn == null) {
            System.out.println("CONEXION TERMINADA");
        }
        
        
    }
    

}
