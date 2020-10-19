package br.com.commons.util.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;

import br.com.commons.util.models.EmailRequest;

@Service
public class EmailService {
	public void sendEmailHtml(EmailRequest emailRequest) throws Exception {
		try {
			HtmlEmail emailHtml = new HtmlEmail();

			// set email com dados do emailRequest
			setEmailWithEmailRequest(emailHtml, emailRequest);


			emailHtml.send();
			
		} catch (EmailException e1) {
			e1.printStackTrace();
		}
	}
	
	private void setEmailWithEmailRequest(HtmlEmail email, EmailRequest emailRequest) throws Exception{
		try {
			email.setHostName(emailRequest.getHostName());
			email.setSmtpPort(emailRequest.getSmptPort());
			email.setAuthenticator(new DefaultAuthenticator(emailRequest.getUsername(), emailRequest.getPassword()));
			email.setSSLOnConnect(emailRequest.isSslOnConnect());
			email.setFrom(emailRequest.getFrom());
			email.setSubject(emailRequest.getSubject());
			email.setHtmlMsg(emailRequest.getMsg());
			email.addTo(emailRequest.getTo());
		} catch (EmailException e) {
			e.printStackTrace();
		}
		
	}
}
