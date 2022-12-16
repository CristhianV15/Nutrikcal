    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author crist
 */
public class Correo {
    public void enviarCorreo(String correo,String pNombre, String Pkcal ) throws MessagingException{
        String correoEnviar="anon.utp@gmail.com";
        String contrasena="bdkgcozrdwraegrw";
        String mensaje="probando correo";
        
        Properties objetoPec= new Properties();
        objetoPec.put("mail.smtp.host", "smtp.gmail.com");
        objetoPec.setProperty("mail.smtp.starttls.enable","true");
        objetoPec.put("mail.smtp.port","587");
        objetoPec.setProperty("mail.smtp.port","587");
        objetoPec.put("mail.smtp.user", correoEnviar);
        objetoPec.setProperty("mail.smtp.auth","true");
        
        Session sesion= Session.getDefaultInstance(objetoPec);
        MimeMessage mail = new MimeMessage(sesion);
        
        //SeleccionarAdjunto
        File archivoSeleccionado;
        JFileChooser seleccionarchivo;
        seleccionarchivo= new JFileChooser();
        seleccionarchivo.showOpenDialog(null);
        archivoSeleccionado= seleccionarchivo.getSelectedFile();
        
        //Envio de adjuntos
        BodyPart texto= new MimeBodyPart();
        String TextoEnvio="Hola " +  pNombre + " ,tu nutricionista te ha recomendado " + Pkcal+ " calorias diarias, adjuntamos la minuta recomendada";
        texto.setText(TextoEnvio);
        BodyPart adjunto = new MimeBodyPart();
        adjunto.setDataHandler(new DataHandler(new FileDataSource(archivoSeleccionado)));
        adjunto.setFileName("Minuta.xls");
        MimeMultipart m= new MimeMultipart();
        m.addBodyPart(texto);
        m.addBodyPart(adjunto);
        
        try{
            mail.setFrom(new InternetAddress(correoEnviar));
            mail.addRecipient(Message.RecipientType.TO,new InternetAddress(correo));
            mail.setSubject("Minuta Semanal -- Nutrikcal");
            mail.setText(mensaje);
            mail.setContent(m);
            Transport transporte= sesion.getTransport("smtp");
            transporte.connect(correoEnviar,contrasena);
            transporte.sendMessage(mail,mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
            System.out.println("Enviado ");
        }catch (Exception e){
            System.out.println("Error al enviar correo");
        }
    }

}
