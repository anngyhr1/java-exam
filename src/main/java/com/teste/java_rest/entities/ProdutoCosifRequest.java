package com.teste.java_rest.entities;

public class ProdutoCosifRequest {
	private String produtoCod;
	private String produtoCosifCod;
	private String codClassificacao;
	private String staStatus;
	public String getProdutoCod() {
		return produtoCod;
	}
	public void setProdutoCod(String produtoCod) {
		this.produtoCod = produtoCod;
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
	public String getProdutoCosifCod() {
		return produtoCosifCod;
	}
	public void setProdutoCosifCod(String produtoCosifCod) {
		this.produtoCosifCod = produtoCosifCod;
	}
}
