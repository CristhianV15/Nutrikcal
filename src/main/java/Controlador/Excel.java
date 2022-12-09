/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author crist
 */
public class Excel {
    public void CrearExcel() throws FileNotFoundException, IOException{
        //Crear hoja en blanco
        XSSFWorkbook workbook = new XSSFWorkbook();
        
        FileOutputStream out= new FileOutputStream(new File("Nuevolibro.xlsx"));
        
        workbook.write(out);
        out.close();
        System.out.println("Se creo exitoso");
    }
    public void exportarExcel(JTable t) throws IOException{
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter= new FileNameExtensionFilter("Archivo_excel","xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            String ruta= chooser.getSelectedFile().toString().concat(".xls");
            try{
               File archivoXLS= new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo=new FileOutputStream(archivoXLS);
                Sheet hoja=libro.createSheet("Pacientes");
                hoja.setDisplayGridlines(false);
                for (int i = 0; i < t.getRowCount(); i++) {
                    Row fila=hoja.createRow(i);
                    for (int j = 0; j <  t.getColumnCount(); j++) {
                        Cell celda= fila.createCell(j);
                        if(i==0){
                            celda.setCellValue(t.getColumnName(j));
                        }
                    }
                }
                int filaInicio=1;
                for (int i = 0; i < t.getRowCount(); i++) {
                    Row fila =hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int j = 0; j < t.getColumnCount(); j++) {
                        Cell celda=fila.createCell(j);
                        if (t.getValueAt(i, j) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(i, j).toString()));
                        }else if(t.getValueAt(i, j) instanceof Float){
                            celda.setCellValue(Float.parseFloat((String) t.getValueAt(i, j)));
                        }else{
                            celda.setCellValue(String.valueOf(t.getValueAt(i, j)));
                        }
                    }
                }
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            }
            catch (Exception e){
                System.out.println("Error" +e);
            }
            finally {
                System.out.println("erorr" ) ;
            }
        }
    } 
}
