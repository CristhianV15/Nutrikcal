/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Conexion;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.toedter.calendar.JDateChooser;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author crist
 */
public class CPacientes {

    //Metodo para mostrar pacientes
    public void mostrarPacientes(JTable paramTablaPacientes) {
        //Crear objeto de la clase conexión
        Conexion objetoConexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();
        //Variable sql para consulta
        String sql = "";
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Telefono");
        modelo.addColumn("Correo");
        modelo.addColumn("Sexo");
        modelo.addColumn("Datos Adicionales");
        modelo.addColumn("Fecha nacimiento");
        modelo.addColumn("DNI");
        paramTablaPacientes.setModel(modelo);

        sql = "select * from Paciente where Estado =1;";

        //Matriz
        String[] datos = new String[9];
        Statement st;

        try {
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                modelo.addRow(datos);
            }
            paramTablaPacientes.setModel(modelo);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public void SeleccionarPacientes(JTable paramTablaPacientes, JTextField pCodigo, JTextField pNombre, JTextField pApellido, JTextField pTelefono, JTextField pCorreo, JTextField pSexo, JTextArea pDatosA, JDateChooser pFechaNac, JTextField pDNI, JTextField pFechaString) {     
        
       
        try {
            int fila = paramTablaPacientes.getSelectedRow();
            if (fila >= 0) { //se selecciono                
                pCodigo.setText(paramTablaPacientes.getValueAt(fila, 0).toString());
                pNombre.setText(paramTablaPacientes.getValueAt(fila, 1).toString());
                pApellido.setText(paramTablaPacientes.getValueAt(fila, 2).toString());
                pTelefono.setText(paramTablaPacientes.getValueAt(fila, 3).toString());
                pCorreo.setText(paramTablaPacientes.getValueAt(fila, 4).toString());
                pSexo.setText(paramTablaPacientes.getValueAt(fila, 5).toString());
                pDatosA.setText(paramTablaPacientes.getValueAt(fila, 6).toString());
                //pFechaNac.setDate(dcn);
                pFechaString.setText(paramTablaPacientes.getValueAt(fila, 7).toString());
                //Funciona
                //pFechaNac.setDateFormatString( paramTablaPacientes.getValueAt(fila, 7).toString());
                Date date= new SimpleDateFormat("yyyy-MM-dd").parse((String)paramTablaPacientes.getValueAt(fila, 7));
                pFechaNac.setDate(date);
                pDNI.setText(paramTablaPacientes.getValueAt(fila, 8).toString());
                
            } else {
                System.out.println("No se encontraron registros");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e);
        }
         //Transformar string a date
        String fechaNac = pFechaString.getText();
        pFechaNac.setDateFormatString(fechaNac);
        System.out.println(pFechaString.getText());
        
        
        
    }

    public void InsertarPacientes(JTextField pNombre, JTextField pApellido, JTextField pTelefono, JTextField pCorreo, JTextField pSexo, JTextArea pDatosA, JDateChooser pFechaNac, JTextField pDNI) {
        Conexion objetoConexion = new Conexion();
        //Falta fecha y edad 
        //Transformación de fecha
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
        String date = dcn.format(pFechaNac.getDate());
        String consultaSQL = "insert into Paciente(Nombre,Apellido,Telefono,Correo,Sexo,DatosAdicionales,FechaNac,DNI) values(?,?,?,?,?,?,?,?)";
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consultaSQL);
            cs.setString(1, pNombre.getText());
            cs.setString(2, pApellido.getText());
            cs.setString(3, pTelefono.getText());
            cs.setString(4, pCorreo.getText());
            cs.setString(5, pSexo.getText());
            cs.setString(6, pDatosA.getText());
            cs.setString(7, date);
            cs.setString(8, pDNI.getText());
            //Integer
            //cs.setInt(4, Integer.parseInt(parametro.getTex()));
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se inserto correctamente");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void ModificarPacientes(JTextField pCodigo, JTextField pNombre, JTextField pApellido, JTextField pTelefono, JTextField pCorreo, JTextField pSexo, JTextArea pDatosA, JDateChooser pFechaNac, JTextField pDNI) {
        Conexion objetoConexion = new Conexion();
        //Transformación de fecha
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
        String date = dcn.format(pFechaNac.getDate());
        String consulta = "update Paciente set Nombre=?, Apellido=?, Telefono=?, Correo=?, Sexo=?, DatosAdicionales=?, DNI=?, FechaNac=? where idPaciente=?;";
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, pNombre.getText());
            cs.setString(2, pApellido.getText());
            cs.setString(3, pTelefono.getText());
            cs.setString(4, pCorreo.getText());
            cs.setString(5, pSexo.getText());
            cs.setString(6, pDatosA.getText());
            cs.setString(7, pDNI.getText());
            cs.setString(8, date);
            cs.setInt(9, Integer.parseInt(pCodigo.getText()));

            cs.execute();
            JOptionPane.showMessageDialog(null, "Se modifico correctamente");

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void buscarPaciente(JTextField pDNI, JTable paramTablaPacientes) {
        Conexion objetoConexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "select * from Paciente where DNI=?;";
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Telefono");
        modelo.addColumn("Correo");
        modelo.addColumn("Sexo");
        modelo.addColumn("Datos Adicionales");
        modelo.addColumn("Fecha nacimiento");
        modelo.addColumn("DNI");
        paramTablaPacientes.setModel(modelo);
        PreparedStatement pstatement = null;
        //Matriz
        String[] datos = new String[9];
        try {
            //CallableStatement cs = objetoConexion.establecerConexion().prepareCall(sql);
            //  cs.setInt(1, Integer.parseInt(pCodigo.getText()));
            pstatement = objetoConexion.establecerConexion().prepareStatement(sql);
            //pstatement = connection.prepareStatement(sql);
            pstatement.setString(1, pDNI.getText());
            ResultSet rs = pstatement.executeQuery();

            //ResultSet rs = cs.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                modelo.addRow(datos);
            }
            paramTablaPacientes.setModel(modelo);
            System.out.println("El DNI es: " + pDNI.getText());
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

    public void calcularEdad(JTextField pDNI, JTextField pSexo, JTextField pEdad) {
        Conexion objetoConexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "select 2022-YEAR(FechaNac),Sexo from Paciente where DNI=?;";
        PreparedStatement pstatement = null;
        //Matriz
        String[] datos = new String[2];
        try {
            //CallableStatement cs = objetoConexion.establecerConexion().prepareCall(sql);
            //  cs.setInt(1, Integer.parseInt(pCodigo.getText()));
            pstatement = objetoConexion.establecerConexion().prepareStatement(sql);
            //pstatement = connection.prepareStatement(sql);
            pstatement.setString(1, pDNI.getText());
            ResultSet rs = pstatement.executeQuery();

            //ResultSet rs = cs.executeQuery(sql);
            while (rs.next()) {
                pEdad.setText(rs.getString(1));
                pSexo.setText(rs.getString(2));
                modelo.addRow(datos);
            }
            System.out.println("El DNI es: " + pDNI.getText());
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }
    public void EliminarPacientes(JTextField pCodigo) {
        Conexion objetoConexion = new Conexion();
      
        String consulta = "update Paciente set Estado=0 where idPaciente=?;";
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setInt(1, Integer.parseInt(pCodigo.getText()));
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se elimino correctamente");

        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}

//Hacer un getIndex al combo Y te devuelve la posición en entero
 //A ese resultado le sumas +1 (es decir posición 0 + 1)
//El primer elemento de la tabla que tenga ID 1
