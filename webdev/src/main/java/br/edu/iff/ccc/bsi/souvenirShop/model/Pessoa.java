package br.edu.iff.ccc.bsi.souvenirShop.model;

import java.io.Serializable;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public class Pessoa implements Serializable { 

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank(message = "Não pode ser em branco ou nulo")
	@Pattern(regexp = "[0-9]{11}", message = "Deve seguir o padrão do CPF")
	@Column(unique = true, length = 11)
	private String cpf;
	
	
	@Size(min = 1, max = 40, message = "Precisa conter entre 1 e 40 caracteres")
	@Column(name = "nome", length = 40)   
    private String nome;

	
	@Email(message = "Nao pode ser branco ou nulo. Tem que ser em formato de email")
	@Column(name = "email", length = 60)
    private String email;
	
	
	@Nullable
	@Size(min = 1, max = 20/*, message = "Tem que ter entre 0 e 2 telefones"*/)
	@Column(name = "telefone", length = 16)
	private String telefone;
    
	
	@Column(name = "endereco", length = 200)
	private String endereco;

	
	/*
	@OneToOne
	@JoinColumn(name = "fk_cliente")
	private Login logins;
	*/
	
	/*
	@OneToMany
	@JoinColumn(name = "id_cliente")
	private List<Pedido> pedidos;
	*/
	
	
	@ManyToOne()
	@JoinColumn(name = "pessoa_fk")
	private Usuario usuario;
	
	
	public Pessoa() {}



	public Pessoa(String cpf, String nome, String email, String telefone, String endereco) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}



	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
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


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
    
    
