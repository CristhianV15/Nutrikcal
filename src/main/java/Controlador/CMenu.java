/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class CMenu {
    //select 2022-YEAR(FechaNac) from Paciente where idPaciente = '1'
    public void mostrarMenu(JTable paramtableMenu) {
        Conexion objetoConexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "";
        modelo.addColumn("Nombre");
        modelo.addColumn("Desayuno");
        modelo.addColumn("Almuerzo");
        modelo.addColumn("Cena");
        modelo.addColumn("Kcant");
        modelo.addColumn("Adicional");
        paramtableMenu.setModel(modelo);

        sql = "SELECT        Menu.Nombre, DetalleMenu.Desayuno, DetalleMenu.Almuerzo, DetalleMenu.Cena, Menu.cantKcal, Menu.DatosAdicionales\n"
                + "FROM            DetalleMenu INNER JOIN\n"
                + "                         Menu ON DetalleMenu.idMenu = Menu.idMenu;";

        //Matriz
        String[] datos = new String[6];
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
                modelo.addRow(datos);
            }
           paramtableMenu.setModel(modelo);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
    
    
    public DefaultComboBoxModel llenar(){
    Conexion objetoConexion = new Conexion();
    DefaultComboBoxModel modelo= new DefaultComboBoxModel();
    modelo.addElement("Seleccionar menus");
    try{
        CallableStatement cmd=objetoConexion.establecerConexion().prepareCall("{CALL SP_COMBO_MENU}");
        ResultSet rs= cmd.executeQuery();
        while(rs.next()){
            modelo.addElement(rs.getString(1) +" - "+ rs.getString(2));
        }
        System.out.println("Se logro ejecutar procedimiento almancenado-menu");
    }catch(Exception e){
        System.out.println("Error");
    }
    return modelo;}
}
