package src.main.java.apirest.controller;

import java.util.List;


@RestController
@RequestMapping(path = "/Vendedor")
public class VendedorRestController {
    
    @GetMapping(path = "{id}")
    public String getVendedor() {
        return "listar um vendedor específico";
    }

    @PostMapping(path = "")
    public StringvpostVendedor() {
        return "vendedor adicionado.";
    }

    @PutMapping(path = "/{id}")
    public String putVendedor(){
        return "vendedor atualizado.";
    }

    @DeleteMapping("/{id}")
}

    


}
