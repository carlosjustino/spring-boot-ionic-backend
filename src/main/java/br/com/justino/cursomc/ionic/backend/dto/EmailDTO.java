package br.com.justino.cursomc.ionic.backend.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import br.com.justino.cursomc.ionic.backend.domain.Cliente;

public class EmailDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Campo obrigatório")
	@Email(message="Email inválido")
	private String email;
	
	public EmailDTO() {
		
	}

	public EmailDTO(Cliente cliente) {
		super();
		this.email = cliente.getEmail();
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	
}

