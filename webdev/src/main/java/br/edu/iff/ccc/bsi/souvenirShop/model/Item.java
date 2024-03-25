package br.edu.iff.ccc.bsi.souvenirShop.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_item", unique=true)
    private Long id;
	
	@NotNull
	@NotEmpty
	@Column(name = "quantidade")
	private int quantidade;

	@NotNull
	@NotEmpty
	@Column(name = "subtotal")
	private double subtotal;
	
	
	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	@ManyToMany(mappedBy="item")
	private List<Pedido> pedido;
	
	@ManyToOne
	@JoinColumn(name="id_produto")
	private Produto produto;
	
	
	public Item(int quantidade, double subtotal) {
		super();
		this.quantidade = quantidade;
		this.subtotal = 0;
	}




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


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	/*
	public void adicionarItem(Produto produto) {
		this.produto.add(produto);
		this.quantidade++;
		this.subtotal = produto.getPreco()*quantidade;
	}
	
	public void removerItem(Produto produto) {
		this.produto.remove(produto);
		this.quantidade--;
		this.subtotal = produto.getPreco()*quantidade;
	}

	public List<Produto> getProduto() {
		return produto;
	}
	*/
	
}
