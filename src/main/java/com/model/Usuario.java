package com.model;

public class Usuario {
	    private int idUsuario;
	    private String username;
	    private String senha; 
	    private String nivelAcesso;  
	    private Pessoa pessoa;

	    public Usuario() {}

	    public Usuario(int idUsuario, String username, String senha, String nivelAcesso, Pessoa pessoa) {
	        this.idUsuario = idUsuario;
	        this.username = username;
	        this.senha = senha;
	        this.nivelAcesso = nivelAcesso;
	        this.pessoa = pessoa;
	    }
	    public int getIdUsuario() { return idUsuario; }
	    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

	    public String getUsername() { return username; }
	    public void setUsername(String username) { this.username = username; }

	    public String getSenha() { return senha; }
	    public void setSenha(String senha) { this.senha = senha; }

	    public String getNivelAcesso() { return nivelAcesso; }
	    public void setNivelAcesso(String nivelAcesso) { this.nivelAcesso = nivelAcesso; }

	    public Pessoa getPessoa() { return pessoa; }
	    public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }

	    public String getCargo() {
	        return this.nivelAcesso;
	    }

	    public static Usuario validarLogin(String username2, String senha2) {
	        return null;
	    }
}
