package br.com.commons.util.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.commons.util.models.EmailRequest;

public class EmailService {
public void sendEmail(EmailRequest emailRequest) throws Exception{
	try {
		Email email = new SimpleEmail();
		
		//TODO set email com dados do emailRequest
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("username", "password"));
		email.setSSLOnConnect(true);
		email.setFrom("user@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("foo@bar.com");
		email.send();
	} catch (EmailException e1) {
		e1.printStackTrace();
	}
}
}
