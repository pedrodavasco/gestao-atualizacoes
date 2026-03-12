package com.model;

public class Resultado {
	 private int idResultado;
	    private String descricao;
	    private boolean sucesso;
	    private String efeitosColaterais;
	    private Mudanca mudanca;

	    public Resultado() {}

	    public Resultado(int idResultado, String descricao, boolean sucesso, String efeitosColaterais, Mudanca mudanca) {
	        this.idResultado = idResultado;
	        this.descricao = descricao;
	        this.sucesso = sucesso;
	        this.efeitosColaterais = efeitosColaterais;
	        this.mudanca = mudanca;
	    }
	    public int getIdResultado() { return idResultado; }
	    public void setIdResultado(int idResultado) { this.idResultado = idResultado; }

	    public String getDescricao() { return descricao; }
	    public void setDescricao(String descricao) { this.descricao = descricao; }

	    public boolean isSucesso() { return sucesso; }
	    public void setSucesso(boolean sucesso) { this.sucesso = sucesso; }

	    public String getEfeitosColaterais() { return efeitosColaterais; }
	    public void setEfeitosColaterais(String efeitosColaterais) { this.efeitosColaterais = efeitosColaterais; }

	    public Mudanca getMudanca() { return mudanca; }
	    public void setMudanca(Mudanca mudanca) { this.mudanca = mudanca; }

}
