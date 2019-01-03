/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import interfaces.Prueba;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 *
 * @author HOME
 */
public class Consulta {
    public void ejecutarConsulta(Connection con) {
try {
   String SQL = "SELECT * FROM user";
   Statement stmt = con.createStatement();
   ResultSet rs = stmt.executeQuery(SQL);

   while (rs.next()) {
        Prueba.usuariosBD.add(new User(rs.getString("usuario"),rs.getString("contrasena"), Integer.parseInt(rs.getString("privilegio"))));
        System.out.println(rs.getString("usuario") + ", " + rs.getString("contrasena")+","+rs.getString("privilegio"));
   
}
   
  
  rs.close();
  stmt.close();
}
catch (Exception e) {
  e.printStackTrace();
}
}
}
