package br.edu.iff.ccc.bsi.souvenirShop.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@ManyToOne
	private Produto produto;
	
	

	@ManyToOne
	@JoinColumn(name = "pedido_id")
	@JsonBackReference
	private Pedido pedido;
	


	@NotNull
	@NotEmpty
	@Column(name = "quantidade")
	private int quantidade;

	
	public Item() {}
	
	


	public Item(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}







}
