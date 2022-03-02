package com.teste.java_rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.teste.java_rest.entities.ProdutoCosif;
import com.teste.java_rest.entities.ProdutoCosifPK;

public interface ProdutoCosifRepository extends CrudRepository<ProdutoCosif, ProdutoCosifPK> {
	
	List<ProdutoCosif> findByProdutoCosifPKCodCosif(String cosifcode);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM produto_cosif pc WHERE cod_cosif = :codCosif AND cod_produto = :codProduto", nativeQuery = true)
	void deleteByProdutoCosifPK(@Param("codCosif") String codCosif, 
			@Param("codProduto") String codProduto);

}
