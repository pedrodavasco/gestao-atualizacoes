package com.model;
 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Mudanca {
	private int idMudanca;
    private String descricao;
    private String tipo;
    private String impacto;
    private String urgencia;
    private LocalDate dataSolicitacao;

    private List<PlanoEtapa> etapas;
    private List<Risco> riscos;
    private List<Resultado> resultados;
    private List<Historico> historicos;

    public Mudanca() {
        this.etapas = new ArrayList<>();
        this.riscos = new ArrayList<>();
        this.resultados = new ArrayList<>();
        this.historicos = new ArrayList<>();
    }

    public Mudanca(int idMudanca, String descricao, String tipo, String impacto,
            String urgencia, LocalDate dataSolicitacao) {
 this();
 this.idMudanca = idMudanca;
 this.descricao = descricao;
 this.tipo = tipo;
 this.impacto = impacto;
 this.urgencia = urgencia;
 this.dataSolicitacao = dataSolicitacao;
}public int getIdMudanca() { return idMudanca; }
public void setIdMudanca(int idMudanca) { this.idMudanca = idMudanca; }

public String getDescricao() { return descricao; }
public void setDescricao(String descricao) { this.descricao = descricao; }

public String getTipo() { return tipo; }
public void setTipo(String tipo) { this.tipo = tipo; }

public String getImpacto() { return impacto; }
public void setImpacto(String impacto) { this.impacto = impacto; }

public String getUrgencia() { return urgencia; }
public void setUrgencia(String urgencia) { this.urgencia = urgencia; }

public LocalDate getDataSolicitacao() { return dataSolicitacao; }
public void setDataSolicitacao(LocalDate dataSolicitacao) { this.dataSolicitacao = dataSolicitacao; }

public List<PlanoEtapa> getEtapas() { return etapas; }
public void setEtapas(List<PlanoEtapa> etapas) { this.etapas = etapas; }

public List<Risco> getRiscos() { return riscos; }
public void setRiscos(List<Risco> riscos) { this.riscos = riscos; }

public List<Resultado> getResultados() { return resultados; }
public void setResultados(List<Resultado> resultados) { this.resultados = resultados; }

public List<Historico> getHistoricos() { return historicos; }
public void setHistoricos(List<Historico> historicos) { this.historicos = historicos; }

public void adicionarEtapa(PlanoEtapa etapa) { this.etapas.add(etapa); }
public void adicionarRisco(Risco risco) { this.riscos.add(risco); }
public void adicionarResultado(Resultado resultado) { this.resultados.add(resultado); }
public void adicionarHistorico(Historico historico) { this.historicos.add(historico); }

public void cadastrar() {
    // TODO Auto-generated method stub
}


}
