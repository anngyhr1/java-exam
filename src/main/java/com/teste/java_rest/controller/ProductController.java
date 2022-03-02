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
import com.teste.java_rest.repository.ProdutoRepository;

@RestController
public class ProductController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping(path = "/produtos")
	public List<Produto> getAllProdutos() {
		return (List<Produto>) produtoRepository.findAll();
	}
	
	@GetMapping(path = "/produtos/codigo/{codigo}")
	public List<Produto> getAllProdutosByCodigo(@PathVariable String codigo) {
		return (List<Produto>) produtoRepository.findByCodProduto(codigo);
	}
	
	@GetMapping(path = "/produtos?status={status}")
	public List<Produto> getAllProdutosAtivos(@RequestParam String status) {
		return (List<Produto>) produtoRepository.findByStaStatus(status);
	}
	
	@PostMapping(path = "/produtos")
	public ResponseEntity<Produto> createProduto(@RequestBody Produto produto){
		Produto savedProduto = produtoRepository.save(produto);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{id}").buildAndExpand(savedProduto.getCodProduto())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@Transactional
	@DeleteMapping("/produtos/{codigo}")
	public void deleteProduto(@PathVariable String codigo) {
		produtoRepository.deleteByCodProduto(codigo);
	}
	


}
