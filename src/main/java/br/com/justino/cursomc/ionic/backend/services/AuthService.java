package br.com.justino.cursomc.ionic.backend.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.justino.cursomc.ionic.backend.domain.Cliente;
import br.com.justino.cursomc.ionic.backend.repositories.ClienteRepository;
import br.com.justino.cursomc.ionic.backend.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();
	
	@Transactional
	public void sendNewPassword(String email) {
		
		Cliente cliente = clienteRepository.findByEmail(email);
		
		if (cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado ou usuário desativado");
		}
		
		String newPass = newPassowrd();
		cliente.setSenha(pe.encode(newPass));
		
		clienteRepository.save(cliente);
		
		emailService.sendNewPasswordEmail(cliente, newPass);
	}

	private String newPassowrd() {
		char[] newPass = new char[10];
		for (int i=0; i<10; i++) {
		   newPass[i] = randomChar();	
		}
		return String.valueOf(newPass);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) {
			return (char) (rand.nextInt(10) + 48);
		}
		else if(opt == 1) {
			return (char) (rand.nextInt(26) + 65);
		} else {
			return (char) (rand.nextInt(26) + 97);
		}
	}
	
}
