package br.com.justino.cursomc.ionic.backend.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import br.com.justino.cursomc.ionic.backend.domain.Categoria;
import org.hibernate.validator.constraints.Length;

public class CategoriaDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="preenchimento obrigatório do Nome")
	@Length(min=5,max=80, message = "O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}
	
	public CategoriaDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	
	
	
	
}
