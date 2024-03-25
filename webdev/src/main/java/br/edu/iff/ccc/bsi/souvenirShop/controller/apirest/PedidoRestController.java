package br.edu.iff.ccc.bsi.souvenirShop.controller.apirest;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.souvenirShop.model.Pedido;
import br.edu.iff.ccc.bsi.souvenirShop.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/api/v1/pedido")
public class PedidoRestController {
	
	@Autowired
	private PedidoService pedidoServ;


	@PostMapping("")
	@ResponseBody
	@Operation(summary = "Adicionar uma compra em expecifíco")
	public String addCompra(String cpfCliente) throws Exception {			
		return pedidoServ.addPedido(cpfCliente);
	}
	
	
	@PutMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Atualizar uma compra em expecifíco")
	public String atualizarCompra(@PathVariable("id") Long pedidoId, Long clienteId, double subtotal, Calendar dataPedido,
			Calendar dataEntrega, String cpfCliente) throws Exception {
		return pedidoServ.atualizarPedido(pedidoId, clienteId, subtotal, dataPedido, dataEntrega, cpfCliente);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Deletar uma compra em expecifíco")
	public String deletarCompra(@PathVariable("id") Long id) throws Exception {
		return pedidoServ.deletarPedido(id);
	}
	
	@GetMapping("")
	@ResponseBody
	@Operation(summary = "Listar todas as compras")
	public List<Pedido> listarCompras() throws Exception {
		return pedidoServ.listarPedidos();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Retornar uma compra em expecifíco")
	public Pedido buscarPedidos(@PathVariable("id") Long id) throws Exception {
		return pedidoServ.buscarPeloId(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	/*
	@PostMapping("/{id}/e_books")
	@ResponseBody
	@Operation(summary = "Adicionar um E-Book em uma compra em expecifíco")
	public String addE_Book(@PathVariable("id") String id, String titulo) throws Exception {
		return CompraServ.addE_Book(id, titulo);
	}
	
	@GetMapping("/{id}/e_books")
	@ResponseBody
	@Operation(summary = "Listar os E-Books de uma compra em expecifíco")
	public List<E_Book> listarE_Books(@PathVariable("id") Long id) throws Exception {
		return CompraServ.ListarEBookPeloIdCompra(id);
	}
	
	@DeleteMapping("/{id}/e_books")
	@ResponseBody
	@Operation(summary = "Deletar um E-Book em uma compra em expecifíco")
	public String removeE_Book(@PathVariable("id") String id, String titulo) throws Exception {
		return CompraServ.removeE_Book(id, titulo);
	}
	
	@PostMapping("/{id}/colecao_e_books")
	@ResponseBody
	@Operation(summary = "Adicionar uma coleção de E-Book em uma compra em expecifíco")
	public String addColecaoE_Book(@PathVariable("id") String id, String serie) throws Exception {
		return CompraServ.addColecaoE_Book(id, serie);
	}
	
	@DeleteMapping("/{id}/colecao_e_books")
	@ResponseBody
	@Operation(summary = "Deletar uma coleção de E-Book em uma compra em expecifíco")
	public String removeColecaoE_Book(@PathVariable("id") String id, String serie) throws Exception {
		return CompraServ.removeColecaoE_Book(id, serie);
	}
	
	@GetMapping("/{id}/colecao_e_books")
	@ResponseBody
	@Operation(summary = "Listar as coleções de E-Book em uma compra em expecifíco")
	public List<Colecao_E_Book> listarColecoesE_Book(@PathVariable("id") Long id) throws Exception {
		return CompraServ.ListarColecaoEBookPeloIdCompra(id);
	}
	
	@PatchMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Finalizar uma compra em expecifíco")
	public String finalizarCompra(@PathVariable("id") Long id) throws Exception {
		return CompraServ.finalizarCompraPeloId(id);
	}
	*/
}
