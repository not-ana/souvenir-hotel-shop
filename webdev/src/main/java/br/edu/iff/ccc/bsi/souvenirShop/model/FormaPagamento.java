package br.edu.iff.ccc.bsi.souvenirShop.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class FormaPagamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    
	private Long id;
	
	
	@NotBlank(message="Nao pode ser nem branco nem nulo")
	@NotNull
    private Boolean tipo;



	//
	//
	//    PRECISA
	//		TERMINAR
	//
	//
	
	
	//gets and sets
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getTipo() {
		return tipo;
	}

	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}

	
	public FormaPagamento() {

    }
}
