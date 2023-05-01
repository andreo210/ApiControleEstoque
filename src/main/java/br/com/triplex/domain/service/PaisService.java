package br.com.triplex.domain.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.triplex.domain.exception.EntidadeEmUsoException;
import br.com.triplex.domain.exception.EntidadeNaoEncontradaException;
import br.com.triplex.domain.model.Pais;
import br.com.triplex.domain.repository.IPaisRepository;

@Service
public class PaisService {

	@Autowired
	private IPaisRepository paisRepository;
	
	public Pais salvar(Pais pais) {
		return paisRepository.save(pais);
	}
	
	public void excluir(Long id) {
		try {
			paisRepository.deleteById(id);
			}catch (EmptyResultDataAccessException e) {
				throw new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de pais com o códogo %d", id));
			}		
			catch (DataIntegrityViolationException e) {
				throw new EntidadeEmUsoException(String.format("Pais de código %d não pode ser removida, pois esta em uso", id));
			}
	}
	
	public Pais buscarOuFalhar(Long id) {
		return paisRepository.findById(id)
				.orElseThrow(()-> new EntidadeNaoEncontradaException("Não existe cadastro de pais com o códogo %d"));
	}
}
