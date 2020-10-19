package br.com.commons.util.models;

import lombok.Data;

@Data
public class EmailRequest {
	public EmailRequest() {
	}
	
	private String hostName;
	private int smptPort;
	private String username;
	private String password;
	private boolean sslOnConnect;
	private String from;
	private String subject;
	private String msg;
	private String to;
}
