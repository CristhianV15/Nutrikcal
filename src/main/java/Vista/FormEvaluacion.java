/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.CEvaluacion;
import Controlador.CMenu;
import Controlador.Correo;
import javax.swing.JOptionPane;
import Modelo.Reportes;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author crist
 */
public class FormEvaluacion extends javax.swing.JFrame {

    /**
     * Creates new form FormEvaluacion
     */
    public FormEvaluacion() {
        initComponents();
        llenarComboNutricionista();
        //Ocultar Campos
        txtCodigoPaciente.hide();
        idNutricionista.hide();
        lblCorreoUno.hide();
        txtKcalDoble.hide();
        
        //Deshabilitar campos&&botones
        txtSexoP.setEnabled(false);
        btnGuardar.setEnabled(false);
        txtEdadP.setEnabled(false);
        btnCrearMinutas.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTalla = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LbNombrePac = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEdadP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSexoP = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        lblKcal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboNutricionista = new javax.swing.JComboBox<>();
        idNutricionista = new javax.swing.JLabel();
        txtCodigoPaciente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEvaluacion = new javax.swing.JTable();
        btnMostrar = new javax.swing.JButton();
        btnExportarHistorial = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnCrearMinutas = new javax.swing.JButton();
        txtKcalDoble = new javax.swing.JLabel();
        lblCorreoUno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Paciente"));

        jLabel1.setText("Nombre del paciente");

        jLabel2.setText("Talla:");

        jLabel3.setText("Peso:");

        LbNombrePac.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LbNombrePac.setText("jLabel4");

        jLabel4.setText("Edad:");

        jLabel5.setText("Sexo:");

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel6.setText("Nutricionista:");

        cboNutricionista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboNutricionistaMouseClicked(evt);
            }
        });
        cboNutricionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNutricionistaActionPerformed(evt);
            }
        });

        idNutricionista.setText("idNu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(idNutricionista)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblMensaje)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblKcal)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboNutricionista, 0, 183, Short.MAX_VALUE)
                                            .addComponent(txtSexoP)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnCalcular)
                                            .addComponent(btnGuardar))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEdadP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                    .addComponent(txtPeso, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTalla)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LbNombrePac))
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LbNombrePac))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtEdadP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSexoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboNutricionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCalcular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(idNutricionista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblKcal)
                            .addComponent(lblMensaje))
                        .addGap(44, 44, 44))))
        );

        txtCodigoPaciente.setText("et");

        tbEvaluacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbEvaluacion);

        btnMostrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMostrar.setText("Mostrar historial del paciente");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnExportarHistorial.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExportarHistorial.setText("Exportal historial");
        btnExportarHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarHistorialActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVolver.setText("Volver a Pacientes");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnCrearMinutas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCrearMinutas.setText("ASIGNAR MINUTAS");
        btnCrearMinutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearMinutasActionPerformed(evt);
            }
        });

        txtKcalDoble.setText("jLabel7");

        lblCorreoUno.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(txtKcalDoble)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(txtCodigoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMostrar)
                                .addGap(18, 18, 18)
                                .addComponent(btnExportarHistorial)
                                .addGap(32, 32, 32)
                                .addComponent(btnVolver))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblCorreoUno)
                        .addGap(95, 95, 95)
                        .addComponent(btnCrearMinutas)
                        .addGap(216, 216, 216))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(txtCodigoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtKcalDoble)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrar)
                    .addComponent(btnExportarHistorial)
                    .addComponent(btnVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearMinutas)
                    .addComponent(lblCorreoUno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public int Formula(int edad, double peso, int altura, String sexo) {
        
        Integer valor = 0;
        if (sexo.equalsIgnoreCase("Masculino")) {
            valor = 5;
        } else {
            valor = -161;
        }
        int resultado = (int) ((10 * peso) + (6.25 * altura) - (5 * edad) + valor);
        System.out.println("El resultado es : " + resultado + "a consumir");
        return resultado + 300;
    }
    
    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:
        lblMensaje.setText("Kcal diarias recomendadas");
        Integer kcal = 0;
        //Variables
        int edad = Integer.parseInt(txtEdadP.getText());
        double peso = Double.parseDouble(txtPeso.getText());
        int altura = Integer.parseInt(txtTalla.getText());
        String sexo= txtSexoP.getText();
        kcal = Formula(edad,peso,altura,sexo);
        lblKcal.setText(kcal.toString());
        btnGuardar.setEnabled(true);
        txtKcalDoble.setText(kcal.toString());
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        CEvaluacion objetoEvaluacion = new CEvaluacion();
        objetoEvaluacion.InsertarEvaluacion(txtTalla, txtPeso, txtCodigoPaciente, idNutricionista, lblKcal);
        btnCrearMinutas.setEnabled(true);
        CEvaluacion objetoPaciente = new CEvaluacion();
        objetoPaciente.mostrarEvaluacion(txtCodigoPaciente, tbEvaluacion);
        btnGuardar.setEnabled(false);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cboNutricionistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboNutricionistaMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_cboNutricionistaMouseClicked

    private void cboNutricionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNutricionistaActionPerformed
        // TODO add your handling code here:
        String Nutricionista = "";
        Nutricionista = cboNutricionista.getSelectedItem().toString();
        String idNutricionistaa = Nutricionista.substring(0, 1);
        idNutricionista.setText(idNutricionistaa);
        
    }//GEN-LAST:event_cboNutricionistaActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        CEvaluacion objetoPaciente = new CEvaluacion();
        objetoPaciente.mostrarEvaluacion(txtCodigoPaciente, tbEvaluacion);
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Paciente fPaciente = new Paciente();
        fPaciente.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnExportarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarHistorialActionPerformed
        
        Reportes r = new Reportes();
        try {
            r.mostrarReporteNutricional("../reporteJasper/reporteTodosNutricional.jasper");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error.. " + e.getMessage());
        }

