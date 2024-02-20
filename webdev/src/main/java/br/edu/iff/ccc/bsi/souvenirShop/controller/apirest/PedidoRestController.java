package br.edu.iff.ccc.bsi.souvenirShop.controller.apirest;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.souvenirShop.model.Item;
import br.edu.iff.ccc.bsi.souvenirShop.model.Pedido;
import br.edu.iff.ccc.bsi.souvenirShop.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/api/v1/pedido")
public class PedidoRestController {
	
	@Autowired
	private PedidoService pedidoServ;

	@PostMapping
	@ResponseBody
	@Operation(summary = "Adicionar um pedido em específico")
	public ResponseEntity<String> adicionarPedido(@RequestParam Long clienteId, @RequestParam String formaPagamento) {
		try {
			String mensagem = pedidoServ.addPedido(clienteId, formaPagamento);
			return ResponseEntity.ok(mensagem);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar pedido.");
		}
	}

	@PutMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Atualizar um pedido em específico")
	public ResponseEntity<String> atualizarPedido(@PathVariable("id") Long id, @RequestParam Long clienteId,
			@RequestParam float valorTotal,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataPedido,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataEntrega,
			@RequestParam String formaPagamento) {

		try {
			String mensagem = pedidoServ.atualizarPedido(id, clienteId, valorTotal, dataPedido, dataEntrega,
					formaPagamento);
			return ResponseEntity.ok(mensagem);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar pedido.");
		}
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Deletar um pedido em específico")
	public ResponseEntity<String> deletarPedido(@PathVariable("id") Long id) {
		try {
			String mensagem = pedidoServ.deletarPedido(id);
			return ResponseEntity.ok(mensagem);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar pedido.");
		}
	}

	@GetMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Retornar um pedido em específico")
	public ResponseEntity<Pedido> buscarPedido(@PathVariable("id") Long id) {
		try {
			Pedido pedido = pedidoServ.buscarPeloId(id);
			return ResponseEntity.ok(pedido);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PatchMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Finalizar um pedido em específico")
	public ResponseEntity<String> finalizarPedido(@PathVariable("id") Long id) {
		try {
			String mensagem = pedidoServ.concluirPedido(id);
			return ResponseEntity.ok(mensagem);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao finalizar pedido.");
		}
	}

	@GetMapping
	@ResponseBody
	@Operation(summary = "Listar todos os pedidos")
	public ResponseEntity<List<Pedido>> listarPedidos() {
		List<Pedido> pedidos = pedidoServ.listarPedidos();
		return ResponseEntity.ok(pedidos);
	}

	@PostMapping("/{id}/item")
	@ResponseBody
	@Operation(summary = "Adicionar um item ao pedido em um cliente em específico")
	public ResponseEntity<String> adicionarItem(@PathVariable("id") Long id, @RequestParam Long livroId,
			@RequestParam int quantidade) {
		try {
			String mensagem = pedidoServ.adicionarItemAoPedido(id, livroId, quantidade);
			return ResponseEntity.ok(mensagem);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar item ao pedido.");
		}
	}

	@DeleteMapping("/{id}/item")
	@ResponseBody
	@Operation(summary = "Deletar um livro do pedido em um cliente em específico")
	public ResponseEntity<String> deletarItem(@PathVariable("id") Long id, @RequestParam Long itemId) {
		try {
			String mensagem = pedidoServ.deletarItemDoPedido(id, itemId);
			return ResponseEntity.ok(mensagem);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar item do pedido.");
		}
	}

	@GetMapping("/{id}/itens")
	@ResponseBody
	@Operation(summary = "Listar os itens do pedido de um cliente em específico")
	public ResponseEntity<List<Item>> listarItens(@PathVariable("id") Long id) {
		try {
			List<Item> itens = pedidoServ.listarItensDoPedido(id);
			return ResponseEntity.ok(itens);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
}
