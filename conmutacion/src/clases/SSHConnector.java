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
    

    public void connect(User user, String host, int port)
        throws JSchException, IllegalAccessException {
        if (this.session == null || !this.session.isConnected()) {
            JSch jsch = new JSch();
 
            this.session = jsch.getSession(user.getUser_router(), host, port);
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
 
            // Abrimos un canal SSH. Es como abrir una consola.
            Channel channelExec = (Channel) this.session.openChannel("shell");
            
            OutputStream out= channelExec.getOutputStream();
            PrintStream commander = new PrintStream(out, true);
            
            channelExec .setOutputStream(System.out, true);

            channelExec.connect();
            System.out.println(comandos);
            commander.println(comandos);
            
            
            commander.close();
        
            
            
//            
//           InputStream in = channelExec.getInputStream();
           InputStream in = channelExec.getInputStream();
           
          
            // Obtenemos el texto impreso en la consola.
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder builder = new StringBuilder();
            
            String linea;
            while ((linea = reader.readLine()) != null) {
                builder.append(linea);
                builder.append(ENTER_KEY);
            } 
            // Cerramos el canal SSH.
            channelExec.disconnect();
               
            // Retornamos el texto impreso en la consola.
            return builder.toString();
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
    
    
}