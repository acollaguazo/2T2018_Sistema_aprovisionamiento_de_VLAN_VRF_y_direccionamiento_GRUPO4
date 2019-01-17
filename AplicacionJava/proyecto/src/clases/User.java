/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author HOME
 */
public class User {

    private String usuario;
    private String contrasena;
    private int privilegio;
    private String user_router;
    private String pass_router;

    public User(String usuario, String contrasena, int privilegio) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.privilegio = privilegio;
        asignacionRouter(privilegio);
    }

    public void asignacionRouter(int privilegio) {
        switch (privilegio) {
            case 15:
                user_router = "admin";
                pass_router = "admin";
                break;
            case 5:
                user_router = "monitoreo";
                pass_router = "monitoreo";
                break;
            default:
                user_router = "admin";
                pass_router = "admin";
                break;
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(int privilegio) {
        this.privilegio = privilegio;
    }

    public String getPass_router() {
        return pass_router;
    }

    public void setPass_router(String pass_router) {
        this.pass_router = pass_router;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUser_router() {
        return user_router;
    }

    public void setUser_router(String user_router) {
        this.user_router = user_router;
    }

    @Override
    public String toString() {
        return "User{" + "usuario=" + usuario + ", contrasena=" + contrasena + ", privilegio=" + privilegio + ", user_router=" + user_router + ", pass_router=" + pass_router + '}';
    }

}
