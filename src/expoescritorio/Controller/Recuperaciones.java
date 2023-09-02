package expoescritorio.Controller;



import expoescritorio.Models.CodigoRecuperacion;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Recuperaciones {
     public void mandarCorreo(String Correo, String Mns ){
       
        try{
            String correoEmisor = "alessandromorales0822@gmail.com";
            String contraseñaEmisor = "vwxipuzmxzqahkqd";     
            String CorreoReceptor = Correo;
            String asunto = "Recuperación de contraseña";
            String mensaje = Mns;
            
            //Configurar SMTP
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starls.enable", "true");
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.socketFactory.port", "465");
            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

          
            //Configurar el envio
            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoEmisor));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(CorreoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje);

            //Envío del mensaje
            Transport t = session.getTransport("smtp");
            t.connect(correoEmisor, contraseñaEmisor);    
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();
            System.out.println("Se envio");
          
        }catch(Exception e){
            System.out.println(e.toString());
            System.out.println("No se envio");
           
        }
    }
    public static String generateRandomCode() {
        // Definir la longitud de la cadena
        int length = 10;
        // Definir los caracteres permitidos que se utilizarán para generar la cadena aleatoria
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int charsLength = allowedChars.length();
        // Crear una instancia de la clase Random para generar números aleatorios
        Random random = new Random();
        StringBuilder codeBuilder = new StringBuilder(length);
        // Generar la cadena aleatoria
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charsLength);
            char randomChar = allowedChars.charAt(randomIndex);
            codeBuilder.append(randomChar);
        }
        return codeBuilder.toString();// Devolver la cadena aleatoria generada
    }


}
