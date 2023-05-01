package br.com.triplex.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.triplex.domain.model.Cidade;
import br.com.triplex.domain.repository.ICidadeRepository;
import br.com.triplex.domain.service.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeController {
	@Autowired
	private ICidadeRepository cidadeRepository;
	
	@Autowired	
	private  CidadeService cidadeService;
	
	@GetMapping
	public List<Cidade> listar(){
		return cidadeRepository.findAll();
	}
	 	
 
	@GetMapping("/{Id}")
	public Cidade buscar(@PathVariable Long Id) {
	 return cidadeService.buscarOuFalhar(Id);		
	}	
	
	@PostMapping
	public Cidade adicionar(@RequestBody Cidade cidade) {
		return cidadeService.salvar(cidade);
	}
	

	@PutMapping("/{Id}")
	public Cidade atualizar(@PathVariable Long Id, @RequestBody Cidade cidade ){		
	   Cidade cidadeAtual = cidadeService.buscarOuFalhar(Id);		
		BeanUtils.copyProperties(cidade, cidadeAtual, "id");		
		return cidadeService.salvar(cidadeAtual);		
	}
	
	
	@DeleteMapping("/{Id}")
	public void remover(@PathVariable Long Id){		
		cidadeService.excluir(Id);	  		
	}
}
