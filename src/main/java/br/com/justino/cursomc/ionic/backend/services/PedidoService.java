package br.com.justino.cursomc.ionic.backend.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.justino.cursomc.ionic.backend.domain.Cliente;
import br.com.justino.cursomc.ionic.backend.domain.ItemPedido;
import br.com.justino.cursomc.ionic.backend.domain.PagamentoComBoleto;
import br.com.justino.cursomc.ionic.backend.domain.Pedido;
import br.com.justino.cursomc.ionic.backend.domain.enums.EstadoPagamento;
import br.com.justino.cursomc.ionic.backend.repositories.ItemPedidoRepository;
import br.com.justino.cursomc.ionic.backend.repositories.PagamentoRepository;
import br.com.justino.cursomc.ionic.backend.repositories.PedidoRepository;
import br.com.justino.cursomc.ionic.backend.security.UserSS;
import br.com.justino.cursomc.ionic.backend.services.exceptions.AuthorizationException;
import br.com.justino.cursomc.ionic.backend.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EmailService emailService;
	
	public Pedido find(Integer id) {
		
		Optional<Pedido> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		obj.setCliente(clienteService.find(obj.getCliente().getId()));
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pgto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pgto, obj.getInstante());
		}
	
		obj = repo.save(obj);
		
		pagamentoRepository.save(obj.getPagamento());
		
		for(ItemPedido ip : obj.getItens()) {
			ip.setProduto(produtoService.find(ip.getProduto().getId()));
			ip.setDesconto(0.0);
			ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());
			ip.setPedido(obj);
		}
		
		itemPedidoRepository.saveAll(obj.getItens());
		
		emailService.sendOrderConfirmationHtmlEmail(obj);
		return obj;
	}
	
	public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if (user == null)
			throw new AuthorizationException("Acesso negado");
		Cliente cliente = clienteService.find(user.getId()); 
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByCliente(cliente, pageRequest);
	}
}
