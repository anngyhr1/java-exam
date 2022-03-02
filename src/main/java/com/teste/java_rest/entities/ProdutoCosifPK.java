package com.teste.java_rest.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProdutoCosifPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "cod_cosif")
	private String codCosif;
	@Column(name = "cod_produto")
	private String codProduto;
	
	public String getCodCosif() {
		return codCosif;
	}
	public void setCodCosif(String codCosif) {
		this.codCosif = codCosif;
	}
	public String getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}
}
