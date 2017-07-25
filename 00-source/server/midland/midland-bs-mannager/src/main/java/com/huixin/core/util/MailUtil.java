package com.huixin.core.util;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.huixin.web.model.Mail;

public class MailUtil {

	
	public static void send(Mail mail){
		Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", mail.getHost());
        
        final String username1 = mail.getUsername();
        final String password1 = mail.getPassword();
        
        Session session = Session.getInstance(props, 
                new javax.mail.Authenticator(){
             protected PasswordAuthentication getPasswordAuthentication() {
                   return new PasswordAuthentication(username1, password1);
           }
        });   
        
        Message message = new MimeMessage(session);
        try {
        	
			message.setFrom(new InternetAddress(mail.getFrom()));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail.getTo()));
	        message.setSubject(mail.getSubject());
	        
	        Multipart multipart = new MimeMultipart();

	        BodyPart htmlPart = new MimeBodyPart();
	        htmlPart.setContent(mail.getContent(), "text/html; charset=UTF-8");
	        multipart.addBodyPart(htmlPart);
	        
	        message.setContent(multipart);
	        Transport.send(message);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}        
        
	}

}
