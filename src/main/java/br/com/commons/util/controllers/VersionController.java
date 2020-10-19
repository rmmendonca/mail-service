package br.com.commons.util.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version")
public class VersionController {
	
	@Autowired
	BuildProperties buildProperties;
	
	@GetMapping
	public ResponseEntity<BuildProperties> version(){
		return new ResponseEntity<BuildProperties>(buildProperties, HttpStatus.OK);
	}
}
