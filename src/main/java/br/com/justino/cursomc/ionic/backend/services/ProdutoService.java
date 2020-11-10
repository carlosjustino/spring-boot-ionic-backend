package br.com.justino.cursomc.ionic.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.justino.cursomc.ionic.backend.domain.Categoria;
import br.com.justino.cursomc.ionic.backend.domain.Pedido;
import br.com.justino.cursomc.ionic.backend.domain.Produto;
import br.com.justino.cursomc.ionic.backend.repositories.CategoriaRepository;
import br.com.justino.cursomc.ionic.backend.repositories.ProdutoRepository;
import br.com.justino.cursomc.ionic.backend.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repo;
	

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Produto find(Integer id) {
		
		Optional<Produto> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}
}
