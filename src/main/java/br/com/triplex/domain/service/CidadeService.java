package br.com.triplex.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.triplex.domain.exception.EntidadeEmUsoException;
import br.com.triplex.domain.exception.EntidadeNaoEncontradaException;
import br.com.triplex.domain.model.Cidade;
import br.com.triplex.domain.repository.ICidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private ICidadeRepository cidadeRepository;
	
	public Cidade salvar(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}
	
	public void excluir(Long id) {
		try {
			cidadeRepository.deleteById(id);
			}catch (EmptyResultDataAccessException e) {
				throw new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cidade com o códogo %d", id));
			}		
			catch (DataIntegrityViolationException e) {
				throw new EntidadeEmUsoException(String.format("Estado de código %d não pode ser removida, pois esta em uso", id));
			}
	}
	
	public Cidade buscarOuFalhar(Long id) {
		return cidadeRepository.findById(id)
				.orElseThrow(()-> new EntidadeNaoEncontradaException("Não existe cadastro de estado com o códogo %d"));
	}
}
