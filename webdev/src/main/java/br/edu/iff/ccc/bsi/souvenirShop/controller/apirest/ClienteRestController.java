package br.edu.iff.ccc.bsi.souvenirShop.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.souvenirShop.model.Cliente;
import br.edu.iff.ccc.bsi.souvenirShop.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/api/v1/cliente")
public class ClienteRestController {
	
	@Autowired
	public ClienteService clienteServ;
	
	
	@PostMapping("")
	@ResponseBody
	@Operation(summary = "Adicionar um cliente")
	public String addCliente(String nome, String email, String cpf, String senha, String telefone) throws Exception {			
		return clienteServ.addCliente(new Cliente(nome, email, cpf, senha, telefone));
	}
	
	
	@PutMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Atualizar um cliente em expecifíco")
	public String atualizarCliente(@PathVariable("id") Long id, String cpf, String nome, String email, String telefone, String endereco) throws Exception {
		Cliente cBusca = clienteServ.buscarPeloId(id);
		if(cBusca==null) {			
			return "Cliente não achado";
		}else {
			return clienteServ.atualizarCliente(id, cpf, nome, email, telefone, endereco);
		}
	}	
	
	
	

	/*
	@PostMapping
	@ResponseBody
	@Operation(summary = "Adicionar um cliente em específico")
	public ResponseEntity<String> adicionarCliente(@RequestParam String login, @RequestParam String senha,
			@RequestParam String cpf, @RequestParam String nome, @RequestParam String email,
			@RequestParam String telefone, @RequestParam String endereco) {
		try {
			String mensagem = clienteServ.addCliente(login, senha, cpf, nome, email, telefone, endereco);
			return ResponseEntity.ok(mensagem);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar cliente.");
		}
	}

	@PutMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Atualizar um cliente em específico")
	public ResponseEntity<String> atualizarCliente(@PathVariable Long id, @RequestParam String cpf,
			@RequestParam String nome, @RequestParam String email, @RequestParam String endereco) {
		try {
			String mensagem = clienteServ.atualizarCliente(id, cpf, nome, email, endereco);
			return ResponseEntity.ok(mensagem);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar cliente.");
		}
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Deletar um cliente em específico")
	public ResponseEntity<String> deletarCliente(@PathVariable Long id) {
		try {
			String mensagem = clienteServ.deletarCliente(id);
			return ResponseEntity.ok(mensagem);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar cliente.");
		}
	}

	@GetMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Retornar um cliente em específico")
	public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id) {
		try {
			Cliente cliente = clienteServ.buscarPeloId(id);
			return ResponseEntity.ok(cliente);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping
	@ResponseBody
	@Operation(summary = "Listar todos os clientes")
	public ResponseEntity<List<Cliente>> listarClientes() {
		List<Cliente> clientes = clienteServ.listarClientes();
		return ResponseEntity.ok(clientes);
	}
	*/
    
}





