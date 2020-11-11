package br.com.justino.cursomc.ionic.backend.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.justino.cursomc.ionic.backend.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

}
