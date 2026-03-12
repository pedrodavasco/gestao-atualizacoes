package com.model;

public class Pessoa {
	private int idPessoa;
    private String nome;
    private String email;
    private String cargo;
    private Mudanca mudanca;

    public Pessoa() {}

    public Pessoa(int idPessoa, String nome, String email, String cargo, Mudanca mudanca) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.mudanca = mudanca;
    }
    
    public int getIdPessoa() { return idPessoa; }
    public void setIdPessoa(int idPessoa) { this.idPessoa = idPessoa; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public Mudanca getMudanca() { return mudanca; }
    public void setMudanca(Mudanca mudanca) { this.mudanca = mudanca; }

}
