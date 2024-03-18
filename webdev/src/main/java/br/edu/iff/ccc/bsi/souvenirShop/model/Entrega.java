package br.edu.iff.ccc.bsi.souvenirShop.model;

import java.util.Date;
import java.io.Serializable;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Entrega implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Date dataEntrega;
	
	
	@Enumerated(EnumType.ORDINAL)
	//@NotNull(message = "Tipo de entrega obrigatoria");
	@Embedded
	public void EntregaForma () {

	}
	
   
	public Date getData() {
		return dataEntrega;
	}

	public void setData(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
    public Entrega() {
    	
    }
}
