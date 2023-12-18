package br.edu.iff.bsi.souvenirShop.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int quantidade;
    private float preço;

	/*@ManyToMany(mappedBy="pedido")
	private List<Pedido> pedido;*/
	
    /*public Item(int id,int quantidade, float preço) {
        this.id = (long) id;
        this.quantidade = quantidade;
        this.preço = preço;
    }*/
    
    
    
    //gets e sets
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreço() {
		return preço;
	}

	public void setPreço(float preço) {
		this.preço = preço;
	}
	
	
	
	public Item() {
		
	}
    
}
