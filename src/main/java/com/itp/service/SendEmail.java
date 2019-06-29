package com.itp.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	public static void main(String[] args) {
		
		System.out.println("Ready to send message...");
		
		String to =  "dissanayakechamod@gmail.com";
		final String from ="chamoddissanayake001@gmail.com";
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port",587);
	
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, "0777735712");
			}
		});
		
		try {
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("This is test subject line!");
			message.setText("This is test mail\n\n\nThis ");
			
			properties.put("mail.smtp.starttls.enable", "true");
			Transport.send(message);
			System.out.println("Message sent successfully");
		}catch(MessagingException mex) {
			mex.printStackTrace();
		}
		
	}
}
