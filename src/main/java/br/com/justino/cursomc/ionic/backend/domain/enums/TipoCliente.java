package br.com.justino.cursomc.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Juridica");
	
	private int codigo;
	private String descricao;
	
	TipoCliente(Integer codigo, String nome){
		this.codigo = codigo;
		this.descricao = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer codigo) {
		if (codigo == null) 
			return null;
		
		for (TipoCliente tc : TipoCliente.values()) {
			if ( codigo.equals(tc.getCodigo()))
				return tc;
		}
		
		throw new IllegalArgumentException("Id invalido para tipo de cliente! Id: " + codigo );
	}
	
}
