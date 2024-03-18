package br.edu.iff.ccc.bsi.souvenirShop.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	
	//A parte dos clientes específicos
	
    @PostMapping(path = "")
    @ResponseBody
    @Operation(summary = "Adicionar um cliente específico")
    public String addCliente(String nome, String email, String senha, String telefone, String endereco) throws Exception {
        return clienteServ.addCliente(new Cliente(null, nome, email, senha, telefone, endereco));
    }
      
    
    
    @PutMapping(path = "/{id}")
    @ResponseBody
    @Operation(summary = "Atualizar um cliente específico")
    public String atualizarCliente(@PathVariable("id") Long id, String nome, String email, String telefone, String endereco){
        Cliente clienteBusca = clienteServ.getClientePeloId(id);
        if(clienteBusca==null) {
        	return "Cliente nao encontrado";
        } else {
        	return clienteServ.atualizarCliente(clienteBusca.getEmail(), nome, endereco); //acho que aqui poderia passar os outros metodos
        }
    }    
    
    
    
    @GetMapping("/{id}")
    @ResponseBody
    @Operation(summary = "Retornar cliente específico")
    public Cliente buscarCliente(@PathVariable("id") Long id) throws Exception{
    	return clienteServ.getClientePeloId(id);
    }
    
    
    

    @DeleteMapping("/{id}")
    @ResponseBody
    @Operation(summary = "Deletar cliente específico")
    public String deletarClienteEmail(@PathVariable("id") Long id) throws Exception {
    	Cliente clienteBusca = clienteServ.getClientePeloId(id);
    	if(clienteBusca==null) {
    		return "Cliente nao encontrado";
    	}
    	else {
    		return clienteServ.deletarCliente(clienteBusca.getEmail());
    	}
    }
  
    
    @GetMapping(path = "")
    @ResponseBody
    @Operation(summary = "Listar todos os clientes")
    public String listarCliente() {
        return "Clientes listados";
    }
    
    
    
    
    //Agora sobre os telefones
    
    @PostMapping(path = "{id}/telefone")
    @ResponseBody
    @Operation(summary = "Adicionar telefone a um cliente específico")
    public String adicionarTelefone(@PathVariable("id") Long id, String nome, String telefone) {
        return "Telefone adicionado ao cliente" + nome;
    }  
    
    @GetMapping(path = "{id}/telefone")
    @ResponseBody
    @Operation(summary = "Listar o(s) telefone(s) de um cliente específico")
    public String listarTelefone(@PathVariable("id") Long id, String telefone) {
        return "Telefone(s) listado(s)";
    }  
    
    @DeleteMapping(path = "{id}/telefone")
    @ResponseBody
    @Operation(summary = "Deletar o(s) telefone(s) de um cliente específico")
    public String deletarTelefone(@PathVariable("id") Long id, String telefone) {
        return "Telefone(s) deletado(s)";
    }  
    
}





