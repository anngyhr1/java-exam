package com.teste.java_rest.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="produto_cosif")
@JsonIgnoreProperties({"produto","produtoCosifPK"})
public class ProdutoCosif {
	
	@EmbeddedId
    private ProdutoCosifPK produtoCosifPK;

    @JoinColumn(name = "cod_produto", referencedColumnName = "cod_produto", insertable = false, updatable = false)
    @ManyToOne
    private Produto produto;
    
    @OneToMany(mappedBy="produtoCosif")
    List<MovimentoManual> movimentoManualList;
    
    @Column(name = "cod_classificacao")
	private String codClassificacao;
    @Column(name = "sta_status")
	private String staStatus;
    
	public ProdutoCosifPK getProdutoCosifPK() {
		return produtoCosifPK;
	}
	public void setProdutoCosifPK(ProdutoCosifPK produtoCosifPK) {
		this.produtoCosifPK = produtoCosifPK;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public String getCodClassificacao() {
		return codClassificacao;
	}
	public void setCodClassificacao(String codClassificacao) {
		this.codClassificacao = codClassificacao;
	}
	public String getStaStatus() {
		return staStatus;
	}
	public void setStaStatus(String staStatus) {
		this.staStatus = staStatus;
	}
	public List<MovimentoManual> getMovimentoManualList() {
		return movimentoManualList;
	}
	public void setMovimentoManualList(List<MovimentoManual> movimentoManualList) {
		this.movimentoManualList = movimentoManualList;
	}

}
