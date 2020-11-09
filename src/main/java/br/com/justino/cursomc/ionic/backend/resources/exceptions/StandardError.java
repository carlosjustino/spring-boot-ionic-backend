package br.com.justino.cursomc.ionic.backend.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer status;
	private String message;
	private Long timestamp;
	public StandardError(Integer status, String msg, Long timestamp) {
		super();
		this.status = status;
		this.message = msg;
		this.timestamp = timestamp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String msg) {
		this.message = msg;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
