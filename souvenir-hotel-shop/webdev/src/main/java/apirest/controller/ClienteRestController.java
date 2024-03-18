package src.main.java.apirest.controller;

import java.util.List;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteRestController {
    
    @GetMapping("/{id}")
    public String getCliente() {
        return "retornar cliente específico.";
    }
    
    @PostMapping(path = "")
    public String postCliente() {
        return "cliente adicionado.";
    }

    @PutMapping(path = "/{id}")
    public String putCliente(){
        return "cliente atualizado.";
    }

    @DeleteMapping("/{id}")
}





