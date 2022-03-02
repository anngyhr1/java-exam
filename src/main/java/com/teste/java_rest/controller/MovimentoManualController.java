package com.teste.java_rest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.teste.java_rest.entities.MovimentoManual;
import com.teste.java_rest.entities.MovimentoManualPK;
import com.teste.java_rest.entities.MovimentoManualRequest;
import com.teste.java_rest.entities.Produto;
import com.teste.java_rest.entities.ProdutoCosif;
import com.teste.java_rest.entities.ProdutoCosifPK;
import com.teste.java_rest.entities.ProdutoCosifRequest;
import com.teste.java_rest.repository.MovimentoManualRepository;
import com.teste.java_rest.repository.ProdutoCosifRepository;
import com.teste.java_rest.repository.ProdutoRepository;
@RestController
public class MovimentoManualController {
	@Autowired
	ProdutoCosifRepository produtoCosifRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	MovimentoManualRepository movimentoManualRepository;
	
	@GetMapping(path = "/movimento-manual")
	public List<MovimentoManual> getAllMovimentoManual() {
		return (List<MovimentoManual>) movimentoManualRepository.findAll();
	}
	
	@GetMapping(path = "/movimento-manual?ano=ano&mes=mes")
	public List<MovimentoManual> getAllMovimentoManualBycodCosifAndcodProduto(@RequestParam String ano, @RequestParam String mes) {
		return (List<MovimentoManual>) movimentoManualRepository.findByMovimentoManualPKDatAnoAndDatMes(ano, mes);
	}
	
	@PostMapping(path = "/movimento-manual")
	public ResponseEntity<MovimentoManual> createMovimentoManual(@RequestBody MovimentoManualRequest movimentoManualRequest){
		
		ProdutoCosifPK produtoCosifPK = new ProdutoCosifPK();
		produtoCosifPK.setCodCosif(movimentoManualRequest.getCodCosif());
		produtoCosifPK.setCodProduto(movimentoManualRequest.getCodProduto());
		Optional<ProdutoCosif> produtoCosif = (Optional<ProdutoCosif>) produtoCosifRepository.findById(produtoCosifPK);
		
		if(produtoCosif.get() != null) {
			MovimentoManualPK movimentoManualPK = new MovimentoManualPK();
			movimentoManualPK.setCodCosif(movimentoManualRequest.getCodCosif());
			movimentoManualPK.setCodProduto(movimentoManualRequest.getCodProduto());
			movimentoManualPK.setDatAno(movimentoManualRequest.getDatAno());
			movimentoManualPK.setDatMes(movimentoManualRequest.getDatMes());
			movimentoManualPK.setNumLancamento(movimentoManualRequest.getNumLancamento());
			
			MovimentoManual movimentoManual = new MovimentoManual();
			movimentoManual.setMovimentoManualPK(movimentoManualPK);
			movimentoManual.setCodUsuario(movimentoManualRequest.getCodUsuario());
			movimentoManual.setDesDescricao(movimentoManualRequest.getDesDescricao());
			movimentoManual.setValValor(movimentoManualRequest.getValValor());
			
			MovimentoManual savedmovimentoManual = movimentoManualRepository.save(movimentoManual);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("{id}").buildAndExpand(savedmovimentoManual.getMovimentoManualPK())
					.toUri();
			
			return ResponseEntity.created(location).build();
		}
		
		return ResponseEntity.notFound().build();
	}
	

	
	@Transactional
	@DeleteMapping("/movimento-manual")
	public void deleteProdutoCosif(@RequestParam String codCosif, @RequestParam String codProduto) {
		//deleteByIdToInstAndIdRelInvstid codCosif codProduto
		produtoCosifRepository.deleteByProdutoCosifPK(codCosif, codProduto);
	}
}
