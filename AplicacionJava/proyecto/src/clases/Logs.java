/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author HOME
 */
public class Logs {

    public Logs(String mensaje) {
        //Obtener la hora y fecha actual
        //Fecha
        Date sistFecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MMM-YYYY");
        //Hora
        Date sistHora = new Date();
        SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss a");
        Calendar hoy = Calendar.getInstance();

        //Guarda el registro de ingreso del usuario
        try{
            File archivo;
            FileWriter escribir;
            PrintWriter linea;

            archivo = new File("Registro.txt");
            if(!archivo.exists()){
                archivo.createNewFile();
            }
            escribir = new FileWriter(archivo, true);
            linea = new PrintWriter(escribir);
            //escribir fecha y hora
            linea.println(formatoFecha.format(sistFecha)+"  "+String.format(formatoHora.format(sistHora), hoy));
            //escribir usuario que ingreso al sistema
            linea.println(mensaje);

            linea.close();
            escribir.close();



        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al guaradar el registro");
        }

    }   
}