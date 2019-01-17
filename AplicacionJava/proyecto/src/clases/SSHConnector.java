/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JOptionPane;

/**
 * Clase encargada de establecer conexión y ejecutar comandos SSH.
 */
public class SSHConnector {

    private static final String ENTER_KEY = "\n";

    private Session session;

    public SSHConnector() {
    }

    public void connect(User user, PE pe, int port)
            throws JSchException, IllegalAccessException {
        if (this.session == null || !this.session.isConnected()) {
            JSch jsch = new JSch();

            this.session = jsch.getSession(user.getUser_router(), pe.getDireccionIP(), port);
            this.session.setPassword(user.getPass_router());

            // Parametro para no validar key de conexion.
            this.session.setConfig("StrictHostKeyChecking", "no");

            this.session.connect();
            //JOptionPane.showMessageDialog(null, "SE INICIO SESION AL HOST");
            System.out.println("nueva sesion");
        } else {

            throw new IllegalAccessException("Sesion SSH ya iniciada.");
        }
    }
    
    public final String executeCommand(String comandos)
        throws IllegalAccessException, JSchException, IOException {
        if (this.session != null && this.session.isConnected()) {
            String[] lineasC=comandos.split(ENTER_KEY);
            // Abrimos un canal SSH. Es como abrir una consola.
            Channel channelExec = (Channel) this.session.openChannel("shell");
            
            OutputStream out= channelExec.getOutputStream();
            PrintStream commander = new PrintStream(out, true);

            channelExec .setOutputStream(System.out, true);

            channelExec.connect();
            for(String z:lineasC){
                System.out.print(z+",");
                commander.println(z);    
            }
            System.out.println();
            //Crear Vrf
            
//                commander.println("enable");    
//                commander.println("configure terminal");
//                commander.println("ip vrf CE-ABC");
//                
//                commander.println("end");
//                commander.println("show ip vrf");
        


                
            commander.close();
        
            String salida="";
            if(!comandos.equals("")){
            
//            
//           InputStream in = channelExec.getInputStream();
           InputStream in = channelExec.getInputStream();
           
          
            // Obtenemos el texto impreso en la consola.
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            //StringBuilder builder = new StringBuilder();
            
            String linea;
            
        
              
            while ((linea = reader.readLine()) != null) {
                salida=salida+linea+"\n";      
            }
            
            ;
            }
            // Cerramos el canal SSH.
            channelExec.disconnect();
               
            // Retornamos el texto impreso en la consola.
            
            return salida;
        } else {
            throw new IllegalAccessException("No existe sesion SSH iniciada.");
        }
    }
    

    /**
     * Cierra la sesión SSH.
     */
    public final void disconnect() {
        this.session.disconnect();
        System.out.println("SESION TERMINADA");
    }
    
    public Session getSesion(){
        return this.session;
    }
    
    
    
    
}
