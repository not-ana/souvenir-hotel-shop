package br.edu.iff.bsi.souvenirShop.entities;

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
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "col_nome", length = 40)    /*decorator onde voce muda o nome da coluna*/
	@Size(min=1,max=40,message="Entre 1 e 40 caracteres")
    private String nome;
	
	
	@Email(message="Nao pode ser branco ou nulo")
    private String email;
	
	@Nullable
	@ElementCollection
	@Size(min=1,max=20,message="Tem que ter entre 0 e 2 telefones")
	@Column(length = 16)
	private List<@Pattern(regexp="\\([0-9]{2}\\) [0-9]{5}-[0-9]{4}", message="Deve seguir o padrão do Telefone")String> telefone = new ArrayList<String>();
    
	
	private String endereco;
    	
	
	
	//relacionamento
	
	@OneToOne()
	@JoinColumn(name="fk_cliente")
	private Usuario usuario;
	
	
	//gets e sets
	
    public Long getId() {
        return (long) id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String setNome(String nome) {
        return this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public String setEmail(String email) {
        return this.email = email;
    }


	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	

	public List <String> getTelefone() {
		return telefone;
	}

	public void setTelefone(List <String> telefone) {
		this.telefone = telefone;
	}
	
	
    public Cliente() {
    	/*precisa ter um construtor vazio pq
    	 * quando colocamos uma classe pra
    	 * ser levantada pelo jpa ele instancia a classe depois
    	 */
    }
    
}
