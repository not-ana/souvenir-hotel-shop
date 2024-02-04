package br.edu.iff.ccc.bsi.souvenirShop.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Item extends Produto {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int quantidade;
    private float preço;

    
	@ManyToMany
	@JoinTable(name = "associacao_item_pedido",
				joinColumns = @JoinColumn(name = "fk_item"),
				inverseJoinColumns = @JoinColumn(name = "fk_pedido"))
	private List<Pedido> pedido;
	
	
	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="produto_id")
	//private List<Produto> produtosQueAparece;
	private List<Produto> produto;*/
	
	
    
    
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
	

}
