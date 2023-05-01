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

import br.com.triplex.domain.model.Estado;
import br.com.triplex.domain.model.Pais;
import br.com.triplex.domain.repository.IEstadoRepository;
import br.com.triplex.domain.service.EstadoService;

@RestController
@RequestMapping("/estado")
public class EstadoController {

	@Autowired
	private IEstadoRepository estadoRepository;
	
	@Autowired	
	private  EstadoService estadoService;
	
	@GetMapping
	public List<Estado> listar(){
		return estadoRepository.findAll();
	}
	 	
 
	@GetMapping("/{Id}")
	public Estado buscar(@PathVariable Long Id) {
	 return estadoService.buscarOuFalhar(Id);		
	}	
	
	@PostMapping
	public Estado adicionar(@RequestBody Estado pais) {
		return estadoService.salvar(pais);
	}
	

	@PutMapping("/{Id}")
	public Estado atualizar(@PathVariable Long Id, @RequestBody Pais cozinha ){		
	   Estado estadoAtual = estadoService.buscarOuFalhar(Id);		
		BeanUtils.copyProperties(cozinha, estadoAtual, "id");		
		return estadoService.salvar(estadoAtual);		
	}
	
	
	@DeleteMapping("/{Id}")
	public void remover(@PathVariable Long Id){		
		estadoService.excluir(Id);	  		
	}
}
