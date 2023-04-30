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

import br.com.triplex.domain.model.Pais;
import br.com.triplex.domain.repository.IPaisRepository;
import br.com.triplex.domain.service.PaisServive;

@RestController
@RequestMapping("/pais")
public class PaisController {

	@Autowired
	private IPaisRepository paisRepository;
	
	@Autowired	
	private  PaisServive paisService;
	
	@GetMapping
	public List<Pais> listar(){
		return paisRepository.findAll();
	}
	 	
 
	@GetMapping("/{Id}")
	public Pais buscar(@PathVariable Long Id) {
	 return paisService.buscarOuFalhar(Id);		
	}	
	
	@PostMapping
	public Pais adicionar(@RequestBody Pais pais) {
		return paisService.salvar(pais);
	}
	

	@PutMapping("/{Id}")
	public Pais atualizar(@PathVariable Long Id, @RequestBody Pais cozinha ){		
	   Pais cozinhaAtual = paisService.buscarOuFalhar(Id);		
		BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");		
		return paisService.salvar(cozinhaAtual);		
	}
	
	
	@DeleteMapping("/{Id}")
	public void remover(@PathVariable Long Id){		
		paisService.excluir(Id);	  		
	}
}
