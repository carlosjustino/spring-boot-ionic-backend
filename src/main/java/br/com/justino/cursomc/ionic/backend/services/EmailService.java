package br.com.justino.cursomc.ionic.backend.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.justino.cursomc.ionic.backend.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}
