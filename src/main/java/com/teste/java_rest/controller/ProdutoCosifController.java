package com.teste.java_rest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.teste.java_rest.entities.Produto;
import com.teste.java_rest.entities.ProdutoCosif;
import com.teste.java_rest.entities.ProdutoCosifPK;
import com.teste.java_rest.entities.ProdutoCosifRequest;
import com.teste.java_rest.repository.ProdutoCosifRepository;
import com.teste.java_rest.repository.ProdutoRepository;

@RestController
public class ProdutoCosifController {
	
	@Autowired
	ProdutoCosifRepository produtoCosifRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping(path = "/produtocosif")
	public List<ProdutoCosif> getAllProdutoCosif() {
		return (List<ProdutoCosif>) produtoCosifRepository.findAll();
	}
	
	@GetMapping(path = "/produtocosif/{code}")
	public List<ProdutoCosif> getAllProdutoCosifByCode(@PathVariable String code) {
		return (List<ProdutoCosif>) produtoCosifRepository.findByProdutoCosifPKCodCosif(code);
	}
	
	@PostMapping(path = "/produtocosif")
	public ResponseEntity<ProdutoCosif> createProdutoCosif(@RequestBody ProdutoCosifRequest produtoCosifRequest){
		
		Produto produto = produtoRepository.findByCodProduto(produtoCosifRequest.getProdutoCod()).get(0);
		
		ProdutoCosif produtoCosif = new ProdutoCosif();
		ProdutoCosifPK produtoCosifPk = new ProdutoCosifPK();
		
		produtoCosifPk.setCodProduto(produto.getCodProduto());
		produtoCosifPk.setCodCosif(produtoCosifRequest.getProdutoCosifCod());
		
		produtoCosif.setProdutoCosifPK(produtoCosifPk);
		produtoCosif.setProduto(produto);
		produtoCosif.setCodClassificacao(produtoCosifRequest.getCodClassificacao());
		produtoCosif.setStaStatus(produtoCosifRequest.getStaStatus());
		
		ProdutoCosif savedprodutoCosif = produtoCosifRepository.save(produtoCosif);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{id}").buildAndExpand(savedprodutoCosif.getProdutoCosifPK())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@Transactional
	@DeleteMapping("/produtocosif")
	public void deleteProdutoCosif(@RequestParam String codCosif, @RequestParam String codProduto) {
		produtoCosifRepository.deleteByProdutoCosifPK(codCosif, codProduto);
	}
}
