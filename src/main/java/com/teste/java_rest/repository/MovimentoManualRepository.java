package com.teste.java_rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.teste.java_rest.entities.MovimentoManual;
import com.teste.java_rest.entities.MovimentoManualPK;

public interface MovimentoManualRepository extends CrudRepository<MovimentoManual, MovimentoManualPK> {

	@Query(value = "Select * FROM movimento_manual WHERE dat_ano = :dat_ano AND dat_mes = :dat_mes", nativeQuery = true)
	List<MovimentoManual> findByMovimentoManualPKDatAnoAndDatMes(@Param("dat_ano") String dat_ano, 
			@Param("dat_mes") String dat_mes);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM movimento_manual WHERE "
			+ "cod_cosif = :codCosif "
			+ "AND cod_produto = :cod_produto "
			+ "AND dat_mes = :dat_mes "
			+ "AND dat_ano = :dat_ano "
			+ "AND num_lancamento = :num_lancamento", nativeQuery = true)
	void deleteByProdutoCosifPK(@Param("codCosif") String codCosif, 
			@Param("cod_produto") String cod_produto,
			@Param("dat_ano") String dat_ano,
			@Param("dat_mes") String dat_mes,
			@Param("num_lancamento") String num_lancamento);
	

}
