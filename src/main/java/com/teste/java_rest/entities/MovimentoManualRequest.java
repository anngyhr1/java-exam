package com.teste.java_rest.entities;

import java.util.Date;

public class MovimentoManualRequest {
	private int datMes;
	private int datAno;
	private int numLancamento;
	private String codProduto;
	private String codCosif;
	private String desDescricao;
	private Date datMovimento;
	private String codUsuario;
	private int valValor;
	
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
	public String getCodCosif() {
		return codCosif;
	}
	public void setCodCosif(String codCosif) {
		this.codCosif = codCosif;
	}
	public String getDesDescricao() {
		return desDescricao;
	}
	public void setDesDescricao(String desDescricao) {
		this.desDescricao = desDescricao;
	}
	public Date getDatMovimento() {
		return datMovimento;
	}
	public void setDatMovimento(Date datMovimento) {
		this.datMovimento = datMovimento;
	}
	public String getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}
	public int getValValor() {
		return valValor;
	}
	public void setValValor(int valValor) {
		this.valValor = valValor;
	}
}
