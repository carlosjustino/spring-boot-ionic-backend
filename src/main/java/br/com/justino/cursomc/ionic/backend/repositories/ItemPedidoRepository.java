package br.com.justino.cursomc.ionic.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.justino.cursomc.ionic.backend.domain.Categoria;
import br.com.justino.cursomc.ionic.backend.domain.ItemPedido;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{

}
