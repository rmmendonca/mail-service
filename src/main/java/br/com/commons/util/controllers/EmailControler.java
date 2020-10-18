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
public class EmailControler {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping
	public ResponseEntity<EmailRequest> send(@RequestBody EmailRequest emailRequest){
		try {
			emailService.sendEmail(emailRequest);
			return new ResponseEntity<EmailRequest>(emailRequest, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<EmailRequest>(e, HttpStatus.);
		}
		
		//TODO registrar no Kafka o envio
		
	}
	
}
