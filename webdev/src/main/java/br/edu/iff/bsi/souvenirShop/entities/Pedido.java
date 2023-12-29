package br.edu.iff.bsi.souvenirShop.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Pedido extends Item {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

    private int id;
	private float total;
    private Date dataPedido;

	@ManyToMany(mappedBy="item")
	private List<Item> itensQueAparece;
	


    public Long getId() {
        return (long) id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	
	
	
	public Pedido() {
		
	}
    
}
