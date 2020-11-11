package br.com.justino.cursomc.ionic.backend.domain.enums;

public enum Perfil {
	
	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");
	
	private int codigo;
	private String descricao;
	
	Perfil(Integer codigo, String nome){
		this.codigo = codigo;
		this.descricao = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil toEnum(Integer codigo) {
		if (codigo == null) 
			return null;
		
		for (Perfil tc : Perfil.values()) {
			if ( codigo.equals(tc.getCodigo()))
				return tc;
		}
		
		throw new IllegalArgumentException("Id invalido! Id: " + codigo );
	}
	
}
