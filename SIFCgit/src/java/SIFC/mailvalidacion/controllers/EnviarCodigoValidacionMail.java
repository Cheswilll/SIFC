/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.mailvalidacion.controllers;


import SIFC.util.*;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author APRENDIZ
 */
public class EnviarCodigoValidacionMail {
    
   public final static String HOST_EMAIL_GMAIL = "smtp.gmail.com";
   private String nombresyAp;
   private String telefono;
   private String email;
   private String asunto;
   private String contenido;
   private String codigoValidacion;
   private String asuntoAns;
   private String contenidoAns;
   private String mensaje;
   private String  emailRemitente;
   private String  passRemitente;
   private String emailDestinatario;
    
    private Session session;
    private MimeMessage mimeMessage;

    public EnviarCodigoValidacionMail() {
    }

    public EnviarCodigoValidacionMail(String emailRemitente, String passRemitente, String emailDestinatario, String nombresyAp, String telefono, String email, String asunto, String mensaje) {
        this.nombresyAp = nombresyAp;
        this.telefono = telefono;
        this.email = email;
        this.mensaje = mensaje;
        this.emailRemitente = emailRemitente;
        this.passRemitente = passRemitente;
        this.emailDestinatario = emailDestinatario;
       
    }

    public EnviarCodigoValidacionMail(String nombresyAp, String telefono, String codigoValidacion, String mensaje, String emailRemitente, String passRemitente, String emailDestinatario) {
        this.nombresyAp = nombresyAp;
        this.telefono = telefono;
        this.codigoValidacion = codigoValidacion;
        this.mensaje = mensaje;
        this.emailRemitente = emailRemitente;
        this.passRemitente = passRemitente;
        this.emailDestinatario = emailDestinatario;
    }

    public EnviarCodigoValidacionMail(String nombresyAp, String codigoValidacion, String emailRemitente, String passRemitente, String email) {
        this.nombresyAp = nombresyAp;
        this.codigoValidacion = codigoValidacion;
        this.emailRemitente = emailRemitente;
        this.passRemitente = passRemitente;
        this.email = email;
    }
    
    
    
    
    
    

    
    
   
    public String getNombresyAp() {
        return nombresyAp;
    }

    public void setNombresyAp(String nombresyAp) {
        this.nombresyAp = nombresyAp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEmailRemitente() {
        return emailRemitente;
    }

    public void setEmailRemitente(String emailRemitente) {
        this.emailRemitente = emailRemitente;
    }

    public String getPassRemitente() {
        return passRemitente;
    }

    public void setPassRemitente(String passRemitente) {
        this.passRemitente = passRemitente;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getCodigoValidacion() {
        return codigoValidacion;
    }

    public void setCodigoValidacion(String codigoValidacion) {
        this.codigoValidacion = codigoValidacion;
    }
    
    
    private void basic(){
    
        try {
            Properties propierties = new Properties();
            
            propierties.setProperty("mail.smtp.host", HOST_EMAIL_GMAIL);
            propierties.setProperty("mail.smtp.starttls.enable", "true");
            propierties.setProperty("mail.smtp.port", "25"); //587-25
            propierties.setProperty("mail.smtp.user", getEmailRemitente());
            propierties.setProperty("mail.smtp.auth", "true");
            
            session = Session.getDefaultInstance(propierties);
            mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(getEmailRemitente()));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(getEmailDestinatario()));
        } catch (MessagingException messagingException) {
            
        }
       
         
    }
     private void answer(){
    
        try {
            Properties propierties = new Properties();
            
            propierties.setProperty("mail.smtp.host", HOST_EMAIL_GMAIL);
            propierties.setProperty("mail.smtp.starttls.enable", "true");
            propierties.setProperty("mail.smtp.port", "25"); //587-25
            propierties.setProperty("mail.smtp.user", getEmailRemitente());
            propierties.setProperty("mail.smtp.auth", "true");
            
            session = Session.getDefaultInstance(propierties);
            mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(getEmailRemitente()));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(this.email));
        } catch (MessagingException messagingException) {
            
        }
        
         
    }
    private void massive(){
    
        try {
             Properties propierties = new Properties();
            
            propierties.setProperty("mail.smtp.host", HOST_EMAIL_GMAIL);
            propierties.setProperty("mail.smtp.starttls.enable", "true");
            propierties.setProperty("mail.smtp.port", "25"); //587-25
            propierties.setProperty("mail.smtp.user", getEmailRemitente());
            propierties.setProperty("mail.smtp.auth", "true");
            
            session = Session.getDefaultInstance(propierties);
            mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(getEmailRemitente()));
            mimeMessage.setRecipients(Message.RecipientType.TO, getEmailDestinatario());
        
        } catch (MessagingException messagingException) {
            
        }
        
         
    }
    
    public boolean enviarBasic(){
    
        this.asunto = "Nos ha escrito " + this.nombresyAp;
        this.contenido = "<h1>Tienes una pregunta de " + this.nombresyAp
          + "</h1>" + "</br><p>Nombres y apellidos: " + this.nombresyAp +"</p>" + "</br> <p> Telefono de contacto: " + this.telefono
          + "</p>" + "</br><p>Correo electronico: "+ this.email+"</br><p>Este es el mensaje: " + this.mensaje;
                        
        try {
           basic();
        
            mimeMessage.setSubject(this.asunto);
            mimeMessage.setContent(this.contenido, "text/html");
            Transport transport = session.getTransport("smtp");
            transport.connect(getEmailRemitente(), getPassRemitente());
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            return true;
            
        } catch (MessagingException messagingException) {
        
        return false;
        }
    }
      public boolean enviarAnswer(){
    
        this.asuntoAns = "Hola! " + this.nombresyAp +" gracias por hacer parte de Caterpillar Motor ";
        this.contenidoAns = 
          "<h1>Mediante este correo te informamos el codigo asignado para que realices la matricula</h1>" +
       "<p>En la seccion formulario te pedira un codigo de validacion, </br> ingresa el codigo encontrado en este correo</p>"+
          "</br><p>Codigo: " + this.codigoValidacion +"</p>" + "</p>" + "<p><b>Este correo se genero automaticamente, por favor no responder este mensaje.</b></p>";
                        
        try {
            answer();
        
            mimeMessage.setSubject(this.asuntoAns);
            mimeMessage.setContent(this.contenidoAns, "text/html");
            Transport transport = session.getTransport("smtp");
            transport.connect(getEmailRemitente(), getPassRemitente());
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            return true;
            
        } catch (MessagingException messagingException) {
        
        return false;
        }
    }
    
    
    public boolean enviarMassive(String asunto, String contenido){
    
    
        try {
        massive();
            mimeMessage.setSubject(asunto);
            mimeMessage.setContent(contenido, "text/html");
            Transport transport = session.getTransport("smtp");
            transport.connect(getEmailRemitente(), getPassRemitente());
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            return true;
            
        } catch (MessagingException e) {
      e.printStackTrace();
        return false;
        }
    }

    
    
    
    
}
