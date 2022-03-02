package com.teste.java_rest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.teste.java_rest.entities.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, String> {

	List<Produto> findByStaStatus(String status);

	List<Produto> findByCodProduto(String codigo);
	
	void deleteByCodProduto(String codigo);
}
