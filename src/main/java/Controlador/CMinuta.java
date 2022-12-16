/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Conexion;
import com.toedter.calendar.JDateChooser;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class CMinuta {

    public void InsertarMinuta(JTextField pNombreMinuta, JLabel pIdPaciente) {
        Conexion objetoConexion = new Conexion();
        Date fechaActual = new Date();
        String consultaSQL = "Insert into Minuta(Nombre,FechaRegistro,idPaciente) values(?,?,?)";
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consultaSQL);
            cs.setString(1, pNombreMinuta.getText());
            cs.setDate(2, new java.sql.Date(fechaActual.getTime()));
            cs.setInt(3, Integer.parseInt(pIdPaciente.getText()));
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se registro la minuta");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void ObtenerIdMinuta(JLabel pIdMinuta) {
        Conexion objetoConexion = new Conexion();
        try {
            CallableStatement cmd = objetoConexion.establecerConexion().prepareCall("{CALL ObtenerIdMinuta}");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                pIdMinuta.setText(rs.getString(1));
            }
            System.out.println("Se obtuvo id Minuta");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    public void InsertarDetalleMinuta(JLabel pIdMinuta, JTextField pIdMenu, JComboBox pDia){
     Conexion objetoConexion = new Conexion();
       
        String consultaSQL = "Insert into DetalleMinuta(idMinuta,idMenu,Dia) values(?,?,?)";
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consultaSQL);
            cs.setInt(1, Integer.parseInt(pIdMinuta.getText()));
            cs.setInt(2, Integer.parseInt(pIdMenu.getText()));
            cs.setString(3, pDia.getSelectedItem().toString());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se guardo el menu para el dia: " + pDia.getSelectedItem().toString());
            //Validacion para no repetir dia
            int numeroIndex=0;
            numeroIndex = pDia.getSelectedIndex();
            pDia.removeItemAt(numeroIndex);
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

//Link: https://learn.microsoft.com/es-es/sql/connect/jdbc/using-a-stored-procedure-with-output-parameters?view=sql-server-ver16
    
    public DefaultComboBoxModel llenar(JLabel pCantKcal) {
        Conexion objetoConexion = new Conexion();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Menus recomendados");

        //Modificando el valor para minimo y maximo
        int valor = Integer.parseInt(pCantKcal.getText());
        int valormin = 0, valormax = 0;
        valormin = valor - 200;
        valormax = valor + 200;
        try {
            CallableStatement cmd = objetoConexion.establecerConexion().prepareCall("{CALL SP_COMBO_MENU(?,?)}");
            //{call procedure-name[([parameter][,[parameter]]...)]}
            cmd.setInt(1, valormin);
            cmd.setInt(2, valormax);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                modelo.addElement(rs.getString(1) + " - " + rs.getString(2));
            }
            System.out.println("Se logro ejecutar procedimiento almancenado");
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return modelo;
    }

    //Metodo donde se muestran los detalles del menu seleccionado
    public void mostrarMenus(JLabel pDesayuno, JLabel pAlmuerzo, JLabel pCena, JLabel pKcant, JTextField pidMenu) throws SQLException {
        //Crear objeto de la clase conexión
        Conexion objetoConexion = new Conexion();

        //Variable sql para consulta
        String sql = "SELECT        DetalleMenu.Desayuno, DetalleMenu.Almuerzo, DetalleMenu.Cena, Menu.cantKcal\n"
                + "FROM            DetalleMenu INNER JOIN\n"
                + "                         Menu ON DetalleMenu.idMenu = Menu.idMenu\n"
                + "where DetalleMenu.idMenu like ?;";

        PreparedStatement pstatement = null;
        String[] datos = new String[4];

        try {
            pstatement = objetoConexion.establecerConexion().prepareStatement(sql);
            //pstatement = connection.prepareStatement(sql);
            pstatement.setString(1, pidMenu.getText());
            ResultSet rs = pstatement.executeQuery();

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                pDesayuno.setText(datos[0]);
                pAlmuerzo.setText(datos[1]);
                pCena.setText(datos[2]);
                pKcant.setText(datos[3]);

            }

        } catch (Exception e) {
            System.out.println("error" + e);
        }

    }
    
     //Metodo para mostrar pacientes
    public void mostrarDetalleMinuta(JTable paramTablaDetalleMinuta,JLabel pIdMinuta) {
        //Crear objeto de la clase conexión
        Conexion objetoConexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();
        //Variable sql para consulta
        String sql = "";
        modelo.addColumn("DIA");
        modelo.addColumn("Desayuno");
        modelo.addColumn("Almuerzo");
        modelo.addColumn("Cena");
        paramTablaDetalleMinuta.setModel(modelo);

        sql = "SELECT        DetalleMinuta.Dia, DetalleMenu.Desayuno, DetalleMenu.Almuerzo, DetalleMenu.Cena\n" +
"FROM            DetalleMenu INNER JOIN\n" +
"                         Menu ON DetalleMenu.idMenu = Menu.idMenu INNER JOIN\n" +
"                         DetalleMinuta ON Menu.idMenu = DetalleMinuta.idMenu INNER JOIN\n" +
"                         Minuta ON DetalleMinuta.idMinuta = Minuta.idMinuta where DetalleMinuta.idMinuta like ? order by Minuta.FechaRegistro";

        //Matriz
        String[] datos = new String[4];
        PreparedStatement pstatement = null;

        try {
            pstatement = objetoConexion.establecerConexion().prepareStatement(sql);
            //pstatement = connection.prepareStatement(sql);
            pstatement.setString(1, pIdMinuta.getText());
            ResultSet rs = pstatement.executeQuery();

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                modelo.addRow(datos);
            }
            paramTablaDetalleMinuta.setModel(modelo);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
