package com.model;

public class Risco {
	 private int idRisco;
	    private String descricao;
	    private String mitigacao;
	    private Mudanca mudanca;

	    public Risco() {}

	    public Risco(int idRisco, String descricao, String mitigacao, Mudanca mudanca) {
	        this.idRisco = idRisco;
	        this.descricao = descricao;
	        this.mitigacao = mitigacao;
	        this.mudanca = mudanca;
	    }
	    public int getIdRisco() { return idRisco; }
	    public void setIdRisco(int idRisco) { this.idRisco = idRisco; }

	    public String getDescricao() { return descricao; }
	    public void setDescricao(String descricao) { this.descricao = descricao; }

	    public String getMitigacao() { return mitigacao; }
	    public void setMitigacao(String mitigacao) { this.mitigacao = mitigacao; }

	    public Mudanca getMudanca() { return mudanca; }
	    public void setMudanca(Mudanca mudanca) { this.mudanca = mudanca; }

}
