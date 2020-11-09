package br.com.justino.cursomc.ionic.backend.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	
	private List<FieldMessage> erros = new ArrayList<>();

	private static final long serialVersionUID = 1L;

	public ValidationError(Integer status, String msg, Long timestamp) {
		super(status, msg, timestamp);
	}
	
	public List<FieldMessage> getErros() {
		return erros;
	}
	public void addError(String fieldName, String msg) {
		erros.add(new FieldMessage(fieldName, msg));
	}
}
