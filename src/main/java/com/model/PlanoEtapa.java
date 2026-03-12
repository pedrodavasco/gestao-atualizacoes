package com.model;

import java.util.Date;


public class PlanoEtapa {
	 private int idEtapa;
	    private String descricao;
	    private Date dataPrevista;
	    private String status;
	    private Mudanca mudanca;

	    public PlanoEtapa() {}

	    public PlanoEtapa(int idEtapa, String descricao, Date dataPrevista, String status, Mudanca mudanca) {
	        this.idEtapa = idEtapa;
	        this.descricao = descricao;
	        this.dataPrevista = dataPrevista;
	        this.status = status;
	        this.mudanca = mudanca;
	    }
	    public int getIdEtapa() { return idEtapa; }
	    public void setIdEtapa(int idEtapa) { this.idEtapa = idEtapa; }

	    public String getDescricao() { return descricao; }
	    public void setDescricao(String descricao) { this.descricao = descricao; }

	    public Date getDataPrevista() { return dataPrevista; }
	    public void setDataPrevista(Date dataPrevista) { this.dataPrevista = dataPrevista; }

	    public String getStatus() { return status; }
	    public void setStatus(String status) { this.status = status; }

	    public Mudanca getMudanca() { return mudanca; }
	    public void setMudanca(Mudanca mudanca) { this.mudanca = mudanca; }

}
