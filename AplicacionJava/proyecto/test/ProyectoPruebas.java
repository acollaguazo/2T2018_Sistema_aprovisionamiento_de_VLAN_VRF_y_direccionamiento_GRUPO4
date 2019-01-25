/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import clases.PE;
import clases.Registro;
import clases.User;
import com.mysql.jdbc.Connection;
import java.util.Scanner;
import junit.framework.Assert;

/**
 *
 * @author admin
 */
public class ProyectoPruebas {
    
    public ProyectoPruebas() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Scanner sc = new Scanner(System.in);
    PE pe;
    User nuevoUsuarioAdmin;
    User nuevoUsuarioMonitoreo;
    
    @Before
    public void setUp() {
        
        //Instancias para PE
        String nombre = sc.nextLine();
        String ciudadPE = sc.nextLine();
        String direccionIP = sc.nextLine();
        String int_vlan=sc.nextLine();
        pe = new PE(nombre,ciudadPE,direccionIP,int_vlan);
        
        //Instancias para User
        String usuarioAdmin = sc.nextLine();
        String usuarioMonitoreo = sc.nextLine();
        String contrasenaAdmin = sc.nextLine();
        String contrasenaMonitoreo = sc.nextLine();
        int privilegioAdmin = sc.nextInt();
        int privilegioMonitoreo = sc.nextInt();
        String user_router = sc.nextLine();
        String pass_router = sc.nextLine();
        nuevoUsuarioAdmin = new User(usuarioAdmin,contrasenaAdmin,privilegioAdmin);
        nuevoUsuarioMonitoreo = new User(usuarioMonitoreo,contrasenaMonitoreo,privilegioMonitoreo);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void pruebaPE(){
        
        Assert.assertEquals("PE",pe.getNombre());
        Assert.assertEquals("UIO",pe.getNombre());
        Assert.assertEquals("192.168.0.9",pe.getNombre());
        
    }
    
    
    @Test
    public void pruebaUser() {
        
        int privilegio = sc.nextInt();
        if(privilegio == nuevoUsuarioAdmin.getPrivilegio()){
            String usuarioAdmin = "admin";
            String contrasenaAdmin = "admin";
            Assert.assertEquals(usuarioAdmin,nuevoUsuarioAdmin.getUsuario());
            Assert.assertEquals(contrasenaAdmin,nuevoUsuarioAdmin.getContrasena());
            
        }
        else if(privilegio == nuevoUsuarioMonitoreo.getPrivilegio()){
            String usuarioMonitoreo = "monitoreo";
            String contrasenaMonitoreo = "monitoreo";
            Assert.assertEquals(usuarioMonitoreo,nuevoUsuarioAdmin.getUsuario());
            Assert.assertEquals(usuarioMonitoreo,nuevoUsuarioAdmin.getContrasena());
        }
        
    }
        
        
}
