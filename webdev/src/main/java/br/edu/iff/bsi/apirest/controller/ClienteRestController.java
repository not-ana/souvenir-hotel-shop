package br.edu.iff.bsi.apirest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/api/v1/cliente")
public class ClienteRestController {
    
	
	//A parte dos clientes específicos
	
    @PostMapping(path = "")
    @ResponseBody
    @Operation(summary = "Adicionar um cliente específico")
    public String adicionarCliente(String nome, String email, String telefone, String endereco) {
        return "Cliente" + nome + "adicionado";
    }
      
    @PutMapping(path = "/{id}")
    @ResponseBody
    @Operation(summary = "Atualizar um cliente específico")
    public String atualizarCliente(@PathVariable("id") Long id, String nome, String email, String telefone, String endereco){
        return "Cliente atualizado.";
    }    
    
    @GetMapping("/{id}")
    @ResponseBody
    @Operation(summary = "Retornar cliente específico")
    public String buscarCliente(@PathVariable("id") Long id) {
        return "Cliente retornado.";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @Operation(summary = "Deletar cliente específico")
    public String deletarCliente(@PathVariable("id") Long id) {
    	return "Cliente deletado.";
    }
    
    
    
    
    //Agora sobre os telefones
    
    @PostMapping(path = "")
    @ResponseBody
    @Operation(summary = "Listar todos os clientes")
    public String listarCliente() {
        return "Clientes listados";
    }
    
    @PostMapping(path = "{id}/telefone")
    @ResponseBody
    @Operation(summary = "Adicionar telefone a um cliente específico")
    public String adicionarTelefone(@PathVariable("id") Long id, String nome, String telefone) {
        return "Telefone adicionado ao cliente" + nome;
    }  
    
    @PostMapping(path = "{id}/telefone")
    @ResponseBody
    @Operation(summary = "Listar o(s) telefone(s) de um cliente específico")
    public String listarTelefone(@PathVariable("id") Long id, String telefone) {
        return "Telefone(s) listado(s)";
    }  
    
    @PostMapping(path = "{id}/telefone")
    @ResponseBody
    @Operation(summary = "Deletar o(s) telefone(s) de um cliente específico")
    public String deletarTelefone(@PathVariable("id") Long id, String telefone) {
        return "Telefone(s) deletado(s)";
    }  
    
}





