package br.edu.iff.ccc.bsi.souvenirShop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Cliente implements Serializable { 
	//o serializable serve para salvar o estado atual dos objetos em arquivos formato binario
	//e depois recriar o obj em memoria igual no momento da serializacao!
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Size(min=1, max=40, message="Precisa conter entre 1 e 40 caracteres")
	@Column(name = "col_nome", length = 40)    /*decorator onde voce muda o nome da coluna*/
    private String nome;

		
	
	@Email(message="Nao pode ser branco ou nulo")
	@Column(name = "col_email", length = 60)
    private String email;
	
	
	
	@Nullable
	@ElementCollection	//esse elementcollection serve pra definir relacionamentos 1-n em um objeto embedded
	
	@Size(min=1,max=20,message="Tem que ter entre 0 e 2 telefones")
	@Column(length = 16)
	private List<@Pattern(regexp="\\([0-9]{2}\\) [0-9]{5}-[0-9]{4}", message="Deve seguir o padrão do Telefone")String> telefone = new ArrayList<String>();
    
	
	
	@Column(name = "col_endereco", length = 200)
	private String endereco;
    	
	
	
	
	@OneToOne()
	@JoinColumn(name="fk_cliente")
	private Usuario usuario;

	private String senha;

	
	public Cliente(Long id, String nome, String email, String telefone, String endereco, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone.add(telefone);
		this.endereco = endereco;
		this.senha = senha;
	}
	
	

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	public List<String> getTelefone() {
		return telefone;
	}


	public void setTelefone(List<String> telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
	
	
    //usuario também entra pq é uma associacao entre as duas classes
    public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

	public Cliente() {
    	//precisa ter um construtor vazio pq quando colocamos uma classe pra
    	//ser levantada pelo jpa ele instancia a classe depois		
	}


	@OneToMany
	@JoinColumn(name="id_cliente")
	private List<Pedido> pedido;

	public void addPedido(Pedido pedido) {
		this.pedido.add(pedido);
		
	}
	
	
	
}
    

    	 
  
    /*
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		
	}
	*/
    
