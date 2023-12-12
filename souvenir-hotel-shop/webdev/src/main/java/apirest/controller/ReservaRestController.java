package src.main.java.apirest.controller;

import java.util.List;


@RestController
@RequestMapping(path = "/reserva")
public class ReservaRestController {
    
    @GetMapping(path = "{id}")
    public String getReserva() {
        return "listar uma reserva específica";
    }

    @PostMapping(path = "")
    public String postReserva() {
        return "reserva adicionada.";
    }

    @PutMapping(path = "/{id}")
    public String putReserva(){
        return "reserva atualizada.";
    }

    @DeleteMapping("/{id}")
}

    


}
