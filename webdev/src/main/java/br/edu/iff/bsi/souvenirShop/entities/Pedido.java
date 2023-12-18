package br.edu.iff.bsi.souvenirShop.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

    private int id;
	private float total;
    private Date dataPedido;

	/*@ManyToMany
	@JoinTable(name = "associacao_item_pedido",
				joinColumns = @JoinColumn(name = "fk_item"),
				inverseJoinColumns = @JoinColumn(name = "fk_pedido"))
	private List<Item> item;*/

    /*public Pedido(int id, float total, Date dataPedido) {
        this.id = id;
        this.setTotal(total);
        this.setDataPedido(dataPedido);
    }*/

    public int getId() {
        return id;
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
