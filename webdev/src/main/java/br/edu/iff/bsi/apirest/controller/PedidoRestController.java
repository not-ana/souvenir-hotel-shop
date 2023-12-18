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
@RequestMapping(path = "/api/v1/pedido")
public class PedidoRestController {
    
	//Pedidos específicos
	
	@PostMapping(path = "")
    @ResponseBody
    @Operation(summary = "Adicionar pedido específico")
	public String adicionarPedido(int id) {
        return "Pedido adicionado.";
    }
    
    @PutMapping(path = "/{id}")
    @ResponseBody
    @Operation(summary = "Atualizar pedido específico")
    public String atualizarPedido(@PathVariable("id") Long id){
        return "Pedido atualizado.";
    }
    
    @GetMapping(path = "/{id}")
    @ResponseBody
    @Operation(summary = "Retornar pedido específico")
    public String buscarPedido(@PathVariable("id") Long id) {
        return "Pedido retornado.";
    }
    
    @DeleteMapping("/{id}")
    @ResponseBody
    @Operation(summary = "Deletar pedido específico")
    public String deletePedido(@PathVariable("id") Long id) {
    	return "Pedido deletado.";
    }
    
    
    //Pedidos gerais
    
    @GetMapping(path = "")
    @ResponseBody
    @Operation(summary = "Listar todos os pedidos")
    public String listarPedido() {
        return "Pedidos listados.";
    }
  
}
