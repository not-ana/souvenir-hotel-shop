package br.edu.iff.ccc.bsi.souvenirShop.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_pedido", unique=true)
    private Long id;
	
	
	@NotNull
	@NotEmpty
	@Column(name = "subtotal", unique=false)
	@Transient
	private double subtotal;
	
	
	@NotNull
	@NotEmpty
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_pedido")
	private LocalDateTime dataPedido;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_entrega")
	private LocalDateTime dataEntrega;
	
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Item> itens;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 30, message = "Tipo deve ter entre 3 e 30 caracteres")
	private String formaPagamento;
	
	
	private boolean concluido;
	
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	@JsonIgnore
	private Cliente cliente;
	
	
	public Pedido() {}
	
	


	public Pedido(Cliente cliente, String formaPagamento) {
		this.cliente = cliente;
		this.subtotal = 0;
		this.dataPedido = null;
		this.dataEntrega = null;
		this.itens = new ArrayList<>();
		this.formaPagamento = formaPagamento;
		this.concluido = false;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	public LocalDateTime getDataPedido() {
		return dataPedido;
	}


	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}


	public LocalDateTime getDataEntrega() {
		return dataEntrega;
	}


	public void setDataEntrega(LocalDateTime dataEntrega) {
		this.dataEntrega = dataEntrega;
	}


	public List<Item> getItens() {
		return itens;
	}


	public void setItens(List<Item> itens) {
		this.itens = itens;
	}


	public String getFormaPagamento() {
		return formaPagamento;
	}


	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}


	public boolean isConcluido() {
		return concluido;
	}


	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}

	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public boolean Concluido() {
		return concluido;
	}

	public void concluir() {
		this.concluido = true;
		this.dataPedido = LocalDateTime.now();
		this.dataEntrega = LocalDateTime.now();
	}


}
