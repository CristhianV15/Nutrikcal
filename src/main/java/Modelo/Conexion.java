/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class Conexion {
 Connection conectar= null;
 //Variables para credenciales
 String usuario="sa";
 String contrasenia="cr1s99";
 String bd="nutrikcal";
 String ip ="localhost";
 String puerto="1433";
 
 public Connection establecerConexion(){
     try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         String cadena="jdbc:sqlserver://"+ip+":"+puerto+";"+"databaseName="+bd+";"+
         "encrypt=true;trustServerCertificate=true";
         conectar= DriverManager.getConnection(cadena,usuario,contrasenia);
     //    JOptionPane.showMessageDialog(null,"Se conecto correctamente");
     }
     catch(Exception e){
         JOptionPane.showMessageDialog(null, "Fallo en la conexion");
         System.out.println("El fallo fue: "+ e);
     }
     return conectar;
 }
}
            