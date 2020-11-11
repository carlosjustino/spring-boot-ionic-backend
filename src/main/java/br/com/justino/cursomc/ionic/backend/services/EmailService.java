package br.com.justino.cursomc.ionic.backend.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import br.com.justino.cursomc.ionic.backend.domain.Pedido;

@Service
public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}
