/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

//librerias para la Conexion y uso de la DB 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel Santiago Trochez
 */
public class ConexionDB {
    protected Connection conexion = null;
    protected ResultSet rst = null;
    protected Statement st = null;
    
    public void conexion(){
        if(conexion != null){
            return;
        }
        
        String url="jdbc:postgresql://127.0.0.1:50531/postgres";
        String passwordDB ="abc123**";
        try{
            Class.forName("org.postgresql.Driver");
            
            conexion = DriverManager.getConnection(url,"postgres",passwordDB);
            
            if(conexion != null){
                JOptionPane.showMessageDialog(null, "Error al conectar a la Base de Datos", "Error de Conexión",JOptionPane.ERROR_MESSAGE);
            }
        
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Problemas de Conexión", "Error de Conexión",JOptionPane.ERROR_MESSAGE);
        }
            
            
            
    }   

    
    
    
    
    
    
    
}
