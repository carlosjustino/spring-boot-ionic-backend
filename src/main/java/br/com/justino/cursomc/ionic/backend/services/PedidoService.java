package br.com.justino.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.justino.cursomc.domain.Cliente;
import br.com.justino.cursomc.domain.Pedido;
import br.com.justino.cursomc.repositories.PedidoRepository;
import br.com.justino.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		
		Optional<Pedido> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
