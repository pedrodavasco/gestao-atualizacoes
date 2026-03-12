package com.model;

import java.time.LocalDate;


public class Historico {
	private int idHistorico;
    private LocalDate dataAlteracao;
    private String descricaoAlteracao;
    private Mudanca mudanca;

    public Historico() {}

    public Historico(int idHistorico, LocalDate dataAlteracao, String descricaoAlteracao, Mudanca mudanca) {
        this.idHistorico = idHistorico;
        this.dataAlteracao = dataAlteracao;
        this.descricaoAlteracao = descricaoAlteracao;
        this.mudanca = mudanca;
    }
    public int getIdHistorico() { return idHistorico; }
    public void setIdHistorico(int idHistorico) { this.idHistorico = idHistorico; }

    public LocalDate getDataAlteracao() { return dataAlteracao; }
    public void setDataAlteracao(LocalDate dataAlteracao) { this.dataAlteracao = dataAlteracao; }

    public String getDescricaoAlteracao() { return descricaoAlteracao; }
    public void setDescricaoAlteracao(String descricaoAlteracao) { this.descricaoAlteracao = descricaoAlteracao; }

    public Mudanca getMudanca() { return mudanca; }
    public void setMudanca(Mudanca mudanca) { this.mudanca = mudanca; }

}
