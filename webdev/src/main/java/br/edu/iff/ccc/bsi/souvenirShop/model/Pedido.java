package br.edu.iff.ccc.bsi.souvenirShop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

@Entity
public class Pedido extends Item {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id;
	private float total;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_pedido")
    private Date dataPedido;
    
   
    
	@ManyToMany
	@JoinTable(name = "associacao_pedido_item",
				joinColumns = @JoinColumn(name = "fk_pedido"),
				inverseJoinColumns = @JoinColumn(name = "fk_item"))
	private List<Item> item = new ArrayList<>();
	//criando nossa lista de itens associada a pedidos
	
	
	@ManyToOne
	@JoinColumn(name ="entrega_id")
	private Entrega entrega;
	


	//aqui eu to passando todos os dados de cliente para pedido e dizendo que
    //o item vai criar um novo array pra cada item solicitado
    //e retornar dentro de pedido -> que é composto de vários itens + info do comprador
    /*public Pedido(String nome, String email, String telefone, String endereco) {
    	super(nome, email, telefone, endereco);
    	this.item = new ArrayList<>();
    }
    */
    
	//passando a verificacao de que para o pedido ser valido, o total (nesse caso total em valor) nao pode ser 0
    /*public Pedido(String email) {
    	this.total = 0;
    	this.item = new ArrayList<>();
    }
    */
    
    
    /*public String getdataPedido() {
    	if (dataPedido != null) {
    		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    		return dateFormat.format((dataPedido).getTime());
    	} else {
    		return "";
    	}
    }*/
    
    
    

    
    //gets e sets

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	
    public List<Item> getItem() {
		return item;
	}


	public void setItem(List<Item> item) {
		this.item = item;
	}


	public Entrega getEntrega() {
		return entrega;
	}


	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	
	
	
	public Pedido() {
		
	}

	public Pedido(String email) {

	}
    
}
