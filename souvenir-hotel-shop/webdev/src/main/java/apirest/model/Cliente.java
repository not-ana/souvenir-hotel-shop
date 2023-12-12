package br.edu.iff.bsi.souvenirShop.apirest.model;

import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String senha;


    public Cliente(int id, String nome, String email, String senha) {
        this.id = id;
        this.is = nome;
        this.is = email;
        this.is = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public String setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public String setSenha(String senha) {
        this.senha = senha;
    }
    
}
