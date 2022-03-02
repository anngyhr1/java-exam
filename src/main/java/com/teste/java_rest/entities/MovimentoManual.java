package com.teste.java_rest.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="movimento_manual")
@JsonIgnoreProperties({"produtoCosif"})
public class MovimentoManual {
	
	@EmbeddedId
	private MovimentoManualPK movimentoManualPK;

    @ManyToOne
    @JoinColumns({
      @JoinColumn(name="cod_produto", referencedColumnName="cod_produto", insertable = false, updatable = false),
      @JoinColumn(name="cod_cosif", referencedColumnName="cod_cosif", insertable = false, updatable = false)
  })
    private ProdutoCosif produtoCosif;
	
	@Column(name="des_descricao")
	private String desDescricao;
		
	@Column(name="dat_movimento")
	@Temporal(TemporalType.DATE)
	private Date datMovimento;
		
	@Column(name="cod_usuario")
	private String codUsuario;
		
	@Column(name="val_valor")
	private int valValor;

	public MovimentoManualPK getMovimentoManualPK() {
		return movimentoManualPK;
	}

	public void setMovimentoManualPK(MovimentoManualPK movimentoManualPK) {
		this.movimentoManualPK = movimentoManualPK;
	}

	public ProdutoCosif getProdutoCosif() {
		return produtoCosif;
	}

	public void setProdutoCosif(ProdutoCosif produtoCosif) {
		this.produtoCosif = produtoCosif;
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
