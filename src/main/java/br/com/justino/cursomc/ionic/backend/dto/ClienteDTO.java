package br.com.justino.cursomc.ionic.backend.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.justino.cursomc.ionic.backend.domain.Cliente;
import br.com.justino.cursomc.ionic.backend.services.validation.ClienteUpdate;

@ClienteUpdate
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	@NotEmpty(message="Campo obrigatório")
	@Length(min=5, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message="Campo obrigatório")
	@Email(message="Email inválido")
	private String email;
	
	
	public ClienteDTO() {
		
	}

	public ClienteDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	
}

