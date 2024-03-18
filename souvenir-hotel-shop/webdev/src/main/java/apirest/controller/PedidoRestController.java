package src.main.java.apirest.controller;

import java.util.List;


@RestController
@RequestMapping(path = "/pedido")
public class PedidoRestController {
    
    @GetMapping(path = "{id}")
    public String getPedido() {
        return "listar um pedido específico";
    }

    @PostMapping(path = "")
    public String postPedido() {
        return "pedido adicionado.";
    }

    @PutMapping(path = "/{id}")
    public String putPedido(){
        return "pedido atualizado.";
    }

    @DeleteMapping("/{id}")
}
