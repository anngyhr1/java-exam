package com.teste.java_rest.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Produto {
	
	@Id
	@Column(name="cod_produto")
	private String codProduto;
	@Column(name="des_produto")
	private String desProduto;
	@Column(name="sta_status")
	private String staStatus;
	
	@OneToMany(mappedBy="produto")
	List<ProdutoCosif> ProdutoCosifList;
	
	public String getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}
	public String getDesProduto() {
		return desProduto;
	}
	public void setDesProduto(String desProduto) {
		this.desProduto = desProduto;
	}
	public String getStaStatus() {
		return staStatus;
	}
	public void setStaStatus(String staStatus) {
		this.staStatus = staStatus;
	}
	public List<ProdutoCosif> getProdutoCosifList() {
		return ProdutoCosifList;
	}
	public void setProdutoCosifList(List<ProdutoCosif> produtoCosifList) {
		ProdutoCosifList = produtoCosifList;
	}


}
