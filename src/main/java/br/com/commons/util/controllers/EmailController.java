package br.com.commons.util.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.commons.util.models.EmailRequest;
import br.com.commons.util.service.EmailService;


@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping
	public ResponseEntity<EmailRequest> send(@RequestBody EmailRequest emailRequest){
		try {
			emailService.sendEmailHtml(emailRequest);
			return new ResponseEntity<EmailRequest>(emailRequest, HttpStatus.CREATED);
		} catch (Exception e) {
			//TODO Tratar possiveis erros
			e.printStackTrace();
			return new ResponseEntity<EmailRequest>(emailRequest, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//TODO registrar no Kafka o envio
		
	}
	
}
