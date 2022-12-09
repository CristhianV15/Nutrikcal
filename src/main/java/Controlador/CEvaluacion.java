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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class CEvaluacion {
    public DefaultComboBoxModel llenar(){
    Conexion objetoConexion = new Conexion();
    DefaultComboBoxModel modelo= new DefaultComboBoxModel();
    modelo.addElement("Seleccionar nutricionista");
    try{
        CallableStatement cmd=objetoConexion.establecerConexion().prepareCall("{CALL SP_COMBO_NUTRICIONISTAS}");
        ResultSet rs= cmd.executeQuery();
        while(rs.next()){
            modelo.addElement(rs.getString(1) +" - "+ rs.getString(2));
        }
        System.out.println("Se logro ejecutar procedimiento almancenado");
    }catch(Exception e){
        System.out.println("Error");
    }
    return modelo;
}
    
    public void InsertarEvaluacion(JTextField pTalla, JTextField pPeso, JTextField pIdPaciente, JLabel pIdNutricionista, JLabel pKcant) {
        Conexion objetoConexion = new Conexion();
        Date fechaActual= new Date();
        String consultaSQL = "insert into Evaluacion(Talla,Peso,FechEval,idPaciente,idNutricionista,Kcant) values(?,?,?,?,?,?)";
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consultaSQL);
            cs.setString(1, pTalla.getText());
            cs.setString(2, pPeso.getText());
            cs.setDate(3, new java.sql.Date(fechaActual.getTime()));
            cs.setString(4, pIdPaciente.getText());
            cs.setString(5, pIdNutricionista.getText());
            cs.setString(6, pKcant.getText());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se guardo correctamente");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    //Metodo para mostrar el historial de las evaluaciones nutricionales
    public void mostrarEvaluacion(JTextField pIdPaciente,JTable paramTablaEvaluacion) {
        //Crear objeto de la clase conexión
        Conexion objetoConexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();
        //Variable sql para consulta
        String sql = "";
        modelo.addColumn("Talla");
        modelo.addColumn("Peso");
        modelo.addColumn("Fecha Evaluación");
        modelo.addColumn("Kcal recomendadas");
        modelo.addColumn("Nutricionista");
        paramTablaEvaluacion.setModel(modelo);
        sql = "SELECT      Evaluacion.Talla, Evaluacion.Peso, Evaluacion.FechEval, Evaluacion.Kcant, CONCAT(Nutricionista.Nombre, ' ', Nutricionista.Apellido) NombreNutricionista\n" +
"FROM            Evaluacion INNER JOIN\n" +
"                         Nutricionista ON Evaluacion.idNutricionista = Nutricionista.idNutricionista INNER JOIN\n" +
"                         Paciente ON Evaluacion.idPaciente = Paciente.idPaciente\n" +
"						 where Paciente.idPaciente like ?;";
        paramTablaEvaluacion.setModel(modelo);
        PreparedStatement pstatement = null;
        //Matriz
        String[] datos = new String[5];
        try {
            pstatement = objetoConexion.establecerConexion().prepareStatement(sql);
            pstatement.setString(1, pIdPaciente.getText());
            ResultSet rs = pstatement.executeQuery();

            //ResultSet rs = cs.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                modelo.addRow(datos);
            }
            paramTablaEvaluacion.setModel(modelo);
            System.out.println("El id paciente es: " + pIdPaciente.getText());
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        
    }
}
