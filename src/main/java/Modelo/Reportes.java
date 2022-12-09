/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.Conexion;
import java.awt.Frame;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author crist
 */
public class Reportes {
    public Reportes(){
        Conexion objetoConexion= new Conexion();
        objetoConexion.establecerConexion();
    }
    public void mostrarReporteNutricional(String link)throws Exception{ 
        Conexion objetoConexion= new Conexion();
      
        try{
        URL in = getClass().getResource(link); 
        JasperReport report= (JasperReport) JRLoader.loadObject(in); 
        JasperPrint print= JasperFillManager.fillReport(report, null,objetoConexion.establecerConexion());
        JasperViewer view=new JasperViewer(print,false);
        view.setExtendedState(Frame.MAXIMIZED_BOTH);
        view.setVisible(true);
            System.out.println("LOGRE EJECUTAR");
        }catch(JRException e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("NO LOGRE EJECUTARME");
        }
    }
}
