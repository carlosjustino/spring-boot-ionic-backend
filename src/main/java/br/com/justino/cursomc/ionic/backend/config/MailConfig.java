package br.com.justino.cursomc.ionic.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	@Bean
    public JavaMailSenderImpl mailSender() {
			return new JavaMailSenderImpl();
	}
}
