package br.com.justino.cursomc.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2,"Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int codigo;
	private String descricao;
	
	EstadoPagamento(Integer codigo, String nome){
		this.codigo = codigo;
		this.descricao = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer codigo) {
		if (codigo == null) 
			return null;
		
		for (EstadoPagamento tc : EstadoPagamento.values()) {
			if ( codigo.equals(tc.getCodigo()))
				return tc;
		}
		
		throw new IllegalArgumentException("Id invalido para o estado do pagamento! Id: " + codigo );
	}
	
}
