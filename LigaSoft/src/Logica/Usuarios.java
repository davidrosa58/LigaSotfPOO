/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.ConexionDB;
import GUI.UsuariosGUI;
import javax.swing.JOptionPane;
/**
 *
 * @author Angel Santiago Trochez
 */
public class Usuarios implements Personas {

    private String nombreCompleto;
    private String sexo;
    private int edad;
    private String usuario;
    private String contrasena;
    private String tipoUsuario;
    
    
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    public int getEdad() {
        return this.edad;
    }

    public String getSexo() {
        return this.sexo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public String getUsuario() {
        return usuario;
    }

   public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
   
   //insertar nuevos usuarios a la base de datos alojada en un server Postgresql 11
   public void agregarUsuario(int idUsuario,String NombreCompleto, String Sexo, int Edad, String Usuario, String Contrasena, String TipoUsuario){
      ConexionDB nuevaConexion = new ConexionDB();
      try{
          nuevaConexion.st =  nuevaConexion.conexion.createStatement();
          int z = nuevaConexion.st.executeUpdate("INSERT INTO public.usuarios"+"(idusuario, nombrecompleto, sexo, edad, usuario, contrasena, tipousuario)"              
                  + "VALUES" + "("+idUsuario+","
                                 +NombreCompleto+","
                                 +Sexo+","
                                 +Edad+","
                                 +Usuario+","
                                 +Contrasena+","
                                 +TipoUsuario+")");         
          if(z==1){
               JOptionPane.showMessageDialog(null, "Registro Exitoso", "Ingreso de Usuarios",JOptionPane.OK_OPTION);
          }else{
              JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar el usuario", "Ingreso de Usuarios",JOptionPane.OK_OPTION);
          }
      }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Problemas de Conexión", "Error de Conexión",JOptionPane.ERROR_MESSAGE);
      }
   }
           
}