//       Correo objetoCorreo= new Correo();
//      
//        try {
//            objetoCorreo.enviarCorreo("dbrf.jrrhz65@nefyp.com");
//        } catch (MessagingException ex) {
//            Logger.getLogger(FormEvaluacion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
       
    }//GEN-LAST:event_btnExportarHistorialActionPerformed

    private void btnCrearMinutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearMinutasActionPerformed
        // TODO add your handling code here:
        FormMinuta fMinuta = new FormMinuta();
        //Se muestra el formulario
        fMinuta.setVisible(true);
        fMinuta.txtNombrePacienteGl.setText(LbNombrePac.getText());
        fMinuta.lblKcalRecomendadasG.setText(lblKcal.getText());
        fMinuta.lblCodigo.setText(txtCodigoPaciente.getText());
        fMinuta.lblCorreoTres.setText(lblCorreoUno.getText());
        dispose();
    }//GEN-LAST:event_btnCrearMinutasActionPerformed

    public void llenarComboNutricionista() {
        CEvaluacion objetoEvaluacion = new CEvaluacion();
        cboNutricionista.setModel(objetoEvaluacion.llenar());
    }

    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormEvaluacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormEvaluacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormEvaluacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormEvaluacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormEvaluacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel LbNombrePac;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCrearMinutas;
    private javax.swing.JButton btnExportarHistorial;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cboNutricionista;
    private javax.swing.JLabel idNutricionista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblCorreoUno;
    private javax.swing.JLabel lblKcal;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTable tbEvaluacion;
    public static javax.swing.JTextField txtCodigoPaciente;
    public static javax.swing.JTextField txtEdadP;
    public static javax.swing.JLabel txtKcalDoble;
    private javax.swing.JTextField txtPeso;
    public static javax.swing.JTextField txtSexoP;
    private javax.swing.JTextField txtTalla;
    // End of variables declaration//GEN-END:variables
}
