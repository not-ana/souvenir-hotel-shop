package br.edu.iff.bsi.souvenirShop.entities;

import java.util.Date;
import java.io.Serializable;

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
	private EntregaForma forma;
	
   
	public Date getData() {
		return dataEntrega;
	}

	public void setData(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
    public Entrega() {
    	
    }
}