package com.teste.java_rest.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MovimentoManualPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Column(name="dat_mes")
	private int datMes;
	@Column(name="dat_ano")
	private int datAno;
	@Column(name="num_lancamento")
	private int numLancamento;
	@Column(name="cod_produto")
	private String codProduto;
	@Column(name="cod_cosif")
	private String codCosif;
	
	public int getDatMes() {
		return datMes;
	}
	public void setDatMes(int datMes) {
		this.datMes = datMes;
	}
	public int getDatAno() {
		return datAno;
	}
	public void setDatAno(int datAno) {
		this.datAno = datAno;
	}
	
	public String getCodCosif() {
		return codCosif;
	}
	public void setCodCosif(String codCosif) {
		this.codCosif = codCosif;
	}
	public int getNumLancamento() {
		return numLancamento;
	}
	public void setNumLancamento(int numLancamento) {
		this.numLancamento = numLancamento;
	}
	public String getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}
}
