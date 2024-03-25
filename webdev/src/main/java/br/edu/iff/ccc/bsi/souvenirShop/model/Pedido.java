package br.edu.iff.ccc.bsi.souvenirShop.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

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
	
	
	@PastOrPresent(message="Não pode ser no futuro")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_pedido")
	private Calendar dataPedido;
		

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_entrega")
	private Calendar dataEntrega;
	
	
	@ManyToMany
	@JoinTable(name = "associacao_pedido_item",
				joinColumns = @JoinColumn(name = "fk_pedido"),
				inverseJoinColumns = @JoinColumn(name = "fk_item"))
	private List<Item> item;

	
	private boolean concluido;
	
	@NotBlank(message="Não pode ser em branco ou nulo")
	@Pattern(regexp="[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}", message="Deve seguir o padrão do CPF")
	private String cpfCliente = " ";
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	@JsonIgnore
	private Cliente cliente;
	
	
	public Pedido() {}
	
	
	

	public Pedido(String cpfCliente) {
		this.concluido = false;
		this.cpfCliente = cpfCliente;
		this.dataPedido = null;
		this.dataEntrega = null;
		this.item = new ArrayList<>();
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


	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
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


	public void concluir() {
		this.concluido = true;
		this.dataPedido = Calendar.getInstance();
		this.dataEntrega = Calendar.getInstance();
	}
	


	public String getDataPedido() {
		if (dataPedido != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return dateFormat.format(dataPedido.getTime());
        } else {
            return "";
        }
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}


	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}


	public String getCpfCliente() {
		return cpfCliente;
	}


	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	public void addItem(Item item) {
		this.item.add(item);
        subtotal += item.getQuantidade() * item.getProduto().getPreco();
	}

	
	public void removerItem(Item item) {
		this.item.remove(item);
        subtotal -= item.getQuantidade() * item.getProduto().getPreco();
	}
	
}
