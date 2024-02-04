package br.edu.iff.ccc.bsi.souvenirShop.controller.apirest;

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
    
	//Pedidos específicos
	
	@PostMapping(path = "")
    @ResponseBody
    @Operation(summary = "Adicionar pedido específico")
	public String addPedido(String email) throws Exception {  //nao vou passar o email como chave pq pode ter pedido sem cliente relacionado
        return pedidoServ.addPedido(email);
    }
	
    
    @PutMapping(path = "/{id}")
    @ResponseBody
    @Operation(summary = "Atualizar pedido específico")
    public String atualizarPedido(@PathVariable("id") Long id, String email) throws Exception {
        return pedidoServ.atualizarPedido(id, email);
    }
    
    
    @GetMapping(path = "/{id}")
    @ResponseBody
    @Operation(summary = "Retornar pedido específico")
    public String buscarPedido(@PathVariable("id") Long id) throws Exception {
        return pedidoServ.getPedidoById(id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseBody
    @Operation(summary = "Deletar um pedido específico")
    public String deletePedido(@PathVariable("id") Long id) throws Exception {
    	return pedidoServ.deletarPedido(id);
    }
    
    
    //Pedidos gerais
    
    @GetMapping(path = "")
    @ResponseBody
    @Operation(summary = "Listar todos os pedidos")
    public List<Pedido> listarPedido() throws Exception {
        return pedidoServ.listarPedido();
    }
  
}
